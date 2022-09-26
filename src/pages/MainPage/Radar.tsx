import { useEffect, useRef, useState } from "react";
import { useDidMount } from "rooks";
import { canvasRadar } from "../../implementations/canvasRadar";
import { airplaneType } from "../../models/airplane";

type props = {
    dimensions: number;
    onRepositoryUpdated: (callback: (airplanes: readonly airplaneType[]) => void) => void;
}

export function Radar({ dimensions, onRepositoryUpdated }: props) {
    const canvasRef = useRef<HTMLCanvasElement>(null);
    const [airplanes, setAirplanes] = useState<readonly airplaneType[]>([]);

    useDidMount(() => { onRepositoryUpdated(setAirplanes); });

    useEffect(() => {
        if (!canvasRef.current)
            return;
        const context = canvasRef.current.getContext('2d');
        if (!context)
            return;
        canvasRadar(context, { x: 0, y: 0, width: dimensions, height: dimensions }, airplanes);
    }, [dimensions, airplanes]);

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