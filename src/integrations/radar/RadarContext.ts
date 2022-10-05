import { createContext } from 'react';
import { environment } from '../../core/environment';
import { CanvasRadarGateway } from '../../features/radar/gateway';

type contextType = {
    readonly radarGateway: CanvasRadarGateway;
}

// eslint-disable-next-line @typescript-eslint/naming-convention, @typescript-eslint/no-non-null-assertion
export const RadarContext = createContext<contextType>(null!);

if (environment.isDev())
    RadarContext.displayName = 'RadarContext';
