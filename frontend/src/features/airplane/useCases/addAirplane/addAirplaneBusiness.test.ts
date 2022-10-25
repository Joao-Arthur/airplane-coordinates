import { addAirplaneBusiness } from './addAirplaneBusiness';
import { MaxNumberOfAirplanesExceededError } from './MaxNumberOfAirplanesExceededError';

describe('addAirplaneBusiness', () => {
    it('should throw error when number of airplanes is excedeed', () => {
        expect(() => addAirplaneBusiness({
            id: '1',
            type: 'cartesian',
            x: 3,
            y: 7,
            angle: undefined,
            radius: undefined,
            speed: 100,
            direction: 100,
            numberOfAirplanes: 1,
            maxNumberOfAirplanes: 1,
        })).toThrowError(MaxNumberOfAirplanesExceededError);
    });
});
