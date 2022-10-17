import { describe, expect, it } from 'vitest';
import { fixAngle } from './fixAngle';

describe('fixAngle', () => {
    it('should fix negative angles', () => {
        expect(fixAngle(-100)).toBe(260);
        expect(fixAngle(-1)).toBe(359);
    });

    it('should fix angles greater than 360', () => {
        expect(fixAngle(360)).toBe(0);
        expect(fixAngle(720)).toBe(0);
        expect(fixAngle(405)).toBe(45);
        expect(fixAngle(765)).toBe(45);
    });

    it('should keep the angles already ok', () => {
        expect(fixAngle(0)).toBe(0);
        expect(fixAngle(10)).toBe(10);
        expect(fixAngle(90)).toBe(90);
        expect(fixAngle(111.11)).toBe(111.11);
    });
});
