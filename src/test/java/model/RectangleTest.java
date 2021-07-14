package model;

import exception.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    Canvas canvas = new Canvas(10,5);

    @Test
    public void createRectangle() throws InvalidCommandException {
        Rectangle rectangle = new Rectangle(canvas);
        rectangle.draw(2, 4, 5, 1);

        String[][] resultShape = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
                { "|", " ", "x", "x", "x", "x", " ", " ", " ", " ", " ", "|" },
                { "|", " ", "x", " ", " ", "x", " ", " ", " ", " ", " ", "|" },
                { "|", " ", "x", " ", " ", "x", " ", " ", " ", " ", " ", "|" },
                { "|", " ", "x", "x", "x", "x", " ", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };
        Assertions.assertArrayEquals(resultShape, canvas.getShape());
    }

    @Test
    public void createOverlappedRectangle() throws InvalidCommandException {
        Rectangle rectangle = new Rectangle(canvas);
        rectangle.draw(2, 4, 5, 1);
        rectangle.draw(4, 5, 7, 2);

        String[][] resultShape = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
                { "|", " ", " ", " ", "x", "x", "x", "x", " ", " ", " ", "|" },
                { "|", " ", "x", "x", "x", "x", " ", "x", " ", " ", " ", "|" },
                { "|", " ", "x", " ", "x", "x", " ", "x", " ", " ", " ", "|" },
                { "|", " ", "x", " ", "x", "x", "x", "x", " ", " ", " ", "|" },
                { "|", " ", "x", "x", "x", "x", " ", " ", " ", " ", " ", "|" },
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" } };
        Assertions.assertArrayEquals(resultShape, canvas.getShape());
    }

    // Pass points which are not upper left corner and lower right corner
    @Test
    public void createRectangleAndThrowException(){
        Rectangle line = new Rectangle(canvas);
        Exception exception = Assertions.assertThrows(InvalidCommandException.class, () -> line.draw(1, 1, 3, 3));

        String expectedMessage = "Points are not valid.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
