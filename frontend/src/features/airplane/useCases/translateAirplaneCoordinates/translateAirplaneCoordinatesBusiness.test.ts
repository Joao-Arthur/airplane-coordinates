import { describe, expect, it } from 'vitest';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';

describe('translateAirplaneCoordinatesBusiness', () => {
    it('should transform the airplane dimensions', () => {
        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '1', x: 4, y: 7, vector: { speed: 0, direction: 0 } },
            x: 2,
            y: -3,
        })).toEqual({ id: '1', x: 6, y: 4, vector: { speed: 0, direction: 0 } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '2', x: -1, y: 3, vector: { speed: 0, direction: 0 } },
            x: 2,
            y: -3,
        })).toEqual({ id: '2', x: 1, y: 0, vector: { speed: 0, direction: 0 } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '1', x: 4, y: 7, vector: { speed: 0, direction: 0 } },
            x: 0,
            y: 0,
        })).toEqual({ id: '1', x: 4, y: 7, vector: { speed: 0, direction: 0 } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '2', x: -1, y: 3, vector: { speed: 0, direction: 0 } },
            x: 0,
            y: 0,
        })).toEqual({ id: '2', x: -1, y: 3, vector: { speed: 0, direction: 0 } });
    });
});
