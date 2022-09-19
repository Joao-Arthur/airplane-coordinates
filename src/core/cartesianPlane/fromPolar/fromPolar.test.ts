import { describe, expect, it } from 'vitest';
import { fromPolar } from './fromPolar';

describe('fromPolar', () => {
    it('should transform the point on the four axis', () => {
        expect(fromPolar({ r: 1, angle: 0 })).toEqual({ x: 1, y: 0 });
        expect(fromPolar({ r: 1, angle: 90 })).toEqual({ x: 0, y: 1 });
        expect(fromPolar({ r: 1, angle: 180 })).toEqual({ x: -1, y: 0 });
        expect(fromPolar({ r: 1, angle: 270 })).toEqual({ x: -0, y: -1 });
        expect(fromPolar({ r: 1, angle: 360 })).toEqual({ x: 1, y: -0 });
    });

    it('should transform the point inbetween the four axis', () => {
        expect(
            fromPolar({ r: 1, angle: 45 }),
        ).toEqual({ x: 0.70710678118655, y: 0.70710678118655 });
        expect(
            fromPolar({ r: 1, angle: 135 }),
        ).toEqual({ x: -0.70710678118655, y: 0.70710678118655 });
        expect(
            fromPolar({ r: 1, angle: 225 }),
        ).toEqual({ x: -0.70710678118655, y: -0.70710678118655 });
        expect(
            fromPolar({ r: 1, angle: 315 }),
        ).toEqual({ x: 0.70710678118655, y: -0.70710678118655 });
        expect(
            fromPolar({ r: 1, angle: 405 }),
        ).toEqual({ x: 0.70710678118655, y: 0.70710678118655 });
    });
});
