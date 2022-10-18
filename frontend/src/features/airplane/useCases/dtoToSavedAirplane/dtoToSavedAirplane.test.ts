import { describe, expect, it } from 'vitest';
import { dtoToSavedAirplane } from './dtoToSavedAirplane';

describe('dtoToSavedAirplane', () => {
    it('should transform a dto to polar airplane', () => {
        expect(dtoToSavedAirplane(
            {
                id: '1',
                x: 0,
                y: -10,
                speed: 100,
                direction: 100,
            },
            'polar',
        )).toEqual({
            id: '1',
            type: 'polar',
            x: undefined,
            y: undefined,
            radius: 10,
            angle: 270,
            speed: 100,
            direction: 100,
        });
    });

    it('should transform a dto to cartesian airplane', () => {
        expect(dtoToSavedAirplane(
            {
                id: '1',
                x: 4,
                y: -5,
                speed: 100,
                direction: 100,
            },
            'cartesian',
        )).toEqual({
            id: '1',
            type: 'cartesian',
            x: 4,
            y: -5,
            radius: undefined,
            angle: undefined,
            speed: 100,
            direction: 100,
        });
    });
});
