import { BadFunctionError } from './BadFunctionError';
import { execute } from './execute';

describe('execute', () => {
    it('should execute the usual function', () => {
        expect(execute({ a: 1, b: -1 }, -1)).toBe(-2);
        expect(execute({ a: 1, b: -1 }, 0)).toBe(-1);
        expect(execute({ a: 1, b: -1 }, 1)).toBe(0);

        expect(execute({ a: 1, b: 0 }, -1)).toBe(-1);
        expect(execute({ a: 1, b: 0 }, 0)).toBe(0);
        expect(execute({ a: 1, b: 0 }, 1)).toBe(1);

        expect(execute({ a: 1, b: 1 }, -1)).toBe(0);
        expect(execute({ a: 1, b: 1 }, 0)).toBe(1);
        expect(execute({ a: 1, b: 1 }, 1)).toBe(2);

        expect(execute({ a: 2, b: -1 }, -1)).toBe(-3);
        expect(execute({ a: 2, b: -1 }, 0)).toBe(-1);
        expect(execute({ a: 2, b: -1 }, 1)).toBe(1);

        expect(execute({ a: 2, b: 0 }, -1)).toBe(-2);
        expect(execute({ a: 2, b: 0 }, 0)).toBe(0);
        expect(execute({ a: 2, b: 0 }, 1)).toBe(2);

        expect(execute({ a: 2, b: 1 }, -1)).toBe(-1);
        expect(execute({ a: 2, b: 1 }, 0)).toBe(1);
        expect(execute({ a: 2, b: 1 }, 1)).toBe(3);
    });

    it('should not execute a infinite function', () => {
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: -1 }, -1)).toThrowError(BadFunctionError);
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: -1 }, 0)).toThrowError(BadFunctionError);
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: -1 }, 1)).toThrowError(BadFunctionError);
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: 5 }, -1)).toThrowError(BadFunctionError);
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: 5 }, 0)).toThrowError(BadFunctionError);
        expect(() => execute({ a: Number.POSITIVE_INFINITY, b: 5 }, 1)).toThrowError(BadFunctionError);
    });
});
