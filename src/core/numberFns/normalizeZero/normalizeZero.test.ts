import { describe, expect, it } from 'vitest';
import { normalizeZero } from './normalizeZero';

describe('normalizeZero', () => {
    it('should return 0 when -0 is passed', () => {
        expect(normalizeZero(-0)).toBe(0);
    });

    it('should return the same value passed', () => {
        expect(normalizeZero(0)).toBe(0);
        expect(normalizeZero(NaN)).toBe(NaN);
        expect(normalizeZero(-Infinity)).toBe(-Infinity);
        expect(normalizeZero(Infinity)).toBe(Infinity);
    });

    it('should return the same number passed', () => {
        expect(normalizeZero(38)).toBe(38);
        expect(normalizeZero(-10)).toBe(-10);
    });
});
