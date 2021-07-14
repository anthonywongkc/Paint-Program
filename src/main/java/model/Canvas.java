package model;

import exception.InvalidCommandException;

import java.util.Arrays;

public class Canvas {

    private String[][] shape;
    private int height;

    public Canvas(int x, int y) {
        this.height = y + 1;
        this.shape = new String[y+2][x+2];

        for (int i = 0; i < this.shape[0].length; i ++) {
            shape[0][i] = "-";
            for (int j = 1; j < this.shape.length - 1; j++) {
                if (i == 0 || i == this.shape[0].length - 1) {
                    shape[j][i] = "|";
                } else {
                    shape[j][i] = " ";
                }
            }
            shape[this.shape.length - 1][i] = "-";
        }

    }

    public String[][] getShape() {
        return shape;
    }

    public int getHeight() {
        return this.height;
    }

    public void printShape() {
        System.out.println(Arrays.deepToString(this.shape)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("]]", "")
                .replace(", ", "")
        );
    }

    public void fill(int x, int y, String c) throws InvalidCommandException {
        int height = this.getHeight() - y;
        if (!shape[height][x].equals("x") && !shape[height][x].equals("|") && !shape[height][x].equals("-") && !shape[height][x].equals(c)) {
            shape[height][x] = c;
            fill(x, y + 1, c);
            fill(x, y - 1, c);
            fill(x - 1, y, c);
            fill(x + 1, y, c);
        }
    }
}
