package model;

import exception.InvalidCommandException;

public class Rectangle extends PaintObject{

    public Rectangle(Canvas canvas) {
        super(canvas);
    }

    public void draw(int x1, int y1, int x2, int y2) throws InvalidCommandException {
        if (!validate(x1, y1) || !validate(x2, y2) || !checkPoints(x1, y1, x2, y2))
            throw new InvalidCommandException("Points are not valid.");
        //top
        super.drawHorizontal(x1, x2, y1);
        //bottom
        super.drawHorizontal(x1, x2, y2);
        //left
        super.drawVertical(y2, y1, x1);
        //right
        super.drawVertical(y2, y1, x2);
        //Print canvas
        canvas.printShape();
    }

    private Boolean checkPoints(int x1, int y1, int x2, int y2) {
        return x1 <= x2 && y1 >= y2;
    }
}
