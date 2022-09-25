import { dimensionType } from "../models/dimension"

export type drawContextType = {
    readonly drawSquare: (dimension: dimensionType, color: string) => void;
}