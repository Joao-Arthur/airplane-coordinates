import { savedAirplaneToDTO } from './savedAirplaneToDTO';

describe('savedAirplaneToDTO', () => {
    it('should transform a polar airplane to dto', () => {
        expect(savedAirplaneToDTO({
            id: '1',
            type: 'polar',
            a: '10',
            b: '270',
            speed: 100,
            direction: 100,
        })).toEqual({
            id: '1',
            x: 0,
            y: -10,
            speed: 100,
            direction: 100,
        });
    });

    it('should transform a cartesian airplane to dto', () => {
        expect(savedAirplaneToDTO({
            id: '1',
            type: 'cartesian',
            a: '4',
            b: '-5',
            speed: 100,
            direction: 100,
        })).toEqual({
            id: '1',
            x: 4,
            y: -5,
            speed: 100,
            direction: 100,
        });
    });
});
