import { airplaneType } from '../../airplane/models';
import { dimensionType } from '../models/dimension';
import { CanvasContextImplementation } from '../adapters/CanvasContextImplementation';
import { drawRadar } from '../useCases/drawRadar';

export class CanvasRadarGateway {
    public drawRadar(
        context: CanvasRenderingContext2D,
        dimension: dimensionType,
        airplanes: readonly airplaneType[],
    ) {
        drawRadar(new CanvasContextImplementation(context), dimension, airplanes);
    }
}
