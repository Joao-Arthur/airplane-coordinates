import { collisionFromInfiniteTangentBothAirplanes } from './collisionFromInfiniteTangentBothAirplanes';

describe('collisionFromInfiniteTangentBothAirplanes', () => {
    it('should return undefined when there is no collision', () => {
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', x: 2, y: 2, direction: 90, speed: 1 },
            b: { id: '2', x: 2, y: -2, direction: 90, speed: 1 },
        })).toEqual(undefined);
    });

    it('should calculate the collision for the airplanes in the infinite tangent angle', () => {
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', x: 2, y: 2, direction: 90, speed: 1 },
            b: { id: '2', x: 2, y: -2, direction: 90, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: 2, y: 6 },
            timeUntilCollision: 4,
            timeDifferenceToPoint: 0,
        });
        expect(collisionFromInfiniteTangentBothAirplanes({
            a: { id: '1', x: -5, y: -10, direction: 90, speed: 1 },
            b: { id: '2', x: -5, y: 20, direction: 270, speed: 2 },
        })).toEqual({
            a: '1',
            b: '2',
            collisionPoint: { x: -5, y: 0 },
            timeUntilCollision: 10,
            timeDifferenceToPoint: 0,
        });


    });
});
