export function normalizeZero(value: number) {
    return value === -0 ? 0 : value;
}