import { describe, expect, it } from 'vitest';
import { savedAirplaneToDTO } from './savedAirplaneToDTO';

describe('savedAirplaneToDTO', () => {
    it('should transform a polar airplane to dto', () => {
        expect(savedAirplaneToDTO({
            id: '1',
            planePoint: {
                type: 'POLAR',
                a: 10,
                b: 270,
            },
            vector: {
                speed: 100,
                direction: 100,
            },
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
            planePoint: {
                type: 'CARTESIAN',
                a: 4,
                b: -5,
            },
            vector: {
                speed: 100,
                direction: 100,
            },
        })).toEqual({
            id: '1',
            x: 4,
            y: -5,
            speed: 100,
            direction: 100,
        });
    });
});
