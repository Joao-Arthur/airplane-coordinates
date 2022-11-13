import { describe, expect, it } from 'vitest';
import { airplanesCloseToAirportBusiness } from './airplanesCloseToAirportBusiness';

describe('airplanesCloseToAirportBusiness', () => {
    it('should return the airplanes in the distance from the airport', () => {
        expect(
            airplanesCloseToAirportBusiness({
                airplanes: [
                    { id: '1', x: 0, y: 8, vector: { speed: 0, direction: 0 } },
                    { id: '2', x: 10, y: 0, vector: { speed: 0, direction: 0 } },
                    { id: '3', x: -2, y: -2, vector: { speed: 0, direction: 0 } },
                    { id: '4', x: 10, y: 10, vector: { speed: 0, direction: 0 } },
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
