import { dimensionType } from '../dimension';
import { cartesianPointType } from '../cartesianPoint';

type paramsType = {
    readonly dimensions: dimensionType;
    readonly position: cartesianPointType;
    readonly numberOfParts: number;
};


export function relativeToAbsolute({ dimensions, position, numberOfParts }: paramsType): cartesianPointType {
    const widthSize = dimensions.width / numberOfParts;
    const heightSize = dimensions.height / numberOfParts;
    const halfNumberOfParts = numberOfParts / 2;

    return {
        x: halfNumberOfParts * widthSize + position.x * widthSize,
        y: halfNumberOfParts * heightSize - position.y * heightSize,
    };
}
