type paramsType = {
    readonly speed: number;
    readonly distance: number;
};

export function timeToPoint({ speed, distance }: paramsType) {
    return distance / speed;
}
