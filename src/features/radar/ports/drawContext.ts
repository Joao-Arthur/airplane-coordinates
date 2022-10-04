import { squareType } from '../../../core/cartesianPlane/square';

export type drawContextType = {
    readonly drawSquare: (dimension: squareType, color: string) => void;
    readonly drawCircle: (dimension: squareType, color: string) => void;
    readonly drawRing: (dimension: squareType, color: string) => void;
}
