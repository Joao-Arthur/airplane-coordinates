export type airplaneCoordinatesType = {
    readonly type: 'cartesian' | 'polar';
    readonly a: string;
    readonly b: string;
}

export type savedAirplaneType = {
    readonly id: string;
    readonly speed: number;
    readonly direction: number;
} & airplaneCoordinatesType;
