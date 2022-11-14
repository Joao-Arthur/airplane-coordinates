import { describe, expect, it } from 'vitest';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';

describe('translateAirplaneCoordinatesBusiness', () => {
    it('should transform the airplane dimensions', () => {
        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '4', b: '7' }, vector: { speed: '0', direction: '0' } },
            x: 2,
            y: -3,
        })).toEqual({ id: '1', planePoint: { planeType: 'CARTESIAN', a: '6', b: '4' }, vector: { speed: '0', direction: '0' } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '-1', b: '3' }, vector: { speed: '0', direction: '0' } },
            x: 2,
            y: -3,
        })).toEqual({ id: '2', planePoint: { planeType: 'CARTESIAN', a: '1', b: '0' }, vector: { speed: '0', direction: '0' } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '4', b: '7' }, vector: { speed: '0', direction: '0' } },
            x: 0,
            y: 0,
        })).toEqual({ id: '1', planePoint: { planeType: 'CARTESIAN', a: '4', b: '7' }, vector: { speed: '0', direction: '0' } });

        expect(translateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '-1', b: '3' }, vector: { speed: '0', direction: '0' } },
            x: 0,
            y: 0,
        })).toEqual({ id: '2', planePoint: { planeType: 'CARTESIAN', a: '-1', b: '3' }, vector: { speed: '0', direction: '0' } });
    });
});
