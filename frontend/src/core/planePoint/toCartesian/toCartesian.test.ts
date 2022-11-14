import { describe, expect, it } from 'vitest';
import { toCartesian } from './toCartesian';

describe('toCartesian', () => {
    it('should transform cartesian to cartesian', () => {
        expect(
            toCartesian({ planeType: 'CARTESIAN', a: '10', b: '20' }),
        ).toEqual({ x: 10, y: 20 });
    });

    it('should transform polar to cartesian', () => {
        expect(
            toCartesian({ planeType: 'POLAR', a: '2', b: '180' }),
        ).toEqual({ x: -2, y: 0 });
    });
});
