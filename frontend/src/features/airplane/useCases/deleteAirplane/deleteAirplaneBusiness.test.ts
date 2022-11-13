import { describe, expect, it } from 'vitest';
import { AirplaneNotFoundError } from './AirplaneNotFoundError';
import { deleteAirplaneBusiness } from './deleteAirplaneBusiness';

describe('deleteAirplaneBusiness', () => {
    it('should throw error when id not in list', () => {
        expect(deleteAirplaneBusiness({
            airplanes: [
                { id: 'aaa', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'bbb', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ccc', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
            ],
            airplaneToDelete: 'aaa',
        })).toBe(undefined);
        expect(() => deleteAirplaneBusiness({
            airplanes: [
                { id: 'bbb', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ccc', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ddd', planePoint: { x: 0, y: 0 }, vector: { direction: 0, speed: 0 } },
            ],
            airplaneToDelete: 'aaa',
        })).toThrowError(AirplaneNotFoundError);
    });
});
