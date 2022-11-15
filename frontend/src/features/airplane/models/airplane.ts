import { planePointType } from '../../../core/planePoint/planePointType';
import { vectorType } from '../../../core/vector/vector';

export type airplaneType = {
    readonly id: string;
    readonly point: planePointType;
    readonly vector: vectorType;
};
