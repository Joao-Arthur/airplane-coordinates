export function normalizeZero(value: number) {
    // -0 === 0
    return value === 0 ? 0 : value;
}
