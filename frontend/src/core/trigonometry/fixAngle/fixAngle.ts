import { numberFns } from '../../numberFns';

export function fixAngle(angle: number) {
    return numberFns.fix(((angle % 360) + 360) % 360);
}
