import { describe, expect, it } from 'vitest';
import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';

describe('airplanesInRouteOfCollisionBusiness', () => {
    it('should return the airplanes in route of collision in the same place', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                {
                    id: '1',
                    x: -2,
                    y: 0,
                    direction: 45,
                    speed: 1,
                },
                {
                    id: '2',
                    x: 2,
                    y: 0,
                    direction: 135,
                    speed: 1,
                },
            ],
            maxTime: 1000,
        })).toEqual([
            {
                a: '1',
                b: '2',
                timeUntilCollision: 2.8284271247461903,
                timeDifferenceToPoint: 0,
            },
        ]);
    });

    it('should return the difference when speed is not the same', () => {
        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                {
                    id: '1',
                    x: -2,
                    y: 0,
                    direction: 45,
                    speed: 1,
                },
                {
                    id: '2',
                    x: 2,
                    y: 0,
                    direction: 135,
                    speed: 2,
                },
            ],
            maxTime: 10,
        })).toEqual([
            {
                a: '1',
                b: '2',
                timeUntilCollision: 1.4142135623730951,
                timeDifferenceToPoint: 1.4142135623730951,
            },
        ]);

        expect(airplanesInRouteOfCollisionBusiness({
            airplanes: [
                {
                    id: '1',
                    x: -2,
                    y: 0,
                    direction: 45,
                    speed: 1,
                },
                {
                    id: '2',
                    x: 2,
                    y: 0,
                    direction: 135,
                    speed: 4,
                },
            ],
            maxTime: 10,
        })).toEqual([
            {
                a: '1',
                b: '2',
                timeUntilCollision: 0.7071067811865476,
                timeDifferenceToPoint: 2.121320343559643,
            },
        ]);
    });
});
