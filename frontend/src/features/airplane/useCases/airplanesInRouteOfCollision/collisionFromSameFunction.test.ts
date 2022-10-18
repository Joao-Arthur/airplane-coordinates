import { describe, expect, it } from 'vitest';
import { collisionFromSameFunction } from './collisionFromSameFunction';

describe('collisionFromSameFunction', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromSameFunction({
            a: { id: '1', x: -1, y: 1, direction: 45, speed: 1 },
            b: { id: '2', x: 1, y: 3, direction: 45, speed: 1 },
        })).toEqual(undefined);
    });

    it('should return the collision point when the function is the same', () => {
        expect(collisionFromSameFunction({
            a: { id: '1', x: -1, y: 1, direction: 45, speed: 2 },
            b: { id: '2', x: 1, y: 3, direction: 45, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 3, y: 5 },
            timeUntilCollision: 2.82842712474619,
            timeDifferenceToPoint: 0,
        });

        expect(collisionFromSameFunction({
            a: { id: '1', x: -1, y: 4, direction: 45, speed: 1 },
            b: { id: '2', x: 1, y: 6, direction: 225, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 5 },
            timeUntilCollision: 1.414213562373095,
            timeDifferenceToPoint: 0,
        });

        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
            b: { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: - 1.2727272727272727, y: 2 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 0.36363636363636365,
        });
    });
});
