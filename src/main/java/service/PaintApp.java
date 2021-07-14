package service;

import constant.CommandType;
import exception.InvalidCommandException;
import exception.UnsupportedObjectException;
import model.Canvas;
import model.Line;
import model.Rectangle;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaintApp {

    public void run(String[] args) {
        boolean exit = false;
        Canvas canvas = null;

        while (!exit) {
            try {
                System.out.println("Please input some command:");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String[] commands = input.split(" ");

                CommandType commandType = commands.length != 0 ? CommandType.valueOfLabel(commands[0]) : null;

                if (Objects.isNull(commandType)) {
                    printUsage();
                    continue;
                }

                switch (commandType) {
                    case Canvas:
                        validateInput(input, 2, 0);
                        canvas = new Canvas(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                        canvas.printShape();
                        break;
                    case Line:
                        if (!Objects.isNull(canvas)) {
                            validateInput(input, 4, 0);
                            Line line = new Line(canvas);
                            line.draw(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
                        } else {
                            throw new InvalidCommandException("Canvas is not created");
                        }
                        break;
                    case Rectangle:
                        if (!Objects.isNull(canvas)) {
                            validateInput(input, 4, 0);
                            Rectangle rectangle = new Rectangle(canvas);
                            rectangle.draw(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
                        } else {
                            throw new InvalidCommandException("Canvas is not created");
                        }
                        break;
                    case Bucket:
                        if (!Objects.isNull(canvas)) {
                            validateInput(input, 2, 1);
                            canvas.fill(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), commands[3]);
                            canvas.printShape();
                        } else {
                            throw new InvalidCommandException("Canvas is not created");
                        }
                        break;
                    case Quit:
                        exit = true;
                        break;
                    case Help:
                        printUsage();
                        break;
                }
            } catch (InvalidCommandException | UnsupportedObjectException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void validateInput(String input,int numOfPoints, int numOfColors ) throws Exception {
        Pattern pattern = Pattern.compile("[a-zA-Z](\\s\\d+){" + numOfPoints + "}(\\s[a-zA-z]){" + numOfColors + "}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new Exception("Invalid command.");
        }
    }

    private static void printUsage() {
        final String paintHelp = "usage: <command> [<args>] \n"
                + "C w h           Create a new canvas of width w and height h.\n"
                + "L x1 y1 x2 y2   Draw a new line from (x1,y1) to (x2,y2).\n"
                + "R x1 y1 x2 y2   Draw a rectangle whose upper left corner is (x1,y1) and lower right corner is (x2, y2).\n"
                + "B x y c         Fill the entire area connected to (x,y) with \"colour\" c.\n"
                + "Q               Quit\n";
        System.out.println(paintHelp);
    }
}
