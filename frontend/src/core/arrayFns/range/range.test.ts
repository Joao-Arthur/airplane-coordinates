import { describe, expect, it } from 'vitest';
import { range } from './range';

describe('range', () => {
    it('should return a range of integer numbers', () => {
        expect(range(0, 0)).toEqual([0]);
        expect(range(0, 1)).toEqual([0, 1]);
        expect(range(0, 2)).toEqual([0, 1, 2]);
        expect(range(7664, 7665)).toEqual([7664, 7665]);
        expect(range(6, 8)).toEqual([6, 7, 8]);
        expect(range(-100, -99)).toEqual([-100, -99]);
    });
});
