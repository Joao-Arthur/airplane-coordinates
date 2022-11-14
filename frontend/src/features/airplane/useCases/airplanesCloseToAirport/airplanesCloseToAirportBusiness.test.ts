import { describe, expect, it } from 'vitest';
import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';

describe('airplanesCloseToAirportBusiness', () => {
    it('should return the airplanes in the distance from the airport', () => {
        expect(
            airplanesCloseToAirportBusiness({
                airplanes: [
                    { id: '1', planePoint: { planeType: 'CARTESIAN', a: 0, b: 8 }, vector: { speed: 0, direction: 0 } },
                    { id: '2', planePoint: { planeType: 'CARTESIAN', a: 10, b: 0 }, vector: { speed: 0, direction: 0 } },
                    { id: '3', planePoint: { planeType: 'CARTESIAN', a: -2, b: -2 }, vector: { speed: 0, direction: 0 } },
                    { id: '4', planePoint: { planeType: 'CARTESIAN', a: 10, b: 10 }, vector: { speed: 0, direction: 0 } },
                ],
                maxDistance: 10,
            }),
        ).toEqual([
            { id: '3', distanceFromAirport: 2.8284271247461903 },
            { id: '1', distanceFromAirport: 8 },
            { id: '2', distanceFromAirport: 10 },
        ]);
    });
});
