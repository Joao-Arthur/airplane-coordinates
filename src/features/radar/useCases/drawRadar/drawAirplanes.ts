import { airplaneType } from '../../../airplane/models';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { pipe } from 'ramda';
import { radarContextType } from './radarContext';

const airplaneSize = 6;

export function drawAirplanes({
    drawContext,
    dimensions,
    settings: { numberOfParts },
}: radarContextType, airplanes: readonly airplaneType[]) {
    for (const airplane of airplanes)
        pipe(
            position => cartesianPlane.relativeToAbsolute({
                dimensions,
                position,
                numberOfParts,
            }),
            point => cartesianPlane.pointToSquare(
                {
                    point,
                    size: airplaneSize,
                },
            ),
            airportDimensions => drawContext.drawSquare(airportDimensions, '#ff0000'),
        )({ x: airplane.x, y: airplane.y });
}
