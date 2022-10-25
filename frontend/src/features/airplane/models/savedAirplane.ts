export type savedAirplaneType = {
    readonly id: string;
    readonly speed: number;
    readonly direction: number;
    readonly type: 'cartesian' | 'polar';
    readonly a: string;
    readonly b: string;
};
