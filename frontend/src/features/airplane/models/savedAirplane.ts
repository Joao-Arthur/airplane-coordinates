export type savedAirplaneType = {
    readonly id: string;
    readonly planePoint: {
        readonly type: 'CARTESIAN' | 'POLAR';
        readonly a: number;
        readonly b: number;
    };
    readonly vector: {
        readonly speed: number;
        readonly direction: number;
    };
};
