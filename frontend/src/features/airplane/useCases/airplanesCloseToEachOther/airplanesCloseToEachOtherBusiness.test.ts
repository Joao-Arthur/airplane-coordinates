import { describe, expect, it } from 'vitest';
import { airplanesCloseToEachOtherBusiness } from './airplanesCloseToEachOtherBusiness';

describe('airplanesCloseToEachOtherBusiness', () => {
    it('should return the airplanes in the distance from themselves', () => {
        expect(
            airplanesCloseToEachOtherBusiness({
                airplanes: [
                    { id: '1', x: 10, y: 10, vector: { speed: 0, direction: 0 } },
                    { id: '2', x: 10, y: 20, vector: { speed: 0, direction: 0 } },
                    { id: '3', x: 0, y: 20, vector: { speed: 0, direction: 0 } },
                    { id: '4', x: 2, y: 22, vector: { speed: 0, direction: 0 } },
                ],
                maxDistance: 10,
            }),
        ).toEqual([
            { a: '3', b: '4', distance: 2.8284271247461903 },
            { a: '2', b: '4', distance: 8.246211251235321 },
            { a: '2', b: '3', distance: 10 },
            { a: '1', b: '2', distance: 10 },
        ]);
    });
});
