import { describe, expect, it } from 'vitest';
import { fromCartesian } from './fromCartesian';

describe('fromCartesian', () => {
    it('should transform the point on the four axis', () => {
        expect(fromCartesian({ x: 1, y: 0 })).toEqual({ r: 1, a: 0 });
        expect(fromCartesian({ x: 0, y: 1 })).toEqual({ r: 1, a: 90 });
        expect(fromCartesian({ x: -1, y: 0 })).toEqual({ r: 1, a: 180 });
        expect(fromCartesian({ x: 0, y: -1 })).toEqual({ r: 1, a: 270 });
        expect(fromCartesian({ x: 1, y: 0 })).toEqual({ r: 1, a: 0 });
    });

    it('should transform the point inbetween the four axis', () => {
        expect(fromCartesian(
            { x: 0.70710678118655, y: 0.70710678118655 },
        )).toEqual({ r: 1, a: 45 });
        expect(fromCartesian(
            { x: -0.70710678118655, y: 0.70710678118655 },
        )).toEqual({ r: 1, a: 135 });
        expect(fromCartesian(
            { x: -0.70710678118655, y: -0.70710678118655 },
        )).toEqual({ r: 1, a: 225 });
        expect(fromCartesian(
            { x: 0.70710678118655, y: -0.70710678118655 },
        )).toEqual({ r: 1, a: 315 });
        expect(fromCartesian(
            { x: 0.70710678118655, y: 0.70710678118655 },
        )).toEqual({ r: 1, a: 45 });
    });
});
