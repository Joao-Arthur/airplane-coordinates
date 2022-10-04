import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../models/dimension';
import { drawContextType } from '../../ports/drawContext';
import { clearWindow } from './clearRadar';
import { drawAirplanes } from './drawAirplanes';
import { drawAirport } from './drawAirport';
import { drawRadarCartesianPoints } from './drawRadarCartesianPoints';

export function drawRadar(drawContext: drawContextType, { x, y, width, height }: dimensionType, airplanes: readonly airplaneType[]) {
    clearWindow(drawContext, { x, y, width, height });
    drawRadarCartesianPoints(drawContext, { x, y, width, height });
    drawAirport(drawContext, { x, y, width, height });
    drawAirplanes(drawContext, { x, y, width, height }, airplanes);
}

