package constant;

public enum CommandType {
    Canvas("C"),
    Bucket("B"),
    Line("L"),
    Rectangle("R"),
    Quit("Q"),
    Help("H");

    public final String label;

    CommandType(String label) {
        this.label = label;
    }

    public static CommandType valueOfLabel(String label) {
        for (CommandType e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
