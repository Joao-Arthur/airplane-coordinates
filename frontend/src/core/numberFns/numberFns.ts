import { fix } from './fix';
import { between } from './between';
import { prettyFormat } from './prettyFormat';

export const numberFns = {
    fix,
    between,
    prettyFormat,
} as const;
