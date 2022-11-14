import { describe, expect, it } from 'vitest';
import { collisionFromInfiniteTangentBothAirplanes } from './collisionFromInfiniteTangentBothAirplanes';

describe('collisionFromInfiniteTangentBothAirplanes', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 2, b: 2 }, vector: { direction: 90, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 2, b: -2 }, vector: { direction: 90, speed: 1 } },
        })).toEqual(undefined);
    });

    it('should calculate the collision for the airplanes in the infinite tangent angle', () => {
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: 2, b: 2 }, vector: { direction: 90, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: 2, b: -2 }, vector: { direction: 90, speed: 2 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 2, y: 6 },
            timeUntilCollision: 4,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', planePoint: { type: 'CARTESIAN', a: -5, b: -10 }, vector: { direction: 90, speed: 1 } },
            b: { id: '2', planePoint: { type: 'CARTESIAN', a: -5, b: 20 }, vector: { direction: 270, speed: 2 } },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -5, y: 0 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 0,
        });


    });
});
