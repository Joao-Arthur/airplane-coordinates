import { planeType } from '../../../backend/models/planeType';
import { savedToBackend } from './savedToBackend';

describe('savedToBackend', () => {
    it('should tranform the saved airplane to the backend format', () => {
        expect(savedToBackend({
            a: '2.01',
            b: '1.99',
            type: 'cartesian',
        })).toEqual({
            a: '2.01',
            b: '1.99',
            plane_type: planeType.CARTESIAN,
        });
        expect(savedToBackend({
            a: '8937.2348627',
            b: '-2364238',
            type: 'polar',
        })).toEqual({
            a: '8937.2348627',
            b: '-2364238',
            plane_type: planeType.POLAR,
        });
    });
});
