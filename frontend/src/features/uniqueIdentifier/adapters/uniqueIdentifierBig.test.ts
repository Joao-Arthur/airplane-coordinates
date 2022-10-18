import { describe, expect, it } from 'vitest';
import { uniqueIdentifierBig } from './uniqueIdentifierBig';

describe('uniqueIdentifierBig', () => {
    it('should return a big identifier that does not repeat', () => {
        const uniqueIds = Array(100).fill(undefined).map(uniqueIdentifierBig);
        const idsSet = new Set(uniqueIds);
        expect(uniqueIds.length).toBe(Array.from(idsSet).length);
    });
});
