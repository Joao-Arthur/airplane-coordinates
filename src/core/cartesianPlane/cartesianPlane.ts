import { distance } from './distance';
import { fromPolar } from './fromPolar';

export const cartesianPlane = {
    distance,
    fromPolar,
} as const;
