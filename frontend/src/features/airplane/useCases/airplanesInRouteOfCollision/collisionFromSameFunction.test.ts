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
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -1, y: 4, direction: 45, speed: 1 },
            b: { id: '2', x: 1, y: 6, direction: 225, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 5 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
            b: { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -1.2727272727, y: 2 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 0.3636363636,
        });
    });

    it('should return the collision when the function is diffent', () => {
        expect(collisionFromSameFunction({
            a: { id: '1', x: 3, y: 5, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual(undefined);
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 55, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 125, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 3.4868935912,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 65, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 115, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 4.7324031663,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 25, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 155, speed: 1 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeDifferenceToPoint: 0,
            timeUntilCollision: 2.2067558379,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.8856180832,
            timeDifferenceToPoint: 1.4142135624,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 55, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 125, speed: 4 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeDifferenceToPoint: 2.6151701934,
            timeUntilCollision: 1.3947574365,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 65, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 115, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeDifferenceToPoint: 2.3662015831,
            timeUntilCollision: 3.1549354442,
        });
        expect(collisionFromSameFunction({
            a: { id: '1', x: -2, y: 0, direction: 25, speed: 1 },
            b: { id: '2', x: 2, y: 0, direction: 155, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeDifferenceToPoint: 1.1033779190,
            timeUntilCollision: 1.4711705586,
        });
    });
});
