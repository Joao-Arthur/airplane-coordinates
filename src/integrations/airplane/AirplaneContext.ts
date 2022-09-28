import { createContext } from 'react'
import { environment } from '../../core/environment';
import { AirplaneGateway } from '../../features/airplane/gateways';

type contextType = {
    readonly airplaneGateway: AirplaneGateway;
}

export const AirplaneContext = createContext<contextType>(null!);

if (environment.isDev()) {
    AirplaneContext.displayName = 'AirplaneContext';
}