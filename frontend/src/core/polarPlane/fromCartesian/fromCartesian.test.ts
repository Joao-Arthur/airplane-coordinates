import { fromCartesian } from './fromCartesian';

describe('fromCartesian', () => {
    it('should transform the point on the four axis', () => {
        expect(fromCartesian({ x: 1, y: 0 })).toEqual({ radius: 1, angle: 0 });
        expect(fromCartesian({ x: 0, y: 1 })).toEqual({ radius: 1, angle: 90 });
        expect(fromCartesian({ x: -1, y: 0 })).toEqual({ radius: 1, angle: 180 });
        expect(fromCartesian({ x: 0, y: -1 })).toEqual({ radius: 1, angle: 270 });
        expect(fromCartesian({ x: 1, y: 0 })).toEqual({ radius: 1, angle: 0 });
    });

    it('should transform the point inbetween the four axis', () => {
        expect(fromCartesian(
            { x: 0.70710678118655, y: 0.70710678118655 },
        )).toEqual(
            { radius: 1, angle: 45 },
        );
        expect(fromCartesian(
            { x: -0.70710678118655, y: 0.70710678118655 },
        )).toEqual(
            { radius: 1, angle: 135 },
        );
        expect(fromCartesian(
            { x: -0.70710678118655, y: -0.70710678118655 },
        )).toEqual(
            { radius: 1, angle: 225 },
        );
        expect(fromCartesian(
            { x: 0.70710678118655, y: -0.70710678118655 },
        )).toEqual(
            { radius: 1, angle: 315 },
        );
        expect(fromCartesian(
            { x: 0.70710678118655, y: 0.70710678118655 },
        )).toEqual(
            { radius: 1, angle: 45 },
        );
    });
});
