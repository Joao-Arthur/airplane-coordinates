import { dimensionType } from '../features/dimension';
import { drawContextType } from '../features/drawContext';

export class DrawContextImplementation implements drawContextType {

    public constructor(private readonly context: CanvasRenderingContext2D) { }

    public drawSquare({ x, y, width, height }: dimensionType, color: string) {
        this.context.fillStyle = color;
        this.context.fillRect(x, y, width, height);
    }

    public drawCircle({ x, y, width, height }: dimensionType, color: string) {
        this.context.fillStyle = color;
        this.context.beginPath();
        this.context.arc(x + width / 2, y + height / 2, width, 0, 2 * Math.PI);
        this.context.fill();
    }
}