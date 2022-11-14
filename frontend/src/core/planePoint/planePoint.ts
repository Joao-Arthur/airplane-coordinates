import { toPolar } from './toPolar';
import { toCartesian } from './toCartesian';
import { fromPolar } from './fromPolar';
import { fromCartesian } from './fromCartesian';

export const planePoint = {
    toPolar,
    toCartesian,
    fromPolar,
    fromCartesian,
} as const;
