import { fromPoint } from './fromPoint';
import { findInsersectionPoint } from './findInsersectionPoint';
import { execute } from './execute';

export const linearFunction = {
    fromPoint,
    findInsersectionPoint,
    execute,
} as const;
