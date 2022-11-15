import { describe, expect, it } from 'vitest';
import { AirplaneNotFoundError } from './AirplaneNotFoundError';
import { deleteAirplaneBusiness } from './deleteAirplaneBusiness';

describe('deleteAirplaneBusiness', () => {
    it('should throw error when id not in list', () => {
        expect(deleteAirplaneBusiness({
            airplanes: [
                { id: 'aaa', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
                { id: 'bbb', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
                { id: 'ccc', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
            ],
            airplaneToDelete: 'aaa',
        })).toBe(undefined);
        expect(() => deleteAirplaneBusiness({
            airplanes: [
                { id: 'bbb', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
                { id: 'ccc', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
                { id: 'ddd', point: { planeType: 'CARTESIAN', a: '0', b: '0' }, vector: { direction: '0', speed: '0' } },
            ],
            airplaneToDelete: 'aaa',
        })).toThrowError(AirplaneNotFoundError);
    });
});
