import { describe, expect, it } from 'vitest';
import { toScale } from './toScale';

describe('toScale', () => {
    it('should set number to fixed scale', () => {
        expect(toScale(0.6666666, 7)).toBe(0.6666666);
        expect(toScale(0.6666666, 6)).toBe(0.666667);
        expect(toScale(0.6666666, 5)).toBe(0.66667);
        expect(toScale(0.6666666, 4)).toBe(0.6667);
        expect(toScale(0.6666666, 3)).toBe(0.667);
        expect(toScale(0.6666666, 2)).toBe(0.67);

        expect(toScale(0.7071067811865476, 14)).toBe(0.70710678118655);
        expect(toScale(0.7071067811865475, 14)).toBe(0.70710678118655);
        expect(toScale(-0.7071067811865477, 14)).toBe(-0.70710678118655);
        expect(toScale(-0.7071067811865475, 14)).toBe(-0.70710678118655);
        expect(toScale(0.7071067811865483, 14)).toBe(0.70710678118655);
        expect(toScale(0.7071067811865467, 14)).toBe(0.70710678118655);
    });
});
