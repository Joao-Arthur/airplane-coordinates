import { arrayFns } from '../../arrayFns';
import { cartesianPlane } from '../cartesianPlane';
import { dimensionType } from '../dimension';

type paramsType = {
    readonly dimensions: dimensionType;
    readonly numberOfParts: number;
}

export function relativePoints({ dimensions, numberOfParts }: paramsType) {
    return arrayFns
        .range(0, numberOfParts)
        .map(i => i - Math.trunc(numberOfParts / 2))
        .map(i => ({
            vertical: cartesianPlane
                .relativeToAbsolute({
                    position: { x: i, y: numberOfParts / 2 },
                    dimensions,
                    numberOfParts,
                }),
            horizontal: cartesianPlane
                .relativeToAbsolute({
                    position: { x: -numberOfParts / 2, y: i },
                    dimensions,
                    numberOfParts,
                }),
        } as const));
}
