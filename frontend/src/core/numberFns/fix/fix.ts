import { standard } from 'funis';
import { normalizeZero } from '../normalizeZero';
import { toScale } from '../toScale';

export function fix(initialValue: number) {
    return standard.pipe(
        (value: number) => toScale(value, 10),
        value => normalizeZero(value),
    )(initialValue);
}
