import { airplaneType } from '../../../airplane/models';
import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';
import { clearWindow } from './clearRadar';
import { drawAirplanes } from './drawAirplanes';
import { drawAirport } from './drawAirport';
import { drawRadarCartesianPoints } from './drawRadarCartesianPoints';
import { drawRadarPolarPoints } from './drawRadarPolarPoints';
import { radarContextType } from './radarContext';

export function drawRadar(drawContext: drawContextType, dimensions: dimensionType, airplanes: readonly airplaneType[]) {
    const context: radarContextType = {
        drawContext,
        dimensions,
        settings: {
            numberOfParts: 20,
            radarType: 'cartesian',
        },
    };
    clearWindow(context);
    switch (context.settings.radarType) {
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

