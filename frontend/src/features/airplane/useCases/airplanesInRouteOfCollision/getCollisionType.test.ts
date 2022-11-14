import { describe, expect, it } from 'vitest';
import { getCollisionType } from './getCollisionType';

describe('getCollisionType', () => {
    it('should return when the position is the same', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 2, b: 5 }, vector: { direction: 186, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 2, b: 5 }, vector: { direction: 17, speed: 9 } },
        })).toBe('SAME_POSITION');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 4, b: 7 }, vector: { direction: 82, speed: 53 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: 7 }, vector: { direction: 95, speed: 8 } },
        })).toBe('SAME_POSITION');
    });

    it('should return when the function is the same', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 2, b: 1 }, vector: { direction: 26.56505117707799, speed: 4 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: 2 }, vector: { direction: 26.56505117707799, speed: 0.5 } },
        })).toBe('SAME_FUNCTION');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 1, b: 3 }, vector: { direction: 26.56505117707799, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 3, b: 4 }, vector: { direction: 206.5650511770779, speed: 7 } },
        })).toBe('SAME_FUNCTION');
    });

    it('should return when the function is not the same', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 5, b: 2 }, vector: { direction: 10, speed: 2 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 8, b: 10 }, vector: { direction: 300, speed: 3 } },
        })).toBe('DIFFERENT_FUNCTIONS');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -2, b: 8 }, vector: { direction: 200, speed: 3 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 5, b: -7 }, vector: { direction: 52, speed: 8 } },
        })).toBe('DIFFERENT_FUNCTIONS');
    });

    it('should return when the functions are parallel lines', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 2, b: 1 }, vector: { direction: 26.56505117707799, speed: 4 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: 3 }, vector: { direction: 26.56505117707799, speed: 0.5 } },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 1, b: 3 }, vector: { direction: 26.56505117707799, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 3, b: 5 }, vector: { direction: 206.5650511770779, speed: 7 } },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -1, b: 2 }, vector: { direction: 360, speed: 5 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 1, b: -2 }, vector: { direction: 180, speed: 3 } },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -1, b: 2 }, vector: { direction: 90, speed: 7 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 1, b: -2 }, vector: { direction: 90, speed: 4 } },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -1, b: 2 }, vector: { direction: 90, speed: 7 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 1, b: -2 }, vector: { direction: 270, speed: 4 } },
        })).toBe('PARALLEL_LINES');
    });

    it('should return when both are infinite tangents', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 4, b: 2 }, vector: { direction: 270, speed: 2 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: 7 }, vector: { direction: 270, speed: 9 } },
        })).toBe('INFINITE_TANGENT_SAME_X');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -2, b: 5 }, vector: { direction: 90, speed: 5 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: -2, b: 4 }, vector: { direction: 270, speed: 7 } },
        })).toBe('INFINITE_TANGENT_SAME_X');
    });

    it('should return when one is a infinite tangent', () => {
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -3, b: 5 }, vector: { direction: 270, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: -3 }, vector: { direction: 153, speed: 4 } },
        })).toBe('INFINITE_TANGENT_IN_ONE_AIRPLANE');
        expect(getCollisionType({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 1, b: 2 }, vector: { direction: 76, speed: 5 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 4, b: 4 }, vector: { direction: 90, speed: 6 } },
        })).toBe('INFINITE_TANGENT_IN_ONE_AIRPLANE');
    });
});
