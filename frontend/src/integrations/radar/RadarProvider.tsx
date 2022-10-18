import { ReactNode, useRef } from 'react';
import { CanvasRadarGateway } from '../../features/radar/gateway';
import { RadarContext } from './RadarContext';

type props = {
    readonly children: ReactNode;
}

export function RadarProvider({ children }: props) {
    const radarGateway = useRef(new CanvasRadarGateway()).current;

    return (
        <RadarContext.Provider value={{ radarGateway }}>
            {children}
        </RadarContext.Provider>
    );
}
