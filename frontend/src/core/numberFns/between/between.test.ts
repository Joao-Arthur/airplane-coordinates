import { between } from './between';

describe('between', () => {
    it('should return the number in between', () => {
        expect(between({ value: 10, min: 10, max: 10 })).toBe(10);
        expect(between({ value: 10, min: 8, max: 12 })).toBe(10);
        expect(between({ value: 10, min: 0, max: 9 })).toBe(9);
        expect(between({ value: 10, min: 20, max: 100 })).toBe(20);
        expect(between({ value: 10, min: -100, max: -1 })).toBe(-1);
    });
});
