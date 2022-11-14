import create from 'zustand';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';

type state = {
    readonly airplanes: readonly airplaneType[];
    readonly setAirplanes: (airplanes: readonly airplaneType[]) => void;
    readonly selectedAirplanes: readonly airplaneType['id'][];
    readonly selectAirplane: (id: airplaneType['id']) => void;
    readonly unselectAirplane: (id: airplaneType['id']) => void;
    readonly reports: readonly messageType[];
    readonly setReports: (reports: readonly messageType[]) => void;
};

export const useAirplaneStore = create<state>(set => ({
    airplanes: [],
    setAirplanes: (airplanes: readonly airplaneType[]) => set(() => ({ airplanes })),
    selectedAirplanes: [],
    selectAirplane: (id: airplaneType['id']) => set(({ selectedAirplanes }) =>
        ({ selectedAirplanes: selectedAirplanes.concat(id) })),
    unselectAirplane: (id: airplaneType['id']) => set(({ selectedAirplanes }) =>
        ({ selectedAirplanes: selectedAirplanes.filter(selected => selected !== id) })),
    reports: [],
    setReports: (reports: readonly messageType[]) => set(() => ({ reports })),
}));
