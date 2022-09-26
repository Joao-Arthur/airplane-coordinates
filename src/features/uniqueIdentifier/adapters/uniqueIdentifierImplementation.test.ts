import { describe, expect, it } from 'vitest';
import { uniqueIdentifierImplementation } from './uniqueIdentifierImplementation';

describe('uniqueIdentifierImplementation', () => {
    it('should return a identifier that does not repeat', () => {
        const uniqueIds = Array(100).fill(undefined).map(uniqueIdentifierImplementation);
        const idsSet = new Set(uniqueIds);
        expect(uniqueIds.length).toBe(Array.from(idsSet).length);
    });
});
