import { describe, expect, it } from 'vitest';
import { toPolar } from './toPolar';

describe('toPolar', () => {
    it('should transform cartesian to polar', () => {
        expect(
            toPolar({ planeType: 'CARTESIAN', a: 5, b: 0 }),
        ).toEqual({ r: 5, a: 0 });
    });

    it('should transform polar to polar', () => {
        expect(
            toPolar({ planeType: 'POLAR', a: 4.4, b: 45 }),
        ).toEqual({ r: 4.4, a: 45 });
    });
});
