import { describe, expect, it } from 'vitest';
import { formatHours } from './formatHours';

describe('formatHours', () => {
    it('should return only the hours for whole values', () => {
        expect(formatHours(3)).toBe('3h');
        expect(formatHours(0.0)).toBe('0h');
    });

    it('should round to minutes the decimal part', () => {
        expect(formatHours(1.5)).toBe('1h30min');
        expect(formatHours(5.25)).toBe('5h15min');
        expect(formatHours(7.75)).toBe('7h45min');
        expect(formatHours(0.1)).toBe('0h06min');
    });
});
