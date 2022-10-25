
import { collisionFromSamePosition } from './collisionFromSamePosition';

describe('collisionFromSamePosition', () => {
    it('should return the same position as the collision point', () => {
        expect(collisionFromSamePosition({
            a: { id: 'a', x: -2, y: 6.18, speed: 0, direction: 0 },
            b: { id: 'b', x: -2, y: 6.18, speed: 0, direction: 0 },
        })).toEqual({
            a: 'a',
            b: 'b',
            timeUntilCollision: 0,
            collisionPoint: { x: -2, y: 6.18 },
            timeDifferenceToPoint: 0,
        });
    });
});
