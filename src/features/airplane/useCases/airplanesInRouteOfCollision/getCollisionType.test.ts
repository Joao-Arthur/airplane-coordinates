import { describe, expect, it } from 'vitest';
import { getCollisionType } from './getCollisionType';

describe('getCollisionType', () => {
    it('should return when the position is the same', () => {
        expect(getCollisionType({
            a: { id: '1', x: 2, y: 5, direction: 186, speed: 1 },
            b: { id: '2', x: 2, y: 5, direction: 17, speed: 9 },
        })).toBe('SAME_POSITION');
        expect(getCollisionType({
            a: { id: '1', x: 4, y: 7, direction: 82, speed: 53 },
            b: { id: '2', x: 4, y: 7, direction: 95, speed: 8 },
        })).toBe('SAME_POSITION');
    });

    it('should return when the function is the same', () => {
        expect(getCollisionType({
            a: { id: '1', x: 2, y: 1, direction: 26.56505117707799, speed: 4 },
            b: { id: '2', x: 4, y: 2, direction: 26.56505117707799, speed: 0.5 },
        })).toBe('SAME_FUNCTION');
        expect(getCollisionType({
            a: { id: '1', x: 1, y: 3, direction: 26.56505117707799, speed: 1 },
            b: { id: '2', x: 3, y: 4, direction: 206.5650511770779, speed: 7 },
        })).toBe('SAME_FUNCTION');
    });

    it('should return when the function is not the same', () => {
        expect(getCollisionType({
            a: { id: '1', x: 5, y: 2, direction: 10, speed: 2 },
            b: { id: '2', x: 8, y: 10, direction: 300, speed: 3 },
        })).toBe('DIFFERENT_FUNCTIONS');
        expect(getCollisionType({
            a: { id: '1', x: -2, y: 8, direction: 200, speed: 3 },
            b: { id: '2', x: 5, y: -7, direction: 52, speed: 8 },
        })).toBe('DIFFERENT_FUNCTIONS');
    });

    it('should return when the functions are parallel lines', () => {
        expect(getCollisionType({
            a: { id: '1', x: 2, y: 1, direction: 26.56505117707799, speed: 4 },
            b: { id: '2', x: 4, y: 3, direction: 26.56505117707799, speed: 0.5 },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', x: 1, y: 3, direction: 26.56505117707799, speed: 1 },
            b: { id: '2', x: 3, y: 5, direction: 206.5650511770779, speed: 7 },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', x: -1, y: 2, direction: 360, speed: 5 },
            b: { id: '2', x: 1, y: -2, direction: 180, speed: 3 },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', x: -1, y: 2, direction: 90, speed: 7 },
            b: { id: '2', x: 1, y: -2, direction: 90, speed: 4 },
        })).toBe('PARALLEL_LINES');
        expect(getCollisionType({
            a: { id: '1', x: -1, y: 2, direction: 90, speed: 7 },
            b: { id: '2', x: 1, y: -2, direction: 270, speed: 4 },
        })).toBe('PARALLEL_LINES');
    });

    it('should return when both are infinite tangents', () => {
        expect(getCollisionType({
            a: { id: '1', x: 4, y: 2, direction: 270, speed: 2 },
            b: { id: '2', x: 4, y: 7, direction: 270, speed: 9 },
        })).toBe('INFINITE_TANGENT_SAME_X');
        expect(getCollisionType({
            a: { id: '1', x: -2, y: 5, direction: 90, speed: 5 },
            b: { id: '2', x: -2, y: 4, direction: 270, speed: 7 },
        })).toBe('INFINITE_TANGENT_SAME_X');
    });

    it('should return when one is a infinite tangent', () => {
        expect(getCollisionType({
            a: { id: '1', x: -3, y: 5, direction: 270, speed: 1 },
            b: { id: '2', x: 4, y: -3, direction: 153, speed: 4 },
        })).toBe('INFINITE_TANGENT_IN_ONE_AIRPLANE');
        expect(getCollisionType({
            a: { id: '1', x: 1, y: 2, direction: 76, speed: 5 },
            b: { id: '2', x: 4, y: 4, direction: 90, speed: 6 },
        })).toBe('INFINITE_TANGENT_IN_ONE_AIRPLANE');
    });
});