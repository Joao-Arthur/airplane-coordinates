import { dimensionType } from '../../models/dimension';
import { drawContextType } from '../../ports/drawContext';

export function clearWindow(drawContext: drawContextType, { x, y, width, height }: dimensionType) {
    drawContext.drawSquare({ x, y, width, height }, '#ffffff');
}
