package model;

import exception.InvalidCommandException;
import exception.UnsupportedObjectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {
    Canvas canvas = new Canvas(10,5);

    @Test
    public void createVerticalLine() throws InvalidCommandException, UnsupportedObjectException {
        Line line = new Line(canvas);
        line.draw(1, 1, 3, 1);

        String[][] resultShape = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", "x", "x", "x", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };
        Assertions.assertArrayEquals(resultShape, canvas.getShape());
    }

    @Test
    public void createHorizontalLine() throws InvalidCommandException, UnsupportedObjectException{
        Line line = new Line(canvas);
        line.draw(1, 1, 1, 3);

        String[][] resultShape = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", "x", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };
        Assertions.assertArrayEquals(resultShape, canvas.getShape());
    }

    @Test
    public void createLineAndThrowException(){
        Line line = new Line(canvas);
        Exception exception = Assertions.assertThrows(InvalidCommandException.class, () -> line.draw(12, 1, 15, 1));

        String expectedMessage = "Points are not valid.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void createSlopeAndThrowException(){
        Line line = new Line(canvas);
        Exception exception = Assertions.assertThrows(UnsupportedObjectException.class, () -> line.draw(1, 1, 3, 3));

        String expectedMessage = "Only horizontal or vertical line is supported.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
