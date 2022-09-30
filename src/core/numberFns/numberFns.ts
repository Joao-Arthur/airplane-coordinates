import { toScale } from './toScale';
import { normalizeZero } from './normalizeZero';
import { fix } from './fix';

export const numberFns = {
    toScale,
    normalizeZero,
    fix,
} as const;
