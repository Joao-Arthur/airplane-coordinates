import { describe, expect, it } from 'vitest';
import { findInsersectionPoint } from './findInsersectionPoint';

describe('findInsersectionPoint', () => {
    it('should return the intersection point', () => {
        expect(findInsersectionPoint({
            fx: { a: 1, b: 0 },
            gx: { a: -1, b: 0 },
        })).toEqual({ x: 0, y: 0 });

        expect(findInsersectionPoint({
            fx: { a: 2, b: 5 },
            gx: { a: -2, b: 5 },
        })).toEqual({ x: 0, y: 5 });

        expect(findInsersectionPoint({
            fx: { a: 5, b: 5 },
            gx: { a: -0.5, b: 10.5 },
        })).toEqual({ x: 1, y: 10 });

        expect(findInsersectionPoint({
            fx: { a: 5, b: 5 },
            gx: { a: -0.5, b: 10.5 },
        })).toEqual({ x: 1, y: 10 });
    });
});
