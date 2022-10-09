import { describe, expect, it } from 'vitest';
import { findRoot } from './findRoot';

describe('findRoot', () => {
    it('should return the radix of x function', () => {
        expect(findRoot({ a: 1, b: -2 })).toEqual(2);
        expect(findRoot({ a: 1, b: -1 })).toEqual(1);
        expect(findRoot({ a: 1, b: 0 })).toEqual(0);
        expect(findRoot({ a: 1, b: 1 })).toEqual(-1);
        expect(findRoot({ a: 1, b: 2 })).toEqual(-2);
    });

    it('should return the radix of 2x function', () => {
        expect(findRoot({ a: 2, b: -2 })).toEqual(1);
        expect(findRoot({ a: 2, b: -1 })).toEqual(0.5);
        expect(findRoot({ a: 2, b: 0 })).toEqual(0);
        expect(findRoot({ a: 2, b: 1 })).toEqual(-0.5);
        expect(findRoot({ a: 2, b: 2 })).toEqual(-1);
    });

    it('should return the radix of 0.5x function', () => {
        expect(findRoot({ a: 0.5, b: -2 })).toEqual(4);
        expect(findRoot({ a: 0.5, b: -1 })).toEqual(2);
        expect(findRoot({ a: 0.5, b: 0 })).toEqual(0);
        expect(findRoot({ a: 0.5, b: 1 })).toEqual(-2);
        expect(findRoot({ a: 0.5, b: 2 })).toEqual(-4);
    });

    it('should return the radix of -0.25x function', () => {
        expect(findRoot({ a: -0.25, b: -2 })).toEqual(-8);
        expect(findRoot({ a: -0.25, b: -1 })).toEqual(-4);
        expect(findRoot({ a: -0.25, b: 0 })).toEqual(0);
        expect(findRoot({ a: -0.25, b: 1 })).toEqual(4);
        expect(findRoot({ a: -0.25, b: 2 })).toEqual(8);
    });

    it('should return the radix of infinite function', () => {
        expect(findRoot({ a: Number.POSITIVE_INFINITY, b: -2 })).toEqual(-2);
        expect(findRoot({ a: Number.POSITIVE_INFINITY, b: -1 })).toEqual(-1);
        expect(findRoot({ a: Number.POSITIVE_INFINITY, b: 0 })).toEqual(0);
        expect(findRoot({ a: Number.POSITIVE_INFINITY, b: 1 })).toEqual(1);
        expect(findRoot({ a: Number.POSITIVE_INFINITY, b: 2 })).toEqual(2);
    });

});
