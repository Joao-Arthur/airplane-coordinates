import { describe, expect, it } from 'vitest';
import { rotate } from './rotate';

describe('rotate', () => {
    it('should rotate a point', () => {
        expect(rotate({ point: { r: 1, a: 300 }, angle: 50 })).toEqual({ r: 1, a: 350 });
        expect(rotate({ point: { r: 1, a: 200 }, angle: 50 })).toEqual({ r: 1, a: 250 });
        expect(rotate({ point: { r: 1, a: 111.11 }, angle: 11.40 })).toEqual({ r: 1, a: 122.51 });
        expect(rotate({ point: { r: 1, a: 34.02 }, angle: 19.04 })).toEqual({ r: 1, a: 53.06 });
        expect(rotate({ point: { r: 1, a: 60 }, angle: -120 })).toEqual({ r: 1, a: 300 });
        expect(rotate({ point: { r: 1, a: 60 }, angle: -60 })).toEqual({ r: 1, a: 0 });

    });
});
