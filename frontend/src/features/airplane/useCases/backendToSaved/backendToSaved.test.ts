import { planeType } from '../../../backend/models/planeType';
import { backendToSaved } from './backendToSaved';

describe('backendToSaved', () => {
    it('should tranform the backend to the saved airplane format', () => {
        expect(backendToSaved({
            a: '2.01',
            b: '1.99',
            plane_type: planeType.CARTESIAN,
        })).toEqual({
            a: '2.01',
            b: '1.99',
            type: 'cartesian',
        });
        expect(backendToSaved({
            a: '8937.2348627',
            b: '-2364238',
            plane_type: planeType.POLAR,
        })).toEqual({
            a: '8937.2348627',
            b: '-2364238',
            type: 'polar',
        });
    });
});
