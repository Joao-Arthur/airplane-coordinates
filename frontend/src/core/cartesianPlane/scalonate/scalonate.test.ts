import { scalonate } from './scalonate';

describe('scalonate', () => {
    it('should scalonate the dimensions', () => {
        expect(scalonate({
            point: { x: 4, y: 7 },
            factor: { x: 2, y: -3 },
        })).toEqual({ x: 8, y: -21 });

        expect(scalonate({
            point: { x: -1, y: 3 },
            factor: { x: 2, y: -3 },
        })).toEqual({ x: -2, y: -9 });

        expect(scalonate({
            point: { x: 4, y: 7 },
            factor: { x: 0, y: 0 },
        })).toEqual({ x: 0, y: 0 });

        expect(scalonate({
            point: { x: -1, y: 3 },
            factor: { x: 0, y: 0 },
        })).toEqual({ x: 0, y: 0 });
    });
});
