import { fix } from './fix';
import { ellipsis } from './ellipsis';
import { limitDecimals } from './limitDecimals';
import { formatHours } from './formatHours';

export const numberFns = {
    fix,
    ellipsis,
    limitDecimals,
    formatHours,
} as const;
