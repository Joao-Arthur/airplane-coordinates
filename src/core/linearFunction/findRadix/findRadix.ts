import { numberFns } from '../../numberFns';
import { linearFunctionType } from '../types';

export function findRadix(fx: linearFunctionType): number {
    return numberFns.normalizeZero(Number.isFinite(fx.a) ? -fx.b / fx.a : fx.b);
}
