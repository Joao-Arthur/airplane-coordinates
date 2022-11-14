import { planePointType } from '../../../core/planePoint/planePointType';

export type airplaneType = {
    readonly id: string;
    readonly planePoint: planePointType;
    readonly vector: {
        readonly speed: number;
        readonly direction: number;
    };
};
