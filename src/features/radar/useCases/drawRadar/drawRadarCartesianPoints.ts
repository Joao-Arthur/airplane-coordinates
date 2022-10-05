import { cartesianPlane } from '../../../../core/cartesianPlane';
import { radarContextType } from './radarContext';

export function drawRadarCartesianPoints({
    drawContext,
    dimensions,
    settings: { numberOfParts },
}: radarContextType) {
    cartesianPlane.relativePoints({ dimensions, numberOfParts })
        .forEach(({ vertical, horizontal }) => {
            drawContext.drawSquare(
                { ...vertical, width: 1, height: dimensions.height },
                '#ddd',
            );
            drawContext.drawSquare(
                { ...horizontal, width: dimensions.width, height: 1 },
                '#ddd',
            );
        });
}
