import { describe, expect, it } from 'vitest';
import { airplanesCloseToEachOtherBusiness } from './airplanesCloseToEachOtherBusiness';

describe('airplanesCloseToEachOtherBusiness', () => {
    it('should return the airplanes in the distance from themselves', () => {
        expect(
            airplanesCloseToEachOtherBusiness({
                airplanes: [
                    { id: '1', planePoint: { planeType: 'CARTESIAN', a: '10', b: '10' }, vector: { speed: '0', direction: '0' } },
                    { id: '2', planePoint: { planeType: 'CARTESIAN', a: '10', b: '20' }, vector: { speed: '0', direction: '0' } },
                    { id: '3', planePoint: { planeType: 'CARTESIAN', a: '0', b: '20' }, vector: { speed: '0', direction: '0' } },
                    { id: '4', planePoint: { planeType: 'CARTESIAN', a: '2', b: '22' }, vector: { speed: '0', direction: '0' } },
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
