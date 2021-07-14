package model;

import exception.InvalidCommandException;
import exception.UnsupportedObjectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanvasTest {
    @Test
    public void createCanvas() {
        Canvas canvas = new Canvas(10, 5);

        String[][] resultCanvas = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };

        Assertions.assertArrayEquals(canvas.getShape(), resultCanvas);
    }

    @Test
    public void fillBucket() throws InvalidCommandException{
        Canvas canvas = new Canvas(2, 3);
        canvas.fill(2, 1, "c");
        canvas.printShape();

        String[][] resultCanvas = { { "-", "-", "-", "-" },
                { "|", "c", "c", "|" },
                { "|", "c", "c", "|" },
                { "|", "c", "c", "|" },
                { "-", "-", "-", "-" } };

        Assertions.assertArrayEquals(canvas.getShape(), resultCanvas);
    }

    @Test
    public void fillBucketWithLine() throws InvalidCommandException, UnsupportedObjectException {
        Canvas canvas = new Canvas(10, 5);
        Line h_line = new Line(canvas);
        h_line.draw(1, 3, 6, 3);
        Line v_line = new Line(canvas);
        v_line.draw(6, 1, 6, 3);
        canvas.fill(1, 1, "c");
        canvas.printShape();

        String[][] resultCanvas = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", "x", "x", "x", "x", "x", "x", " ", " ", " ", " ", "|" },
                { "|", "c", "c", "c", "c", "c", "x", " ", " ", " ", " ", "|" },
                { "|", "c", "c", "c", "c", "c", "x", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };

        Assertions.assertArrayEquals(canvas.getShape(), resultCanvas);
    }
}
