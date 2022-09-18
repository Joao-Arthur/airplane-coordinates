export function combination(values: string[]): [string, string][] {
    const newValues: [string, string][] = [];
    for (let i = 0; i < values.length - 1; i++)
        for (let j = i + 1; j < values.length; j++)
            newValues.push([values[i], values[j]]);
    return newValues;
}
