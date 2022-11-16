import { airplaneType } from '../models';

export type airplaneRepositoryType = {
    readonly add: (airplane: airplaneType) => void;
    readonly remove: (id: airplaneType['id']) => void;
    readonly updatePointById: (id: airplaneType['id'], point: airplaneType['point']) => void;
    readonly retrieve: () => readonly airplaneType[];
};
