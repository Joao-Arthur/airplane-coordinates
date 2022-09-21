import { describe, expect, it } from 'vitest';
import { translate } from './translate';

describe('translate', () => {
    it('should translate the dimensions', () => {
        expect(translate({
            point: { x: 4, y: 7 },
            factor: { x: 2, y: -3, }
        })).toEqual({ x: 6, y: 4 });

        expect(translate({
            point: { x: -1, y: 3 },
            factor: { x: 2, y: -3, }
        })).toEqual({ x: 1, y: 0 });

        expect(translate({
            point: { x: 4, y: 7 },
            factor: { x: 0, y: 0, }
        })).toEqual({ x: 4, y: 7 });

        expect(translate({
            point: { x: -1, y: 3 },
            factor: { x: 0, y: 0, }
        })).toEqual({ x: -1, y: 3, });
    })
})