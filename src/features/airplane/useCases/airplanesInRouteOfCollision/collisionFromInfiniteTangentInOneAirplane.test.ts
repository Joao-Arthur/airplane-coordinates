import { describe, expect, it } from 'vitest';
import { collisionFromInfiniteTangentInOneAirplane } from './collisionFromInfiniteTangentInOneAirplane';

describe('collisionFromInfiniteTangentInOneAirplane', () => {
    it('should return the same function', () => {
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247461903,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -1, y: 1, direction: 45, speed: 2 },
            b: { id: '2', x: 1, y: 3, direction: 45, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247461903,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135623730951,
            timeDifferenceToPoint: 1.4142135623730951,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 4 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 0.7071067811865476,
            timeDifferenceToPoint: 2.121320343559643,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135623730951,
            timeDifferenceToPoint: 1.4142135623730951,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
            b: { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 0.7071067811865476,
            timeDifferenceToPoint: 2.121320343559643,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135623730951,
            timeDifferenceToPoint: 1.4142135623730951,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
            b: { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 0.7071067811865476,
            timeDifferenceToPoint: 2.121320343559643,
        });
    });
});
