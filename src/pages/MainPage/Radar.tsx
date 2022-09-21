import { useEffect, useRef } from "react";
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
        initCanvasPaint(context, dimensions);
    }, [dimensions]);

    return (
        <div className="h-full flex justify-center items-center">
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