import { describe, expect, it } from 'vitest';
import { collisionFromDifferentFunction } from './collisionFromDifferentFunction';

describe('collisionFromDifferentFunction', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: 3, y: 5, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual(undefined);
    });

    it('should return the difference when speed is the same', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247461903,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 55, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 125, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 3.486893591255115,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 65, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 115, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 4.732403166287671,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 25, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 155, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 2.206755837920759,
        });
    });

    it('should return the difference when speed is not the same', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135623730951,
            timeDifferenceToPoint: 1.4142135623730951,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 55, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 125, speed: 4 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeDifferenceToPoint: 2.6151701934413363,
            timeUntilCollision: 0.8717233978137787,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 65, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 115, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeDifferenceToPoint: 2.3662015831438357,
            timeUntilCollision: 2.3662015831438357,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', x: -2, y: 0, direction: 25, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 155, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeDifferenceToPoint: 1.1033779189603794,
            timeUntilCollision: 1.1033779189603794,
        });
    });
});
