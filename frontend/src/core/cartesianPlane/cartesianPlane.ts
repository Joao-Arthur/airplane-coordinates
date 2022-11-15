import { fromPolar } from './fromPolar';
import { relativeToAbsolute } from './relativeToAbsolute';
import { pointToSquare } from './pointToSquare';
import { relativePoints } from './relativePoints';

export const cartesianPlane = {
    fromPolar,
    relativeToAbsolute,
    pointToSquare,
    relativePoints,
} as const;
