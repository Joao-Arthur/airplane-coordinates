export function formatHours(value: number) {
    const hours = String(value).split('.')[0];
    const decimalMinutes = value - Number.parseInt(String(value));
    const minutes = decimalMinutes * 0.6;

    if (minutes === 0)
        return `${hours}h`;
    return `${hours}h${minutes.toFixed(2).split('.')[1]}min`;
}
