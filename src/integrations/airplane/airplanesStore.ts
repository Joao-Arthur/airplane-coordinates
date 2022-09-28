import create from 'zustand';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';

type state = {
    readonly airplanes: readonly airplaneType[];
    readonly setAirplanes: (airplanes: readonly airplaneType[]) => void;
    readonly selectedAirplanes: readonly airplaneType['id'][];
    readonly selectAirplane: (id: string) => void;
    readonly unselectAirplane: (id: string) => void;
    readonly reports: readonly messageType[];
    readonly setReports: (reports: readonly messageType[]) => void;
};

export const useAirplaneStore = create<state>(set => ({
    airplanes: [],
    setAirplanes: (airplanes: readonly airplaneType[]) => set(() => ({ airplanes })),
    selectedAirplanes: [],
    selectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.concat(id) })),
    unselectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.filter(selected => selected !== id) })),
    reports: [],
    setReports: (reports: readonly messageType[]) => set(() => ({ reports })),
}))