import init from 'backend';
import { translateAirplaneCoordinatesBusiness } from './translateAirplaneCoordinatesBusiness';

describe('translateAirplaneCoordinatesBusiness', () => {
    beforeAll(async () => {
        init();
    });

    it('should transform the airplane dimensions', () => {
        expect(translateAirplaneCoordinatesBusiness({
            coordinates: { type: 'cartesian', a: '4', b: '7' },
            x: 2,
            y: -3,
        })).toEqual({ type: 'cartesian', a: '6', b: '4' });

        expect(translateAirplaneCoordinatesBusiness({
            coordinates: { type: 'cartesian', a: '-1', b: '3' },
            x: 2,
            y: -3,
        })).toEqual({ type: 'cartesian', a: '1', b: '0' });

        expect(translateAirplaneCoordinatesBusiness({
            coordinates: { type: 'cartesian', a: '4', b: '7' },
            x: 0,
            y: 0,
        })).toEqual({ type: 'cartesian', a: '4', b: '7' });

        expect(translateAirplaneCoordinatesBusiness({
            coordinates: { type: 'cartesian', a: '-1', b: '3' },
            x: 0,
            y: 0,
        })).toEqual({ type: 'cartesian', a: '-1', b: '3' });
    });
});
