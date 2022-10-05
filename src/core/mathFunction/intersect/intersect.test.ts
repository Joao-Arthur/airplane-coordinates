import { describe, expect, it } from 'vitest';
import { intersect } from './intersect';

describe('intersect', ()=> {
    it('should intersect the functions', ()=> {
        expect(
            intersect({
                fx: { a: 2, b: -8 },
                gx: { a: -3, b: 2 },
            })
        ).toEqual({ a: 5, b: -10 });

        expect(
            intersect({
                fx: { a: 4, b: 5 },
                gx: { a: 3, b: 1 },
            })
        ).toEqual({ a: 1, b: 4 });
    });
});
