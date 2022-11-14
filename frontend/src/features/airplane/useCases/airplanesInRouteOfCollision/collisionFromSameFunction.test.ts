import { describe, expect, it } from 'vitest';
import { collisionFromSameFunction } from './collisionFromSameFunction';

describe('collisionFromSameFunction', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromSameFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -1, b: 1 }, vector: { direction: 45, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 1, b: 3 }, vector: { direction: 45, speed: 1 } },
        })).toEqual(undefined);
    });

    it('should return the collision point when the function is the same', () => {
        expect(collisionFromSameFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -1, b: 1 }, vector: { direction: 45, speed: 2 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 1, b: 3 }, vector: { direction: 45, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 3, y: 5 },
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -1, b: 4 }, vector: { direction: 45, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 1, b: 6 }, vector: { direction: 225, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 5 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 2 }, vector: { direction: 0, speed: 2 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 2 }, vector: { direction: 180, speed: 9 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -1.2727272727, y: 2 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 0.3636363636,
        });
    });
});
