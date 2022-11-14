import { describe, expect, it } from 'vitest';
import { collisionFromDifferentFunction } from './collisionFromDifferentFunction';

describe('collisionFromDifferentFunction', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: 3, b: 5 }, vector: { direction: 45, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 135, speed: 2 } },
        })).toEqual(undefined);
    });

    it('should return the difference when speed is the same', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 45, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 135, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 55, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 125, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeUntilCollision: 3.4868935912,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 65, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 115, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeUntilCollision: 4.7324031663,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 25, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 155, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeUntilCollision: 2.2067558379,
            timeDifferenceToPoint: 0,
        });
    });

    it('should return the difference when speed is not the same', () => {
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 45, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 135, speed: 2 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 1.4142135624,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 55, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 125, speed: 4 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2.8562960135 },
            timeDifferenceToPoint: 2.6151701934,
            timeUntilCollision: 0.8717233978,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 65, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 115, speed: 2 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 4.289013841 },
            timeUntilCollision: 2.3662015832,
            timeDifferenceToPoint: 2.3662015832,
        });
        expect(collisionFromDifferentFunction({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: -2, b: 0 }, vector: { direction: 25, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: 2, b: 0 }, vector: { direction: 155, speed: 2 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0.9326153163 },
            timeDifferenceToPoint: 1.1033779190,
            timeUntilCollision: 1.103377919,
        });
    });
});
