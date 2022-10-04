import { pipe } from 'ramda';

type paramsType = {
    readonly value: number;
    readonly min: number;
    readonly max: number;
}

export function between({ value, min, max }: paramsType) {
    return pipe(
        newValue => Math.min(newValue, max),
        newValue => Math.max(newValue, min),
    )(value);
}
