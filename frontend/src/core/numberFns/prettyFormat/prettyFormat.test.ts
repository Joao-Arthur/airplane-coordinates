import { describe, expect, it } from 'vitest';
import { prettyFormat } from './prettyFormat';

describe('prettyFormat', () => {
    it('should return the value when no decimal places', () => {
        expect(prettyFormat(3)).toBe('3');
        expect(prettyFormat(-0.0)).toBe('0');
    });

    it('should return the value when one decimal place', () => {
        expect(prettyFormat(33.1)).toBe('33.1');
        expect(prettyFormat(-0.1)).toBe('-0.1');
    });

    it('should return the value when two decimal places', () => {
        expect(prettyFormat(10.22)).toBe('10.22');
        expect(prettyFormat(-3.44)).toBe('-3.44');
    });

    it('should not add ellipsis when rounded smaller in digits', () => {
        expect(prettyFormat(8.99999)).toBe('9');
        expect(prettyFormat(-3.299)).toBe('-3.3');
    });

    it('should round and add ellipsis', () => {
        expect(prettyFormat(10.111)).toBe('10.11...');
        expect(prettyFormat(10.229)).toBe('10.23...');
        expect(prettyFormat(12.91216)).toBe('12.91...');
    });
});
