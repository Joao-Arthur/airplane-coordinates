import { dimensionType } from "./dimension"

export type drawContextType = {
    readonly drawSquare: (dimension: dimensionType, color: string) => void;
    readonly drawCircle: (dimension: dimensionType, color: string) => void;
}