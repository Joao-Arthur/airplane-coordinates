import { describe, expect, it } from 'vitest';
import { addAirplaneBusiness } from './addAirplaneBusiness';
import { InvalidAirplaneError } from './InvalidAirplaneError';
import { MaxNumberOfAirplanesExceededError } from './MaxNumberOfAirplanesExceededError';

describe('addAirplaneBusiness', () => {
    it('should return a airplane with cartesian coordinates', () => {
        expect(
            addAirplaneBusiness({
                id: '1',
                x: 3,
                y: 7,
                angle: undefined,
                radius: undefined,
                speed: 100,
                direction: 100,
                numberOfAirplanes: 0,
                maxNumberOfAirplanes: 10,
            }),
        ).toEqual({ id: '1', x: 3, y: 7, speed: 100, direction: 100 });
        expect(
            addAirplaneBusiness({
                id: '1',
                x: 0,
                y: 0,
                angle: undefined,
                radius: undefined,
                speed: 100,
                direction: 100,
                numberOfAirplanes: 0,
                maxNumberOfAirplanes: 10,
            }),
        ).toEqual({ id: '1', x: 0, y: 0, speed: 100, direction: 100 });
    });

    it('should return a airplane with polar coordinates', () => {
        expect(
            addAirplaneBusiness({
                id: '1',
                x: undefined,
                y: undefined,
                radius: 1,
                angle: 0,
                speed: 100,
                direction: 100,
                numberOfAirplanes: 0,
                maxNumberOfAirplanes: 10,
            }),
        ).toEqual({ id: '1', x: 1, y: 0, speed: 100, direction: 100 });
        expect(
            addAirplaneBusiness({
                id: '1',
                x: undefined,
                y: undefined,
                radius: 2,
                angle: 180,
                speed: 100,
                direction: 100,
                numberOfAirplanes: 0,
                maxNumberOfAirplanes: 10,
            }),
        ).toEqual({ id: '1', x: -2, y: 0, speed: 100, direction: 100 });
    });

    it('should throw error with invalid airplane', () => {
        expect(() => addAirplaneBusiness({
            id: '1',
            x: undefined,
            y: undefined,
            radius: undefined,
            angle: undefined,
            speed: 100,
            direction: 100,
            numberOfAirplanes: 1,
            maxNumberOfAirplanes: 0,
        },
        )).toThrowError(InvalidAirplaneError);
    });

    it('should throw error when number of airplanes is excedeed', () => {
        expect(() => addAirplaneBusiness({
            id: '1',
            x: 3,
            y: 7,
            angle: undefined,
            radius: undefined,
            speed: 100,
            direction: 100,
            numberOfAirplanes: 1,
            maxNumberOfAirplanes: 0,
        })).toThrowError(MaxNumberOfAirplanesExceededError);
    });
});
