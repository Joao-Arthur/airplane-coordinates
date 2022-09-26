import { airplaneType } from '../models';

export type airplaneRepositoryType = {
    readonly add: (airplane: airplaneType) => void;
    readonly remove: (id: string) => void;
    readonly update: (airplane: airplaneType) => void;
    readonly retrieve: () => readonly airplaneType[];
};