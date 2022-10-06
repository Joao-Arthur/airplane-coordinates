import { numberFns } from '../../numberFns';
import { linearFunctionType } from '../types';

export function findRadix(fx: linearFunctionType): number {
    return numberFns.normalizeZero(-fx.b / fx.a);
}
