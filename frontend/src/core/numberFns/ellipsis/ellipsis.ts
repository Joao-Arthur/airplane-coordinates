export function ellipsis(value: number) {
    const stringDecimalValue = String(value).split('.')[1];
    if (!stringDecimalValue)
        return String(value);
    if (stringDecimalValue.length < 3)
        return String(value);
    const roundedValue = value.toFixed(2);
    const stringDecimalRoundedValue = String(Number(roundedValue)).split('.')[1];
    if (!stringDecimalRoundedValue)
        return String(Number(roundedValue));
    if (stringDecimalRoundedValue.length < 2)
        return String(Number(roundedValue));
    return roundedValue + '...';
}
