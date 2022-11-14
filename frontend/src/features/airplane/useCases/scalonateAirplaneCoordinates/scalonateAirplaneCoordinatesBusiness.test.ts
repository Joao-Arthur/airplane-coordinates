import { describe, expect, it } from 'vitest';
import { scalonateAirplaneCoordinatesBusiness } from './scalonateAirplaneCoordinatesBusiness';

describe('scalonateAirplaneCoordinatesBusiness', () => {
    it('should scalonate the airplane dimensions', () => {
        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { type: 'CARTESIAN', a: 4, b: 7 }, vector: { speed: 0, direction: 0 } },
            x: 2,
            y: -3,
        })).toEqual({ id: '1', planePoint: { type: 'CARTESIAN', a: 8, b: -21 }, vector: { speed: 0, direction: 0 } });

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { type: 'CARTESIAN', a: -1, b: 3 }, vector: { speed: 0, direction: 0 } },
            x: 2,
            y: -3,
        })).toEqual({ id: '2', planePoint: { type: 'CARTESIAN', a: -2, b: -9 }, vector: { speed: 0, direction: 0 } });

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { type: 'CARTESIAN', a: 4, b: 7 }, vector: { speed: 0, direction: 0 } },
            x: 0,
            y: 0,
        })).toEqual({ id: '1', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { speed: 0, direction: 0 } });

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { type: 'CARTESIAN', a: -1, b: 3 }, vector: { speed: 0, direction: 0 } },
            x: 0,
            y: 0,
        })).toEqual(
            { id: '2', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { speed: 0, direction: 0 } },
        );
    });
});
