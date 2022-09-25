import { dimensionType } from '../models/dimension';
import { drawContextType } from '../ports/drawContext';

export class DrawContextImplementation implements drawContextType {

    public constructor(private readonly context: CanvasRenderingContext2D) { }

    public drawSquare({ x, y, width, height }: dimensionType, color: string): void {
        this.context.fillStyle = color;
        this.context.fillRect(x, y, width, height);
    }
}
