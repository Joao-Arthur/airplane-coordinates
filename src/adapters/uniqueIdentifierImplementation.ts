import { nanoid } from 'nanoid';

export function uniqueIdentifierImplementation(): string {
    return nanoid(3);
}
