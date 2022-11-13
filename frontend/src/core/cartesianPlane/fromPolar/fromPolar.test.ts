import { describe, expect, it } from 'vitest';
import { fromPolar } from './fromPolar';

describe('fromPolar', () => {
    it('should transform the point on the four axis', () => {
        expect(fromPolar({ r: 1, a: 0 })).toEqual({ x: 1, y: 0 });
        expect(fromPolar({ r: 1, a: 90 })).toEqual({ x: 0, y: 1 });
        expect(fromPolar({ r: 1, a: 180 })).toEqual({ x: -1, y: 0 });
        expect(fromPolar({ r: 1, a: 270 })).toEqual({ x: 0, y: -1 });
        expect(fromPolar({ r: 1, a: 360 })).toEqual({ x: 1, y: 0 });
    });

    it('should transform the point inbetween the four axis', () => {
        expect(fromPolar({ r: 1, a: 45 })).toEqual(
            { x: 0.7071067812, y: 0.7071067812 },
        );
        expect(fromPolar({ r: 1, a: 135 })).toEqual(
            { x: -0.7071067812, y: 0.7071067812 },
        );
        expect(fromPolar({ r: 1, a: 225 })).toEqual(
            { x: -0.7071067812, y: -0.7071067812 },
        );
        expect(fromPolar({ r: 1, a: 315 })).toEqual(
            { x: 0.7071067812, y: -0.7071067812 },
        );
        expect(fromPolar({ r: 1, a: 405 })).toEqual(
            { x: 0.7071067812, y: 0.7071067812 },
        );
    });

    it('should transform the point on the starting point', () => {
        expect(fromPolar({ r: 0, a: 0 })).toEqual({ x: 0, y: 0 });
    });
});
