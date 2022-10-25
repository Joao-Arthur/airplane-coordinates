import { AirplaneNotFoundError } from './AirplaneNotFoundError';
import { deleteAirplaneBusiness } from './deleteAirplaneBusiness';

describe('deleteAirplaneBusiness', () => {
    it('should throw error when id not in list', () => {
        expect(deleteAirplaneBusiness({
            airplanes: [
                { id: 'aaa', x: 0, y: 0, direction: 0, speed: 0 },
                { id: 'bbb', x: 0, y: 0, direction: 0, speed: 0 },
                { id: 'ccc', x: 0, y: 0, direction: 0, speed: 0 },
            ],
            airplaneToDelete: 'aaa',
        })).toBe(undefined);
        expect(() => deleteAirplaneBusiness({
            airplanes: [
                { id: 'bbb', x: 0, y: 0, direction: 0, speed: 0 },
                { id: 'ccc', x: 0, y: 0, direction: 0, speed: 0 },
                { id: 'ddd', x: 0, y: 0, direction: 0, speed: 0 },
            ],
            airplaneToDelete: 'aaa',
        })).toThrowError(AirplaneNotFoundError);
    });
});
