import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';
import { clearWindow } from './clearRadar';
import { drawAirplanes } from './drawAirplanes';
import { drawAirport } from './drawAirport';
import { drawRadarCartesianPoints } from './drawRadarCartesianPoints';

export function drawRadar(drawContext: drawContextType, dimension: dimensionType, airplanes: readonly airplaneType[]) {
    clearWindow(drawContext, dimension);
    drawRadarCartesianPoints(drawContext, dimension);
    drawAirport(drawContext, dimension);
    drawAirplanes(drawContext, dimension, airplanes);
}

