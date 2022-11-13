export type savedAirplaneType = {
    readonly id: string;
    readonly speed: number;
    readonly direction: number;
    readonly type: 'CARTESIAN' | 'POLAR';
    readonly a: number;
    readonly b: number;
};
