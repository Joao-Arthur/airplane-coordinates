import { describe, expect, it } from 'vitest';
import { collision } from './collision';

describe('collision', () => {
    it('should calculate the collision in the same direction', () => {
        expect(collision({
            a: { speed: 2, initialPoint: 0 },
            b: { speed: 1, initialPoint: 10 },
        })).toEqual(20);
    });

    it('should calculate the collision point in opposite directions', () => {
        expect(collision({
            a: { speed: 1, initialPoint: -5 },
            b: { speed: -1, initialPoint: 5 },
        })).toEqual(0);

        expect(collision({
            a: { speed: -3, initialPoint: 500 },
            b: { speed: 3, initialPoint: -500 },
        })).toEqual(0);
    });

    it('should throw when collision does not happen', () => {
        expect(collision({
            a: { speed: 1, initialPoint: -5 },
            b: { speed: 1, initialPoint: 5 },
        })).toBe(Number.POSITIVE_INFINITY);
    });

});
