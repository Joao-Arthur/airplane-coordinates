import { linearFunctionType } from '../types';

export function execute(fx: linearFunctionType, x: number) {
    return fx.a * x + fx.b;
}
