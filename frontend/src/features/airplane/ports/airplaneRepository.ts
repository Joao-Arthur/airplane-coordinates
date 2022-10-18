import { savedAirplaneType } from '../models';

export type airplaneRepositoryType = {
    readonly add: (airplane: savedAirplaneType) => void;
    readonly remove: (id: savedAirplaneType['id']) => void;
    readonly update: (airplane: savedAirplaneType) => void;
    readonly retrieve: () => readonly savedAirplaneType[];
};
