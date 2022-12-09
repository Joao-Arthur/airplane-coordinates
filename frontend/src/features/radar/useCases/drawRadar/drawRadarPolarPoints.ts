import { numbers } from 'funis';
import { radarContextType } from './radarContext';

export function drawRadarPolarPoints({
    drawContext,
    dimensions: { width, height },
    settings: { numberOfParts },
}: radarContextType) {
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;
    numbers
        .range(0, numberOfParts)
        .forEach(i =>
            drawContext.drawRing(
                {
                    x: width / 2 - (widthSize * i) / 2,
                    y: height / 2 - (heightSize * i) / 2,
                    width: (widthSize * i),
                    height: (heightSize * i),
                },
                '#ddd',
            ),
        );
}
