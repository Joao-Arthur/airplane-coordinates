import { describe, expect, it } from 'vitest';
import { valueToArray } from './valueToArray';

describe('valueToArray', () => {
    it('should return the values of the map in an array', () => {
        expect(valueToArray(new Map())).toEqual([]);
        expect(valueToArray(new Map([
            [1, { name: 'Paul McCartney' }],
            [2, { name: 'George Harrison' }],
        ]))).toEqual([
            { name: 'Paul McCartney' },
            { name: 'George Harrison' },
        ]);
    });
});
