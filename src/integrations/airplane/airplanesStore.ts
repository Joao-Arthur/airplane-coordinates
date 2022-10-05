import create from 'zustand';
import { airplaneType, savedAirplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';

type state = {
    readonly airplanes: readonly savedAirplaneType[];
    readonly setAirplanes: (airplanes: readonly savedAirplaneType[]) => void;
    readonly selectedAirplanes: readonly airplaneType['id'][];
    readonly selectAirplane: (id: string) => void;
    readonly unselectAirplane: (id: string) => void;
    readonly reports: readonly messageType[];
    readonly setReports: (reports: readonly messageType[]) => void;
};

export const useAirplaneStore = create<state>(set => ({
    airplanes: [],
    setAirplanes: (airplanes: readonly savedAirplaneType[]) => set(() => ({ airplanes })),
    selectedAirplanes: [],
    selectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.concat(id) })),
    unselectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.filter(selected => selected !== id) })),
    reports: [],
    setReports: (reports: readonly messageType[]) => set(() => ({ reports })),
}));
