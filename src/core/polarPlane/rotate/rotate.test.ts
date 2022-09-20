import { describe, expect, it } from "vitest";
import { rotate } from "./rotate";

describe('rotate', () => {
    it('should rotate a point', () => {
        expect(rotate({ point: { radius: 1, angle: 300 }, angle: 50 })).toEqual({ radius: 1, angle: 350 });
        expect(rotate({ point: { radius: 1, angle: 200 }, angle: 50 })).toEqual({ radius: 1, angle: 250 });
        expect(rotate({ point: { radius: 1, angle: 111.11 }, angle: 11.40 })).toEqual({ radius: 1, angle: 122.51 });
        expect(rotate({ point: { radius: 1, angle: 34.02 }, angle: 19.04 })).toEqual({ radius: 1, angle: 53.06 });
        expect(rotate({ point: { radius: 1, angle: 60 }, angle: -120 })).toEqual({ radius: 1, angle: 300 });
        expect(rotate({ point: { radius: 1, angle: 60 }, angle: -60 })).toEqual({ radius: 1, angle: 0 });

    })
})