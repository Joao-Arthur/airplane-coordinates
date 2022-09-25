import { dimensionType } from "../../models/dimension";
import { drawContextType } from "../../ports/drawContext";

export function radarView(drawContext: drawContextType, { x, y, width, height }: dimensionType) {
    drawCenter(drawContext, { x, y, width, height });
    drawRadarPoints(drawContext, { x, y, width, height });
}

function drawCenter(drawContext: drawContextType, { width, height }: dimensionType) {
    drawContext.drawSquare({ x: width / 2 - 4, y: height / 2 - 4, width: 8, height: 8 }, '#00aa6f');
}

function drawRadarPoints(drawContext: drawContextType, { width, height }: dimensionType) {
    const numberOfParts = 20;
    const halfNumberOfParts = numberOfParts / 2;
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;
    for (let i = 0; i <= halfNumberOfParts; i++) {
        drawContext.drawSquare({ x: widthSize * i, y: 0, width: 1, height }, '#0602db');
        drawContext.drawSquare({ x: widthSize * (i + halfNumberOfParts) - 1, y: 0, width: 1, height }, '#0602db');
        drawContext.drawSquare({ x: 0, y: heightSize * i, width, height: 1 }, '#0602db');
        drawContext.drawSquare({ x: 0, y: heightSize * (i + halfNumberOfParts) - 1, width, height: 1 }, '#0602db');
    }
}