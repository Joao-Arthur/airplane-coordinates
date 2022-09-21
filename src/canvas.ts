export function initCanvasPaint(
    context: CanvasRenderingContext2D,
    dimensions: number
) {
    context.fillStyle = '#5555aa';
    context.fillRect(
        0,
        0,
        dimensions,
        dimensions,
    );
}
