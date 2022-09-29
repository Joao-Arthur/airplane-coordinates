import { airplaneType } from "../../../airplane/models";
import { dimensionType } from "../../models/dimension";
import { drawContextType } from "../../ports/drawContext";

export function drawRadar(drawContext: drawContextType, { x, y, width, height }: dimensionType, airplanes: readonly airplaneType[]) {
    clearWindow(drawContext, { x, y, width, height });
    drawRadarPoints(drawContext, { x, y, width, height });
    drawCenter(drawContext, { x, y, width, height });
    drawAirplanes(drawContext, { x, y, width, height }, airplanes)
}

function clearWindow(drawContext: drawContextType, { x, y, width, height }: dimensionType,) {
    drawContext.drawSquare({ x, y, width, height }, '#ffffff');
}

function drawCenter(drawContext: drawContextType, { width, height }: dimensionType) {
    const centerSize = 8;
    drawContext.drawCircle({ x: width / 2 - (centerSize / 2), y: height / 2 - (centerSize / 2), width: centerSize, height: centerSize }, '#6260bd');
}

function drawRadarPoints(drawContext: drawContextType, { width, height }: dimensionType) {
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

function drawAirplanes(drawContext: drawContextType, { x, y, width, height }: dimensionType, airplanes: readonly airplaneType[]) {
    const numberOfParts = 20;
    const widthSize = width / numberOfParts;
    const heightSize = height / numberOfParts;
    const halfNumberOfParts = numberOfParts / 2;

    const dimension = 6;

    for (const airplane of airplanes)
        drawContext.drawSquare(
            {
                x: halfNumberOfParts * widthSize + airplane.x * widthSize - dimension / 2,
                y: halfNumberOfParts * heightSize + airplane.y * heightSize - dimension / 2,
                width: dimension,
                height: dimension
            },
            '#ff0000'
        );
}