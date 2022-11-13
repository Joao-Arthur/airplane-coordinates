import { describe, expect, it } from 'vitest';
import { rotateAirplaneCoordinatesBusiness } from './rotateAirplaneCoordinatesBusiness';

describe('rotateAirplaneCoordinatesBusiness', () => {
    it('should rotate the airplanes coordinates', () => {
        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { x: 10, y: 10 }, vector: { direction: 100, speed: 100 } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '1', planePoint: { x: 10, y: 10 }, vector: { direction: 100, speed: 100 } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { x: 8, y: 8 }, vector: { direction: 100, speed: 100 } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '2', planePoint: { x: 12, y: 8 }, vector: { direction: 100, speed: 100 } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '3', planePoint: { x: 4, y: 2 }, vector: { direction: 100, speed: 100 } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '3', planePoint: { x: 18, y: 4 }, vector: { direction: 100, speed: 100 } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '4', planePoint: { x: 11, y: 2 }, vector: { direction: 100, speed: 100 } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '4', planePoint: { x: 18, y: 11 }, vector: { direction: 100, speed: 100 } });

    });
});
