import { radarContextType } from './radarContext';

export function clearWindow({ drawContext, dimensions: { width, height } }: radarContextType) {
    drawContext.drawSquare({ x: 0, y: 0, width, height }, '#ffffff');
}
