package model;

public abstract class PaintObject {
    Canvas canvas;

    protected PaintObject(Canvas canvas) {
        this.canvas = canvas;
    }

    protected void drawHorizontal(int start, int end, int point) {
        for (int i = start; i <= end; i++) {
            canvas.getShape()[canvas.getHeight() - point][i] = "x";
        }
    }

    protected void drawVertical(int start, int end, int point) {
        for (int i = start; i <= end; i++) {
            canvas.getShape()[canvas.getHeight() - i][point] = "x";
        }
    }

    protected Boolean validate(int x1, int y1) {
        return x1 > 0 && y1 > 0 && x1 < canvas.getShape()[0].length && y1 < canvas.getShape().length;
    }
}
