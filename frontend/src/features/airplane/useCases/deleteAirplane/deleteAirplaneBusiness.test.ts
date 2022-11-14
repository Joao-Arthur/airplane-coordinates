import { describe, expect, it } from 'vitest';
import { AirplaneNotFoundError } from './AirplaneNotFoundError';
import { deleteAirplaneBusiness } from './deleteAirplaneBusiness';

describe('deleteAirplaneBusiness', () => {
    it('should throw error when id not in list', () => {
        expect(deleteAirplaneBusiness({
            airplanes: [
                { id: 'aaa', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'bbb', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ccc', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
            ],
            airplaneToDelete: 'aaa',
        })).toBe(undefined);
        expect(() => deleteAirplaneBusiness({
            airplanes: [
                { id: 'bbb', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ccc', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
                { id: 'ddd', planePoint: { type: 'CARTESIAN', a: 0, b: 0 }, vector: { direction: 0, speed: 0 } },
            ],
            airplaneToDelete: 'aaa',
        })).toThrowError(AirplaneNotFoundError);
    });
});
