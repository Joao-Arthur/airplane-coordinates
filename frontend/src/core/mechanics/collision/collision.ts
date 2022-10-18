import { linearFunction } from '../../linearFunction';

type vectorType = {
    readonly speed: number;
    readonly initialPoint: number;
}

type paramsType = {
    readonly a: vectorType;
    readonly b: vectorType;
}

export function collision({ a, b }: paramsType) {
    return linearFunction.findInsersectionPoint({
        fx: { a: a.speed, b: a.initialPoint },
        gx: { a: b.speed, b: b.initialPoint },
    });
}
