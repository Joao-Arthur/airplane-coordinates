import { fromPoint } from './fromPoint';
import { intersect } from './intersect';
import { findRadix } from './findRadix';

export const linearFunction = {
    fromPoint,
    intersect,
    findRadix,
} as const;
