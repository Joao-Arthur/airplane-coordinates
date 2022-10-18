import { describe, expect, it } from 'vitest';
import { pointToSquare } from './pointToSquare';

describe('pointToSquare', () => {
    it('should transform a point to a square', () => {
        expect(pointToSquare({
            point: { x: 50, y: 50 },
            size: 4,
        })).toEqual({ x: 48, y: 48, width: 4, height: 4 });
        expect(pointToSquare({
            point: { x: 0, y: 0 },
            size: 4,
        })).toEqual({ x: -2, y: -2, width: 4, height: 4 });
        expect(pointToSquare({
            point: { x: 48, y: 3 },
            size: 1,
        })).toEqual({ x: 47.5, y: 2.5, width: 1, height: 1 });
    });
});
