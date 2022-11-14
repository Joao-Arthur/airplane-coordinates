import { planePointType } from '../../../core/planePoint/planePointType';

export type savedAirplaneType = {
    readonly id: string;
    readonly planePoint: planePointType;
    readonly vector: {
        readonly speed: number;
        readonly direction: number;
    };
};
