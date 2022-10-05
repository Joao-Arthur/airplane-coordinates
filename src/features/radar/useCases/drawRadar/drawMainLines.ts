import { radarContextType } from './radarContext';

export function drawMainLines({
    drawContext,
    dimensions: { width, height },
}: radarContextType) {
    function drawMiddleLines() {
        drawContext.drawSquare({ x: 0, y: height / 2 - 1, width, height: 2 }, '#bbb');
        drawContext.drawSquare({ x: width / 2 - 1, y: 0, width: 2, height }, '#bbb');
    }

    function drawBorderLines() {
        drawContext.drawSquare({ x: 0, y: 0, width, height: 1 }, '#bbb');
        drawContext.drawSquare({ x: 0, y: 0, width: 1, height }, '#bbb');
        drawContext.drawSquare({ x: 0, y: height - 1, width, height: 1 }, '#bbb');
        drawContext.drawSquare({ x: width - 1, y: 0, width: 1, height }, '#bbb');
    }

    drawMiddleLines();
    drawBorderLines();
}
