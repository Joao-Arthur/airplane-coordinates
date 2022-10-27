type polarType = {
    type: 'polar';
    readonly x:  undefined;
    readonly y:  undefined;
    readonly radius: number;
    readonly angle: number;
}

type cartesianPolar = {
    type: 'cartesian';
    readonly x: number;
    readonly y: number;
    readonly radius: undefined;
    readonly angle: undefined;
}

export type savedAirplaneType = {
    readonly id: string;
    readonly speed: number;
    readonly direction: number;
} & (polarType | cartesianPolar);
