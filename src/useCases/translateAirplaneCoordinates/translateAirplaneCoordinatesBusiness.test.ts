import { describe, expect, it } from 'vitest';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';

describe('translateAirplaneCoordinatesBusiness', () => {
    it('should transform the airplane dimensions', () => {
        expect(translateAirplaneCoordinatesBusiness({
            airplanes: [
                { id: '1', x: 4, y: 7, speed: 0, direction: 0 },
                { id: '2', x: -1, y: 3, speed: 0, direction: 0 },
            ],
            x: 2,
            y: -3,
        })).toEqual([
            { id: '1', x: 6, y: 4, speed: 0, direction: 0 },
            { id: '2', x: 1, y: 0, speed: 0, direction: 0 },
        ]);
        expect(translateAirplaneCoordinatesBusiness({
            airplanes: [
                { id: '1', x: 4, y: 7, speed: 0, direction: 0 },
                { id: '2', x: -1, y: 3, speed: 0, direction: 0 },
            ],
            x: 0,
            y: 0,
        })).toEqual([
            { id: '1', x: 4, y: 7, speed: 0, direction: 0 },
            { id: '2', x: -1, y: 3, speed: 0, direction: 0 },
        ]);
    })
})