import { describe, expect, it } from 'vitest';
import { limitDecimals } from './limitDecimals';

describe('limitDecimals', () => {
    it('should return the value when no decimal places', () => {
        expect(limitDecimals(3)).toBe('3');
        expect(limitDecimals(-0.0)).toBe('0');
    });

    it('should return the value when one decimal place', () => {
        expect(limitDecimals(33.1)).toBe('33.1');
        expect(limitDecimals(-0.1)).toBe('-0.1');
    });

    it('should return the value when two decimal places', () => {
        expect(limitDecimals(10.22)).toBe('10.22');
        expect(limitDecimals(-3.44)).toBe('-3.44');
    });

    it('should round to the max of two digits', () => {
        expect(limitDecimals(8.99999)).toBe('9');
        expect(limitDecimals(-3.299)).toBe('-3.3');
        expect(limitDecimals(10.111)).toBe('10.11');
        expect(limitDecimals(10.229)).toBe('10.23');
        expect(limitDecimals(12.91216)).toBe('12.91');
    });
});
