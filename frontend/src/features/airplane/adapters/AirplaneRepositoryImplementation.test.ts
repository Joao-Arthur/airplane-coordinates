import { describe, it, expect } from 'vitest';
import { AirplaneRepositoryImplementation } from './AirplaneRepositoryImplementation';

describe('AirplaneRepositoryImplementation', () => {
    it('should recover the saved registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            point: { planeType: 'CARTESIAN', a: '1', b: '1' },
            vector: { speed: '1', direction: '1' },
        });
        airplaneRepository.add({
            id: '2',
            point: { planeType: 'CARTESIAN', a: '2', b: '2' },
            vector: { speed: '2', direction: '2' },
        });
        expect(airplaneRepository.retrieve()).toEqual([
            {
                id: '1',
                point: { planeType: 'CARTESIAN', a: '1', b: '1' },
                vector: { speed: '1', direction: '1' },
            },
            {
                id: '2',
                point: { planeType: 'CARTESIAN', a: '2', b: '2' },
                vector: { speed: '2', direction: '2' },
            },
        ]);
    });

    it('should edit the registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            point: { planeType: 'CARTESIAN', a: '1', b: '1' },
            vector: { speed: '6', direction: '6' },
        });
        airplaneRepository.updatePointById('1', { planeType: 'POLAR', a: '10', b: '10' });
        expect(airplaneRepository.retrieve()).toEqual([{
            id: '1',
            point: { planeType: 'POLAR', a: '10', b: '10' },
            vector: { speed: '6', direction: '6' },
        }]);
    });

    it('should delete the registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            point: { planeType: 'CARTESIAN', a: '1', b: '1' },
            vector: { speed: '1', direction: '1' },
        });
        expect(airplaneRepository.retrieve().length).toBe(1);
        airplaneRepository.remove('1');
        expect(airplaneRepository.retrieve().length).toBe(0);
    });
});
