import { describe, expect, it } from 'vitest';
import { collisionFromInfiniteTangentInOneAirplane } from './collisionFromInfiniteTangentInOneAirplane';

describe('collisionFromInfiniteTangentInOneAirplane', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: 0, y: -10, direction: 90, speed: 10 },
            b: { id: '2', x: 10, y: 0, direction: 180, speed: 1 },
        })).toBe(undefined);
    });

    it('should return the collision when one airplane has infinite tangent', () => {
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: 0, y: -10, direction: 90, speed: 1 },
            b: { id: '2', x: 10, y: 0, direction: 180, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: 2, y: 22, direction: 270, speed: 4 },
            b: { id: '2', x: -3, y: 2, direction: 0, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 2, y: 2 },
            timeUntilCollision: 5,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: -5, direction: 90, speed: 1 },
            b: { id: '2', x: 8, y: 0, direction: 206.5650511770779, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -2, y: 5 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 0,
        });
    });
});
