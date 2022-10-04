import { arrayFns } from '../../../../core/arrayFns';
import { radarContextType } from './radarContext';

export function drawRadarPolarPoints({
    drawContext,
    dimensions: { width, height },
    settings: { numberOfParts },
}: radarContextType) {
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;

    function drawCircles() {
        arrayFns
            .range(0, numberOfParts)
            .forEach(i =>
                drawContext.drawRing(
                    {
                        x: width / 2 - (widthSize * i) / 2,
                        y: height / 2 - (heightSize * i) / 2,
                        width: (widthSize * i),
                        height: (heightSize * i),
                    }, '#5c5c5c'),
            );
    }

    function drawLines() {
        drawContext.drawSquare({
            x: 0,
            y: height / 2 - 1,
            width,
            height: 2,
        }, '#5c5c5c');
        drawContext.drawSquare({
            x: width / 2 - 1,
            y: 0,
            width: 2,
            height,
        }, '#5c5c5c');



    }

    drawCircles();
    drawLines();
}
