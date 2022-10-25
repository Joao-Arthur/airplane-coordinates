import { relativeToAbsolute } from './relativeToAbsolute';

describe('relativeToAbsolute', () => {
    it('should transform in the middle', () => {
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: 0, y: 0 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 50, y: 50 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 300, height: 300 },
                position: { x: 0, y: 0 },
                numberOfParts: 40,
            }),
        ).toEqual({ x: 150, y: 150 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 600, height: 600 },
                position: { x: 0, y: 0 },
                numberOfParts: 2,
            }),
        ).toEqual({ x: 300, y: 300 });
    });

    it('should transform in the four axis', () => {
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: 5, y: 5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 100, y: 0 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: 5, y: -5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 100, y: 100 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: -5, y: 5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 0, y: 0 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: -5, y: -5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 0, y: 100 });
    });

    it('should transform inbetween the four axis', () => {
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: 0, y: 5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 50, y: 0 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: 0, y: -5 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 50, y: 100 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: -5, y: 0 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 0, y: 50 });
        expect(
            relativeToAbsolute({
                dimensions: { width: 100, height: 100 },
                position: { x: -5, y: 0 },
                numberOfParts: 10,
            }),
        ).toEqual({ x: 0, y: 50 });
    });

    it('should correctly transform', () => {
        expect(
            relativeToAbsolute({
                dimensions: { width: 10000, height: 10000 },
                position: { x: 22, y: 22 },
                numberOfParts: 100,
            }),
        ).toEqual({ x: 7200, y: 2800 });
    });
});
