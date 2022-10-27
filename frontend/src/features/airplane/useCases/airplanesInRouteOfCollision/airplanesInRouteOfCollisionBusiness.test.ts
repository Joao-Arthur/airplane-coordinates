import { describe, expect, it } from 'vitest';
import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';

describe('airplanesInRouteOfCollisionBusiness', () => {
    it('should return the airplanes in route of collision in the same angle, but opposite directions', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
                { id: '2', x: 2, y: 0, direction: 135, speed: 1 },
            ],
            maxTime: 1000,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        }]);
    });

    it('should return the airplanes in route of collision in the same angle and direction', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -1, y: 1, direction: 45, speed: 2 },
                { id: '2', x: 1, y: 3, direction: 45, speed: 1 },
            ],
            maxTime: 1000,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 3, y: 5 },
            timeUntilCollision: 2.8284271247,
            timeDifferenceToPoint: 0,
        }]);
    });

    it('should return the difference when speed is not the same', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
                { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 1.4142135624,
        }]);

        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
                { id: '2', x: 2, y: 0, direction: 135, speed: 4 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 0.7071067812,
            timeDifferenceToPoint: 2.1213203436,
        }]);
    });

    it('should return the difference when speed is not the same', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
                { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 1.4142135624,
        }]);

        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
                { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: -1.2727272727, y: 2 },
            timeUntilCollision: 0.3636363636,
            timeDifferenceToPoint: 0,
        }]);
    });

    it('should return the collision in the same point', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 0, direction: 45, speed: 1 },
                { id: '2', x: 2, y: 0, direction: 135, speed: 2 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: 0, y: 2 },
            timeUntilCollision: 1.4142135624,
            timeDifferenceToPoint: 1.4142135624,
        }]);

        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                { id: '1', x: -2, y: 2, direction: 0, speed: 2 },
                { id: '2', x: 2, y: 2, direction: 180, speed: 9 },
            ],
            maxTime: Number.MAX_SAFE_INTEGER,
        })).toEqual([{
            a: '1',
            b: '2',
            collisionPoint: { x: -1.2727272727, y: 2 },
            timeUntilCollision: 0.3636363636,
            timeDifferenceToPoint: 0,
        }]);
    });
});
