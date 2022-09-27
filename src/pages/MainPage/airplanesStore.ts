import create from 'zustand';
import { airplaneType } from '../../features/airplane/models';
import { messageType } from '../../features/logger/model';

type state = {
    airplanes: airplaneType[];
    selectedAirplanes: airplaneType['id'][];
    reports: messageType[];
};

export const useAirplaneStore = create<state>(set => ({
    airplanes: [],
    setAirplanes: (airplanes: airplaneType[]) => set(() => ({ airplanes })),
    selectedAirplanes: [],
    selectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.concat(id) })),
    unselectAirplane: (id: string) => set(({ selectedAirplanes }) => ({ selectedAirplanes: selectedAirplanes.filter(selected => selected !== id) })),
    reports: [],
    setReports: (reports: messageType[]) => set(() => ({ reports })),
}))