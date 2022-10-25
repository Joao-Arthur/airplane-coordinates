import { getValueInEachQuadrant } from './getValueInEachQuadrant';

describe('getValueInEachQuadrant', () => {
    it('should the value in the four axis', () => {
        expect(getValueInEachQuadrant({ value: 10, angle: 0 })).toEqual(10);
        expect(getValueInEachQuadrant({ value: 10, angle: 90 })).toEqual(10);
        expect(getValueInEachQuadrant({ value: 10, angle: 180 })).toEqual(-10);
        expect(getValueInEachQuadrant({ value: 10, angle: 270 })).toEqual(-10);
        expect(getValueInEachQuadrant({ value: 10, angle: 360 })).toEqual(10);
    });

    it('should the value inbetween four axis', () => {
        expect(getValueInEachQuadrant({ value: 10, angle: 45 })).toEqual(10);
        expect(getValueInEachQuadrant({ value: 10, angle: 135 })).toEqual(-10);
        expect(getValueInEachQuadrant({ value: 10, angle: 225 })).toEqual(-10);
        expect(getValueInEachQuadrant({ value: 10, angle: 315 })).toEqual(10);
        expect(getValueInEachQuadrant({ value: 10, angle: 405 })).toEqual(10);
    });
});
