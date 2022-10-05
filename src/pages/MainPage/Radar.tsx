import { useEffect, useRef } from 'react';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useRadarStore } from '../../integrations/radar/radarStore';
import { useRadar } from '../../integrations/radar/useRadar';

type props = {
    readonly dimensions: number;
}

export function Radar({ dimensions }: props) {
    const { numberOfParts, radarView } = useRadarStore();
    const { draw } = useRadar();
    const airplanes = useAirplaneStore(state => state.airplanes);
    const canvasRef = useRef<HTMLCanvasElement>(null);

    useEffect(() => {
        if (!canvasRef.current)
            return;
        const context = canvasRef.current.getContext('2d');
        if (!context)
            return;
        draw(context, { width: dimensions, height: dimensions }, airplanes, { numberOfParts, radarView });
    }, [dimensions, airplanes, draw, numberOfParts, radarView]);

    return (
        <div className='h-full flex justify-center items-center'>
            <canvas
                width={dimensions}
                height={dimensions}
                style={{
                    width: dimensions,
                    height: dimensions,
                }}
                ref={canvasRef}
            />
        </div>
    );
}
