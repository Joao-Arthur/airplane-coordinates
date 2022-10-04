import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { pipe } from 'ramda';

export function drawAirplanes(drawContext: drawContextType, dimensions: dimensionType, airplanes: readonly airplaneType[]) {
    const numberOfParts = 20;
    const airplaneSize = 6;

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
            airportDimensions => drawContext.drawSquare(airportDimensions, '#6260bd'),
        )({ x: airplane.x, y: airplane.y });
}
