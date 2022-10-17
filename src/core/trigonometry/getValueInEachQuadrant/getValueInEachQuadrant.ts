type paramsType = {
    readonly value: number;
    readonly angle: number;
}

export function getValueInEachQuadrant({ value, angle }: paramsType) {
    if (angle <= 90)
        return value;
    if (angle <= 180)
        return -value;
    if (angle <= 270)
        return -value;
    return value;
}
