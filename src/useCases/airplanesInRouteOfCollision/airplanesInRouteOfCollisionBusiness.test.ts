import { describe, expect, it } from 'vitest';
import { airplanesInRouteOfCollisionBusiness } from './airplanesInRouteOfCollisionBusiness';

describe('airplanesInRouteOfCollisionBusiness', () => {
    it('should return the airplanes in route of collision', () => {
        expect(airplanesInRouteOfCollisionBusiness([])).toEqual([]);
    })
})