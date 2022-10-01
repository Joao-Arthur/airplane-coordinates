import { pipe } from 'ramda';

type paramsType = {
    value: number;
    min: number;
    max: number;
}

export function between({ value, min, max }: paramsType) {
    return pipe(
        newValue => Math.min(newValue, max),
        newValue => Math.max(newValue, min),
    )(value);
}
