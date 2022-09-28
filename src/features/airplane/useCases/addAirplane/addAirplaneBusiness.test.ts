import { describe, expect, it } from 'vitest';
import { addAirplaneBusiness } from './addAirplaneBusiness';
import { InvalidAirplaneError } from './InvalidAirplaneError';

describe('addAirplaneBusiness', () => {
    it('should return a airplane with cartesian coordinates', () => {
        expect(
            addAirplaneBusiness(
                { id: '1', x: 3, y: 7, speed: 100, direction: 100, }
            ),
        ).toEqual(
            { id: '1', x: 3, y: 7, speed: 100, direction: 100, },
        );
        expect(
            addAirplaneBusiness(
                { id: '1', x: 0, y: 0, speed: 100, direction: 100, }
            ),
        ).toEqual(
            { id: '1', x: 0, y: 0, speed: 100, direction: 100, },
        );
    });

    it('should return a airplane with polar coordinates', () => {
        expect(addAirplaneBusiness(
            { id: '1', radius: 1, angle: 0, speed: 100, direction: 100, }
        )).toEqual(
            { id: '1', x: 1, y: 0, speed: 100, direction: 100, },
        );
        expect(addAirplaneBusiness(
            { id: '1', radius: 2, angle: 180, speed: 100, direction: 100, }
        )).toEqual(
            { id: '1', x: -2, y: 0, speed: 100, direction: 100, }
        );
    });

    it('should return a airplane with no coordinates', () => {
        expect(() => addAirplaneBusiness(
            { id: '1', speed: 100, direction: 100, } as any
        )).toThrowError(
            InvalidAirplaneError
        );
    });
});
