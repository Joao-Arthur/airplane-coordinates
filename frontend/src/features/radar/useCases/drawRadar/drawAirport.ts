import { cartesianPlane } from '../../../../core/cartesianPlane';
import { radarContextType } from './radarContext';

const airportSize = 6;

export function drawAirport({ drawContext, dimensions: { width, height } }: radarContextType) {
    const airportDimensions = cartesianPlane.pointToSquare({
        point: {
            x: width / 2,
            y: height / 2,
        },
        size: airportSize,
    });
    drawContext.drawCircle(airportDimensions, '#6260bd');
}
