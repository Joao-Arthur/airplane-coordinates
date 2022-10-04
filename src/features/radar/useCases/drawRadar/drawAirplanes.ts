import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';

export function drawAirplanes(drawContext: drawContextType, { width, height }: dimensionType, airplanes: readonly airplaneType[]) {
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
                height: dimension,
            },
            '#ff0000',
        );
}
