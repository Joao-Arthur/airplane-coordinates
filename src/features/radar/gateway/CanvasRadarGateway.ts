import { airplaneType } from '../../airplane/models';
import { dimensionType } from '../../../core/cartesianPlane/dimension';
import { CanvasContextImplementation } from '../adapters/CanvasContextImplementation';
import { drawRadar } from '../useCases/drawRadar';
import { radarSettingsType } from '../models/radarSettings';

export class CanvasRadarGateway {
    public drawRadar(
        context: CanvasRenderingContext2D,
        dimension: dimensionType,
        airplanes: readonly airplaneType[],
        settings: radarSettingsType,
    ) {
        drawRadar(
            new CanvasContextImplementation(context),
            dimension,
            airplanes,
            settings,
        );
    }
}
