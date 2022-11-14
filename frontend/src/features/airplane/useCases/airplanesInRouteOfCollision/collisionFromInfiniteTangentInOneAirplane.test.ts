import { describe, expect, it } from 'vitest';
import { collisionFromInfiniteTangentInOneAirplane } from './collisionFromInfiniteTangentInOneAirplane';

describe('collisionFromInfiniteTangentInOneAirplane', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '0', b: '-10' }, vector: { direction: 270, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '10', b: '0' }, vector: { direction: 180, speed: 1 } },
        })).toBe(undefined);
    });

    it('should return the collision when one airplane has infinite tangent', () => {
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '0', b: '-10' }, vector: { direction: 90, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '10', b: '0' }, vector: { direction: 180, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 0 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '2', b: '22' }, vector: { direction: 270, speed: 4 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '-3', b: '2' }, vector: { direction: 0, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 2, y: 2 },
            timeUntilCollision: 5,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentInOneAirplane({
            a: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '-2', b: '-5' }, vector: { direction: 90, speed: 1 } },
            b: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '8', b: '10' }, vector: { direction: 206.5650511770779, speed: 1 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -2, y: 5 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 1.1803398875,
        });
    });
});
