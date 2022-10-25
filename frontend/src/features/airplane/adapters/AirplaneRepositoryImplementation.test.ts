import { AirplaneRepositoryImplementation } from './AirplaneRepositoryImplementation';

describe('AirplaneRepositoryImplementation', () => {
    it('should recover the saved registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            type: 'cartesian',
            a: '1',
            b: '1',
            speed: 1,
            direction: 1,
        });
        airplaneRepository.add({
            id: '2',
            type: 'cartesian',
            a: '2',
            b: '2',
            speed: 2,
            direction: 2,
        });
        expect(airplaneRepository.retrieve()).toEqual([
            {
                id: '1',
                type: 'cartesian',
                a: '1',
                b: '1',
                speed: 1,
                direction: 1,
            },
            {
                id: '2',
                type: 'cartesian',
                a: '2',
                b: '2',
                speed: 2,
                direction: 2,
            },
        ]);
    });

    it('should edit the registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            type: 'cartesian',
            a: '1',
            b: '1',
            speed: 1,
            direction: 1,
        });
        airplaneRepository.update({
            id: '1',
            type: 'cartesian',
            a: '10',
            b: '10',
            speed: 10,
            direction: 10,
        });
        expect(airplaneRepository.retrieve()).toEqual([{
            id: '1',
            type: 'cartesian',
            a: '10',
            b: '10',
            speed: 10,
            direction: 10,
        }]);
    });

    it('should delete the registers', () => {
        const airplaneRepository = new AirplaneRepositoryImplementation();
        airplaneRepository.add({
            id: '1',
            type: 'cartesian',
            a: '1',
            b: '1',
            speed: 1,
            direction: 1,
        });
        expect(airplaneRepository.retrieve().length).toBe(1);
        airplaneRepository.remove('1');
        expect(airplaneRepository.retrieve().length).toBe(0);
    });
});
