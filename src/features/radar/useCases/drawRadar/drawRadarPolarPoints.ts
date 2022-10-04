import { dimensionType } from '../../models/dimension';
import { drawContextType } from '../../ports/drawContext';

const numberOfParts = 20;

export function drawRadarCartesianPoints(drawContext: drawContextType, { width, height }: dimensionType) {


    drawContext.drawCircle({ x: widthSize * i, y: 0, width: 1, height }, '#5c5c5c');

    drawContext.drawCircle({ x: width / 2 - (airportSize / 2), y: height / 2 - (airportSize / 2), width: airportSize, height: airportSize }, '#6260bd');


    for (let i = 0; i <= halfNumberOfParts; i++) {
        drawContext.drawCircle({ x: widthSize * (i + halfNumberOfParts) - 1, y: 0, width: 1, height }, '#5c5c5c');
        drawContext.drawCircle({ x: 0, y: heightSize * i, width, height: 1 }, '#5c5c5c');
        drawContext.drawCircle({ x: 0, y: heightSize * (i + halfNumberOfParts) - 1, width, height: 1 }, '#5c5c5c');
    }
}
