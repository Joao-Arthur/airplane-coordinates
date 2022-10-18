import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';
import { radarSettingsType } from '../../models/radarSettings';
import { clearWindow } from './clearRadar';
import { drawAirplanes } from './drawAirplanes';
import { drawAirport } from './drawAirport';
import { drawRadarCartesianPoints } from './drawRadarCartesianPoints';
import { drawRadarPolarPoints } from './drawRadarPolarPoints';
import { radarContextType } from './radarContext';
import { drawMainLines } from './drawMainLines';

export function drawRadar(
    drawContext: drawContextType,
    dimensions: dimensionType,
    airplanes: readonly airplaneType[],
    settings: radarSettingsType,
) {
    const context: radarContextType = {
        drawContext,
        dimensions,
        settings,
    };
    clearWindow(context);
    drawMainLines(context);
    switch (context.settings.radarView) {
        case 'cartesian':
            drawRadarCartesianPoints(context);
            break;
        case 'polar':
            drawRadarPolarPoints(context);
            break;
    }
    drawAirport(context);
    drawAirplanes(context, airplanes);
}

