import { airplaneType, unsavedAirplane } from '../entities/airplane';

export type airplaneRepository = {
    readonly add: (airplane: unsavedAirplane) => void;
    readonly remove: (id: string) => void;
    readonly update: (airplane: airplaneType) => void;
    readonly retrieve: () => readonly airplaneType[];
};
