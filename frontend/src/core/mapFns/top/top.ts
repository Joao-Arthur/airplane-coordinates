import { last } from 'ramda';
import { entriesToArray } from '../entriesToArray';

type returnType<K, V> = {
    readonly key: K;
    readonly value: V;
}

export function top<K, V>(instance: Map<K, V>): returnType<K, V> | undefined {
    const entries = entriesToArray(instance);
    const lastEntry = last(entries);
    if (!lastEntry)
        return undefined;
    const [key, value] = lastEntry;

    return {
        key,
        value,
    };
}
