import { describe, expect, it } from 'vitest';
import { combination } from './combination';

describe('combination', () => {
    it('should return all the unique combinations', () => {
        expect(combination(['1', '2', '3', '4', '5'])).toEqual([
            ['1', '2'],
            ['1', '3'],
            ['1', '4'],
            ['1', '5'],
            ['2', '3'],
            ['2', '4'],
            ['2', '5'],
            ['3', '4'],
            ['3', '5'],
            ['4', '5'],
        ]);
        expect(combination(['1', '2', '3', '4'])).toEqual([
            ['1', '2'],
            ['1', '3'],
            ['1', '4'],
            ['2', '3'],
            ['2', '4'],
            ['3', '4'],
        ]);
        expect(combination(['1', '2', '3'])).toEqual([
            ['1', '2'],
            ['1', '3'],
            ['2', '3'],
        ]);
        expect(combination(['1', '2'])).toEqual([
            ['1', '2'],
        ]);
    });
});
