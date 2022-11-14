import { describe, expect, it } from 'vitest';
import { collisionFromSamePosition } from './collisionFromSamePosition';

describe('collisionFromSamePosition', () => {
    it('should return the same position as the collision point', () => {
        expect(collisionFromSamePosition({
            a: { id: 'a', planePoint: { planeType: 'CARTESIAN', a: '-2', b: '6.18' }, vector: { speed: '0', direction: '0' } },
            b: { id: 'b', planePoint: { planeType: 'CARTESIAN', a: '-2', b: '6.18' }, vector: { speed: '0', direction: '0' } },
        })).toEqual({
            a: 'a',
            b: 'b',
            timeUntilCollision: 0,
            collisionPoint: { x: -2, y: 6.18 },
            timeDifferenceToPoint: 0,
        });
    });
});
