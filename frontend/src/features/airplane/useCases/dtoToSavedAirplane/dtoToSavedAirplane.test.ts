import { describe, expect, it } from 'vitest';
import { dtoToSavedAirplane } from './dtoToSavedAirplane';

describe('dtoToSavedAirplane', () => {
    it('should transform a dto to polar airplane', () => {
        expect(dtoToSavedAirplane(
            {
                id: '1',
                x: 0,
                y: -10,
                vector: { speed: 100, direction: 100 },
            },
            'POLAR',
        )).toEqual({
            id: '1',
            planePoint: { type: 'POLAR', a: 10, b: 270 },
            vector: { speed: 100, direction: 100 },
        });
    });

    it('should transform a dto to cartesian airplane', () => {
        expect(dtoToSavedAirplane(
            {
                id: '1',
                x: 4,
                y: -5,
                vector: { speed: 100, direction: 100 },
            },
            'CARTESIAN',
        )).toEqual({
            id: '1',
            planePoint: { type: 'CARTESIAN', a: 4, b: -5 },
            vector: { speed: 100, direction: 100 },
        });
    });
});
