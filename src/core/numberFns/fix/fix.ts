import { pipe } from "ramda";
import { normalizeZero } from "../normalizeZero";
import { toScale } from "../toScale";

export function fix(initialValue: number) {
    return pipe(
        value => normalizeZero(value),
        value => toScale(value, 14)
    )(initialValue);
}