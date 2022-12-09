import { standard } from 'funis';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { planePoint } from '../../../../core/planePoint';
import { cartesianPointType } from '../../../../core/cartesianPlane/cartesianPoint';
import { airplaneType } from '../../../airplane/models';
import { radarContextType } from './radarContext';

const airplaneSize = 50;

export function drawAirplanes({
    drawContext,
    dimensions,
    settings: { numberOfParts },
}: radarContextType, airplanes: readonly airplaneType[]) {
    for (const airplane of airplanes)
        standard.pipe(
            (position: cartesianPointType) => cartesianPlane.relativeToAbsolute({
                dimensions,
                position,
                numberOfParts,
            }),
            point => cartesianPlane.pointToSquare({
                point,
                size: airplaneSize,
            }),
            airportDimensions => drawContext.drawImage(
                airportDimensions,
                '/airplane.png',
                Number(airplane.vector.direction),
            ),
        )(planePoint.toCartesian(airplane.point));
}
