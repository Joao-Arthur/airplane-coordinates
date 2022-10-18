export function range(lowerLimit: number, upperLimit: number): readonly number[] {
    return Array(upperLimit - lowerLimit + 1)
        .fill(undefined)
        .map((_, i) => i + lowerLimit);
}
