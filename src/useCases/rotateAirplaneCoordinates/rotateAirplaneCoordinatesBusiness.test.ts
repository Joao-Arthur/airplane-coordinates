import { describe, expect, it } from 'vitest';
import { rotateAirplaneCoordinatesBusiness } from './rotateAirplaneCoordinatesBusiness';

describe('rotateAirplaneCoordinatesBusiness', () => {
    it('should rotate the airplanes coordinates', () => {
        expect(rotateAirplaneCoordinatesBusiness([])).toEqual([]);
    })
})