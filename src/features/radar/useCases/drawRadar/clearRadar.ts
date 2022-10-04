import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { drawContextType } from '../../ports/drawContext';

export function clearWindow(drawContext: drawContextType, { width, height }: dimensionType) {
    drawContext.drawSquare({ x: 0, y: 0, width, height }, '#ffffff');
}
