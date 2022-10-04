import { arrayFns } from '../../../../core/arrayFns';
import { radarContextType } from './radarContext';

export function drawRadarCartesianPoints({
    drawContext,
    dimensions: { width, height },
    settings: { numberOfParts },
}: radarContextType) {
    const halfNumberOfParts = numberOfParts / 2;
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;
    arrayFns
        .range(0, halfNumberOfParts)
        .forEach(i => {
            drawContext.drawSquare({ x: widthSize * i, y: 0, width: 1, height }, '#5c5c5c');
            drawContext.drawSquare({ x: widthSize * (i + halfNumberOfParts) - 1, y: 0, width: 1, height }, '#5c5c5c');
            drawContext.drawSquare({ x: 0, y: heightSize * i, width, height: 1 }, '#5c5c5c');
            drawContext.drawSquare({ x: 0, y: heightSize * (i + halfNumberOfParts) - 1, width, height: 1 }, '#5c5c5c');
        });
}
