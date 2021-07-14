package model;

import exception.InvalidCommandException;
import exception.UnsupportedObjectException;

import java.util.Arrays;

public class Line extends PaintObject{
    public Line(Canvas canvas) {
        super(canvas);
    }

    public void draw(int x1, int y1, int x2, int y2) throws InvalidCommandException, UnsupportedObjectException {
        if (!validate(x1, y1) || !validate(x2, y2))
            throw new InvalidCommandException("Points are not valid.");
        if (x1 == x2) {
            int[] points = reorderPoints(y1,y2);
            super.drawVertical(points[0], points[1], x1);
        } else if (y1 == y2) {
            int[] points = reorderPoints(x1,x2);
            super.drawHorizontal(points[0], points[1], y1);
        } else {
            throw new UnsupportedObjectException("Only horizontal or vertical line is supported.");
        }
        canvas.printShape();
    }

    private int[] reorderPoints(int p1, int p2) {
        int[] orderedPoints = new int[]{p1, p2};
        Arrays.sort(orderedPoints);
        return orderedPoints;
    }
}
