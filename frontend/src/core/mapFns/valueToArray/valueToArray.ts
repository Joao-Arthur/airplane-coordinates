export function valueToArray<K, V>(instance: Map<K, V>): V[] {
    const arrayValues: V[] = [];
    const instanceIterator = instance.values();
    for (const value of instanceIterator)
        arrayValues.push(value);
    return arrayValues;
}
