import { describe, expect, it } from 'vitest';
import { timeToPoint } from './timeToPoint';

describe('timeToPoint', () => {
    it('should return the time to a point', () => {
        expect(timeToPoint({ speed: 10, distance: 100 })).toBe(10);
        expect(timeToPoint({ speed: 2, distance: 100 })).toBe(50);
        expect(timeToPoint({ speed: 2, distance: 0 })).toBe(0);
        expect(timeToPoint({ speed: 2, distance: -100 })).toBe(-50);
        expect(timeToPoint({ speed: 0.5, distance: 5 })).toBe(10);
    });
});
