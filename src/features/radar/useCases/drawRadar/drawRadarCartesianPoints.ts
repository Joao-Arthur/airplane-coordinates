import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';

export function drawRadarCartesianPoints(drawContext: drawContextType, { width, height }: dimensionType) {
    const numberOfParts = 20;
    const halfNumberOfParts = numberOfParts / 2;
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;
    for (let i = 0; i <= halfNumberOfParts; i++) {
        drawContext.drawSquare({ x: widthSize * i, y: 0, width: 1, height }, '#5c5c5c');
        drawContext.drawSquare({ x: widthSize * (i + halfNumberOfParts) - 1, y: 0, width: 1, height }, '#5c5c5c');
        drawContext.drawSquare({ x: 0, y: heightSize * i, width, height: 1 }, '#5c5c5c');
        drawContext.drawSquare({ x: 0, y: heightSize * (i + halfNumberOfParts) - 1, width, height: 1 }, '#5c5c5c');
    }
}
