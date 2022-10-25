import { planeType } from '../models/planeType';

export type backendPlanePointType = {
    readonly plane_type: planeType;
    readonly a: string;
    readonly b: string;
}
