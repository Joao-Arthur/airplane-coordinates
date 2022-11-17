import { fix } from './fix';
import { between } from './between';
import { ellipsis } from './ellipsis';
import { limitDecimals } from './limitDecimals';
import { formatHours } from './formatHours';

export const numberFns = {
    fix,
    between,
    ellipsis,
    limitDecimals,
    formatHours,
} as const;
