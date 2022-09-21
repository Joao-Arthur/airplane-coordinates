import { distance } from './distance';
import { fromPolar } from './fromPolar';
import { scalonate } from './scalonate';
import { translate } from './translate';

export const cartesianPlane = {
    distance,
    fromPolar,
    scalonate,
    translate
} as const;
