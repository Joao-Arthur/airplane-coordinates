import { DrawContextImplementation } from "./implementations/DrawContextImplementation";
import { dimensionType } from "./models/dimension";
import { radarView } from "./view/radar/radar";

export function initCanvasPaint(
    context: CanvasRenderingContext2D,
    dimension: dimensionType
) {
    radarView(new DrawContextImplementation(context), dimension);
}
