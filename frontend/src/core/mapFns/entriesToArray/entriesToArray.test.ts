import { describe, expect, it } from 'vitest';
import { entriesToArray } from './entriesToArray';

describe('entriesToArray', () => {
    it('should return the entries of the map in an array', () => {
        expect(entriesToArray(new Map())).toEqual([]);
        expect(entriesToArray(new Map([
            [1, { name: 'Paul McCartney' }],
            [2, { name: 'George Harrison' }],
        ]))).toEqual([
            [1, { name: 'Paul McCartney' }],
            [2, { name: 'George Harrison' }],
        ]);
    });
});
