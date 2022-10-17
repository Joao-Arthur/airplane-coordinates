import { describe, expect, it } from 'vitest';
import { collision } from './collision';

describe('collision', () => {
    it('should calculate the collision in the same direction', () => {
        expect(collision({
            a: { speed: 2, initialPoint: 0 },
            b: { speed: 1, initialPoint: 10 },
        })).toEqual({
            x: 10,
            y: 20,
        });
    });

    it('should calculate the collision point in opposite directions', () => {
        expect(collision({
            a: { speed: 1, initialPoint: -5 },
            b: { speed: -1, initialPoint: 5 },
        })).toEqual({
            x: 5,
            y: 0,
        });

        expect(collision({
            a: { speed: -3, initialPoint: 500 },
            b: { speed: 3, initialPoint: -500 },
        })).toEqual({
            x: 166.66666666666666,
            y: 0,
        });
    });

    it('should calculate the collision with a fixed point', () => {
        expect(collision({
            a: { speed: 0, initialPoint: 2 },
            b: { speed: 1, initialPoint: -8 },
        })).toEqual({
            x: 10,
            y: 2,
        });

        expect(collision({
            a: { speed: 0, initialPoint: 2 },
            b: { speed: -1, initialPoint: 8 },
        })).toEqual({
            x: 6,
            y: 2,
        });
    });

    it('should return infinite when collision does not happen', () => {
        expect(collision({
            a: { speed: 1, initialPoint: -5 },
            b: { speed: 1, initialPoint: 5 },
        })).toEqual({
            x: Number.POSITIVE_INFINITY,
            y: Number.POSITIVE_INFINITY,
        });
    });

});
