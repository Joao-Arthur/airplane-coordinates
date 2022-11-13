export function entriesToArray<K, V>(instance: Map<K, V>): [K, V][] {
    const arrayValues: [K, V][] = [];
    const instanceIterator = instance.entries();
    for (const entry of instanceIterator)
        arrayValues.push(entry);
    return arrayValues;
}
