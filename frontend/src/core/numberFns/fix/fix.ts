import { pipe } from 'funis';
import { normalizeZero } from '../normalizeZero';
import { toScale } from '../toScale';

export function fix(initialValue: number) {
    return pipe(
        (value: number) => toScale(value, 10),
        value => normalizeZero(value),
    )(initialValue);
}
