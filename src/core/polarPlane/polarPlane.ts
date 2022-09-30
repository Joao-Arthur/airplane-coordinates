import { fromCartesian } from './fromCartesian';
import { rotate } from './rotate';

export const polarPlane = {
    fromCartesian,
    rotate,
} as const;
