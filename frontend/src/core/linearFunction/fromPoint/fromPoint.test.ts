import { describe, expect, it } from 'vitest';
import { fromPoint } from './fromPoint';

describe('fromPoint', () => {
    it('should get the function from the point in the main axis', () => {
        expect(fromPoint({ point: { x: 1, y: 1 }, angle: 45 })).toEqual({ a: 1, b: 0 });
        expect(fromPoint({ point: { x: 0, y: 0 }, angle: 45 })).toEqual({ a: 1, b: 0 });
        expect(fromPoint({ point: { x: -1, y: -1 }, angle: 45 })).toEqual({ a: 1, b: 0 });

        expect(fromPoint({ point: { x: -1, y: 1 }, angle: 135 })).toEqual({ a: -1, b: 0 });
        expect(fromPoint({ point: { x: 0, y: 0 }, angle: 135 })).toEqual({ a: -1, b: 0 });
        expect(fromPoint({ point: { x: 1, y: -1 }, angle: 135 })).toEqual({ a: -1, b: 0 });
    });

    it('should get the function in the 0º degree', () => {
        expect(fromPoint({ point: { x: -1, y: 1 }, angle: 0 })).toEqual({ a: 0, b: 1 });
        expect(fromPoint({ point: { x: 0, y: 0 }, angle: 0 })).toEqual({ a: 0, b: 0 });
        expect(fromPoint({ point: { x: 1, y: -1 }, angle: 0 })).toEqual({ a: 0, b: -1 });
    });

    it('should get the function from the point', () => {
        expect(fromPoint({ point: { x: 2, y: 0 }, angle: 45 })).toEqual({ a: 1, b: -2 });
        expect(fromPoint({ point: { x: 2, y: 4 }, angle: 45 })).toEqual({ a: 1, b: 2 });
    });
});
