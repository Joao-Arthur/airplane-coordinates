import { describe, expect, it } from 'vitest';
import { rotateAirplaneCoordinatesBusiness } from './rotateAirplaneCoordinatesBusiness';

describe('rotateAirplaneCoordinatesBusiness', () => {
    it('should rotate the airplanes coordinates', () => {
        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '1', planePoint: { planeType: 'CARTESIAN', a: '10', b: '10' }, vector: { direction: '100', speed: '100' } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '1', planePoint: { planeType: 'CARTESIAN', a: '10', b: '10' }, vector: { direction: '100', speed: '100' } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '2', planePoint: { planeType: 'CARTESIAN', a: '8', b: '8' }, vector: { direction: '100', speed: '100' } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '2', planePoint: { planeType: 'CARTESIAN', a: '12', b: '8' }, vector: { direction: '100', speed: '100' } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '3', planePoint: { planeType: 'CARTESIAN', a: '4', b: '2' }, vector: { direction: '100', speed: '100' } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '3', planePoint: { planeType: 'CARTESIAN', a: '18', b: '4' }, vector: { direction: '100', speed: '100' } });

        expect(rotateAirplaneCoordinatesBusiness({
            airplane: { id: '4', planePoint: { planeType: 'CARTESIAN', a: '11', b: '2' }, vector: { direction: '100', speed: '100' } },
            angle: 90,
            centerOfRotationX: 10,
            centerOfRotationY: 10,
        })).toEqual({ id: '4', planePoint: { planeType: 'CARTESIAN', a: '18', b: '11' }, vector: { direction: '100', speed: '100' } });

    });
});
