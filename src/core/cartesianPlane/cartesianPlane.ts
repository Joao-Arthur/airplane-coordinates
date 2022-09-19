import { distance } from './distance';
import { fromPolar } from './fromPolar';
import { scalonate } from './scalonate';
import { transform } from './transform';

export const cartesianPlane = {
    distance,
    fromPolar,
    scalonate,
    transform
} as const;
