import { cartesianPlane } from '../../../../core/cartesianPlane';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';

const airportSize = 6;

export function drawAirport(drawContext: drawContextType, { width, height }: dimensionType) {
    const airportDimensions = cartesianPlane.pointToSquare(
        {
            point: {
                x: width / 2,
                y: height / 2,
            },
            size: airportSize,
        },
    );
    drawContext.drawCircle(airportDimensions, '#6260bd');
}
