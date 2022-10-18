import { linearFunctionType } from '../types';
import { BadFunctionError } from './BadFunctionError';

export function execute(fx: linearFunctionType, x: number) {
    if (!Number.isFinite(fx.a))
        throw new BadFunctionError();
    return fx.a * x + fx.b;
}
