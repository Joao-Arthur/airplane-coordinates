import { airplaneType } from '../features/airplane/models';
import { dimensionType } from '../features/dimension';
import { radarView } from '../view/radar/radar';
import { DrawContextImplementation } from './DrawContextImplementation';

export function canvasRadar(
    context: CanvasRenderingContext2D,
    dimension: dimensionType,
    airplanes: readonly airplaneType[]
) {
    radarView(new DrawContextImplementation(context), dimension, airplanes);
}
