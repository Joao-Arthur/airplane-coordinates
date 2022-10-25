import { distance } from './distance';

describe('distance', () => {
    it('should return 0 for the same point', () => {
        expect(distance(
            { x: 0, y: 0 },
            { x: 0, y: 0 },
        )).toBe(0);
        expect(distance(
            { x: 1, y: 1 },
            { x: 1, y: 1 },
        )).toBe(0);
    });

    it('should calculate the distance between two points in the X axis', () => {
        expect(distance(
            { x: -10, y: 5 },
            { x: 20, y: 5 },
        )).toBe(30);
    });

    it('should calculate the distance between two points in the Y axis', () => {
        expect(distance(
            { x: 5, y: 10 },
            { x: 5, y: -20 },
        )).toBe(30);
    });

    it('should calculate the distance between two points in the X and Y axis', () => {
        expect(distance(
            { x: 0, y: 0 },
            { x: 1, y: 1 },
        )).toBe(Math.sqrt(2));
        expect(distance(
            { x: -1, y: -1 },
            { x: 1, y: 1 },
        )).toBe(Math.sqrt(8));
    });
});
