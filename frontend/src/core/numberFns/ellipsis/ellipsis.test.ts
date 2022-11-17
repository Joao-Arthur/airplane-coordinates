import { describe, expect, it } from 'vitest';
import { ellipsis } from './ellipsis';

describe('ellipsis', () => {
    it('should return the value when no decimal places', () => {
        expect(ellipsis(3)).toBe('3');
        expect(ellipsis(-0.0)).toBe('0');
    });

    it('should return the value when one decimal place', () => {
        expect(ellipsis(33.1)).toBe('33.1');
        expect(ellipsis(-0.1)).toBe('-0.1');
    });

    it('should return the value when two decimal places', () => {
        expect(ellipsis(10.22)).toBe('10.22');
        expect(ellipsis(-3.44)).toBe('-3.44');
    });

    it('should not add ellipsis when rounded smaller in digits', () => {
        expect(ellipsis(8.99999)).toBe('9');
        expect(ellipsis(-3.299)).toBe('-3.3');
    });

    it('should round and add ellipsis', () => {
        expect(ellipsis(10.111)).toBe('10.11...');
        expect(ellipsis(10.229)).toBe('10.23...');
        expect(ellipsis(12.91216)).toBe('12.91...');
    });
});
