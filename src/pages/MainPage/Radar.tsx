import { useEffect, useRef } from 'react';
import { airplaneType } from '../../features/airplane/models';
import { CanvasRadarGateway } from '../../features/radar/gateway';

type props = {
    airplanes: readonly airplaneType[];
    dimensions: number;
}

export function Radar({ airplanes, dimensions }: props) {
    const canvasRef = useRef<HTMLCanvasElement>(null);

    useEffect(() => {
        if (!canvasRef.current)
            return;
        const context = canvasRef.current.getContext('2d');
        if (!context)
            return;
        new CanvasRadarGateway().drawRadar(context, { x: 0, y: 0, width: dimensions, height: dimensions }, airplanes);
    }, [dimensions, airplanes]);

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