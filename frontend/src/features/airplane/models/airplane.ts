export type airplaneType = {
    readonly id: string;
    readonly planePoint: {
        readonly x: number;
        readonly y: number;
    };
    readonly vector: {
        readonly speed: number;
        readonly direction: number;
    };
};
