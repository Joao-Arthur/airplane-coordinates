import { useEffect, useRef } from "react";
import { useDidMount } from 'rooks';
import { initCanvasPaint } from "../../canvas";

type props = {
    dimensions: number;
}

export function Radar({ dimensions }: props) {
    const canvasRef = useRef<HTMLCanvasElement>(null);
    console.log(dimensions);

    useEffect(() => {
        if (!canvasRef.current)
            return;
        const context = canvasRef.current.getContext('2d');
        if (!context)
            return;
        initCanvasPaint(context);
    }, [dimensions]);

    return (
        <canvas
            width={dimensions}
            height={dimensions}
            style={{
                width: dimensions,
                height: dimensions,
            }}
            ref={canvasRef}
        />
    );
}