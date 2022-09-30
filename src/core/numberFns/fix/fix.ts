import { pipe } from 'ramda';
import { normalizeZero } from '../normalizeZero';
import { toScale } from '../toScale';

export function fix(initialValue: number) {
    return pipe(
        value => toScale(value, 10),
        value => normalizeZero(value),
    )(initialValue);
}
