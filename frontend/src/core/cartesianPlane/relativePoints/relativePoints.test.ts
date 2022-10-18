import { describe, expect, it } from 'vitest';
import { relativePoints } from './relativePoints';

describe('relativePoints', () => {
    it('should return relative points', () => {
        expect(relativePoints({
            dimensions: { width: 250, height: 250 },
            numberOfParts: 4,
        })).toEqual([
            { vertical: { x: 0, y: 0 }, horizontal: { x: 0, y: 250 } },
            { vertical: { x: 62.5, y: 0 }, horizontal: { x: 0, y: 187.5 } },
            { vertical: { x: 125, y: 0 }, horizontal: { x: 0, y: 125 } },
            { vertical: { x: 187.5, y: 0 }, horizontal: { x: 0, y: 62.5 } },
            { vertical: { x: 250, y: 0 }, horizontal: { x: 0, y: 0 } },
        ]);
        expect(relativePoints({
            dimensions: { width: 250, height: 250 },
            numberOfParts: 3,
        })).toEqual([
            {
                vertical: { x: 41.66666666666667, y: 0 },
                horizontal: { x: 0, y: 208.33333333333331 },
            },
            { vertical: { x: 125, y: 0 }, horizontal: { x: 0, y: 125 } },
            {
                vertical: { x: 208.33333333333331, y: 0 },
                horizontal: { x: 0, y: 41.66666666666667 },
            },
            {
                vertical: { x: 291.66666666666663, y: 0 },
                horizontal: { x: 0, y: -41.66666666666666 },
            },
        ]);
    });
});
