
import { scalonateAirplaneCoordinatesBusiness } from './scalonateAirplaneCoordinatesBusiness';

describe('scalonateAirplaneCoordinatesBusiness', () => {
    it('should scalonate the airplane dimensions', () => {
        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '1', x: 4, y: 7, speed: 0, direction: 0 },
            x: 2,
            y: -3,
        })).toEqual({ id: '1', x: 8, y: -21, speed: 0, direction: 0 });

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '2', x: -1, y: 3, speed: 0, direction: 0 },
            x: 2,
            y: -3,
        })).toEqual({ id: '2', x: -2, y: -9, speed: 0, direction: 0 },
        );

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '1', x: 4, y: 7, speed: 0, direction: 0 },
            x: 0,
            y: 0,
        })).toEqual({ id: '1', x: 0, y: 0, speed: 0, direction: 0 });

        expect(scalonateAirplaneCoordinatesBusiness({
            airplane: { id: '2', x: -1, y: 3, speed: 0, direction: 0 },
            x: 0,
            y: 0,
        })).toEqual(
            { id: '2', x: 0, y: 0, speed: 0, direction: 0 },
        );
    });
});
