import { createContext } from 'react';
import { environment } from '../../core/environment';
import { AirplaneGateway } from '../../features/airplane/gateways';

type contextType = {
    readonly airplaneGateway: AirplaneGateway;
}

// eslint-disable-next-line @typescript-eslint/naming-convention, @typescript-eslint/no-non-null-assertion
export const AirplaneContext = createContext<contextType>(null!);

if (environment.isDev())
    AirplaneContext.displayName = 'AirplaneContext';
