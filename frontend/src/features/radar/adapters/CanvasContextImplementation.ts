import { squareType } from '../../../core/cartesianPlane/square';
import { drawContextType } from '../ports/drawContext';

export class CanvasContextImplementation implements drawContextType {
    public constructor(private readonly context: CanvasRenderingContext2D) { }

    public drawSquare({ x, y, width, height }: squareType, color: string) {
        this.context.fillStyle = color;
        this.context.fillRect(x, y, width, height);
    }

    public drawCircle({ x, y, width, height }: squareType, color: string) {
        this.context.fillStyle = color;
        this.context.beginPath();
        this.context.arc(x + width / 2, y + height / 2, width, 0, 2 * Math.PI);
        this.context.fill();
    }

    public drawRing({ x, y, width, height }: squareType, color: string) {
        this.context.fillStyle = color;
        this.context.strokeStyle = color;
        this.context.beginPath();
        this.context.arc(x + width / 2, y + height / 2, width, 0, 2 * Math.PI);
        this.context.stroke();
    }

    public drawImage(square: squareType, url: string, angle: number) {
        const image = new Image();
        new Promise(resolve => {
            image.onload = resolve;
            image.src = url;
        }).then(() => {
            this.context.save();
            this.context.translate(
                square.x + square.width / 2,
                square.y + square.height / 2,
            );
            this.context.rotate(-1 * angle * Math.PI / 180);
            this.context.drawImage(
                image,
                -square.width / 2,
                -square.height / 2,
                square.width,
                square.height,
            );
            this.context.restore();
        });
    }
}
