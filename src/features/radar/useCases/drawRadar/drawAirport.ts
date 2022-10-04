import { dimensionType } from '../../models/dimension';
import { drawContextType } from '../../ports/drawContext';

const airportSize = 8;

export function drawAirport(drawContext: drawContextType, { width, height }: dimensionType) {
    drawContext.drawCircle({ x: width / 2 - (airportSize / 2), y: height / 2 - (airportSize / 2), width: airportSize, height: airportSize }, '#6260bd');
}
