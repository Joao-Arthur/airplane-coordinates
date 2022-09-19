import { describe, expect, it } from 'vitest';
import { transform } from './transform';

describe('transform', () => {
    it('should transform the dimensions', () => {
        expect(transform({
            point: { x: 4, y: 7 },
            factor: { x: 2, y: -3, }
        })).toEqual({ x: 6, y: 4 });

        expect(transform({
            point: { x: -1, y: 3 },
            factor: { x: 2, y: -3, }
        })).toEqual({ x: 1, y: 0 });

        expect(transform({
            point: { x: 4, y: 7 },
            factor: { x: 0, y: 0, }
        })).toEqual({ x: 4, y: 7 });

        expect(transform({
            point: { x: -1, y: 3 },
            factor: { x: 0, y: 0, }
        })).toEqual({ x: -1, y: 3, });
    })
})