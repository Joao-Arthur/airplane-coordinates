import { toScale } from './toScale';
import { normalizeZero } from './normalizeZero';
import { fix } from './fix';
import { between } from './between';

export const numberFns = {
    toScale,
    normalizeZero,
    fix,
    between,
} as const;
