import { distance } from './distance';
import { fromPolar } from './fromPolar';
import { scalonate } from './scalonate';
import { translate } from './translate';
import { relativeToAbsolute } from './relativeToAbsolute';
import { pointToSquare } from './pointToSquare';
import { relativePoints } from './relativePoints';

export const cartesianPlane = {
    distance,
    fromPolar,
    scalonate,
    translate,
    relativeToAbsolute,
    pointToSquare,
    relativePoints,
} as const;
