import create from 'zustand';

type state = {
    readonly radarView: 'cartesian' | 'polar';
    readonly setRadarView: (radarView: 'cartesian' | 'polar') => void;
    readonly numberOfParts: number;
    setNumberOfParts: (numberOfParts: number) => void;
};

export const useRadarStore = create<state>(set => ({
    radarView: 'cartesian',
    setRadarView: (radarView: 'cartesian' | 'polar') => set(() => ({ radarView })),
    numberOfParts: 20,
    setNumberOfParts: (numberOfParts: number) => set(() => ({ numberOfParts })),
}));
