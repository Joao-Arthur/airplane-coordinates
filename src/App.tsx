import { StrictMode, useRef } from 'react';
import { useDidMount } from 'rooks';
import {
    initCanvasPaint,
} from './canvas';
import { useWindowDimensions } from './useWindowDimensions';
import './index.css';

export function App() {
    const dimensions = useWindowDimensions();
    const canvasRef = useRef<HTMLCanvasElement>(null);

    useDidMount(() => {
        if (!canvasRef.current)
            return;
        const context = canvasRef.current.getContext('2d');
        if (!context)
            return;
        initCanvasPaint(context, dimensions);
        window.addEventListener('keypress', console.log);
    });

    return (
        <StrictMode>
            <canvas
                width={dimensions.width}
                height={dimensions.height}
                style={{
                    width: dimensions.width,
                    height: dimensions.height,
                }}
                ref={canvasRef}
            />
        </StrictMode>
    );
}
