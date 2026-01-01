package math;

public abstract class Element {
    private final int type;
    public static final int EXPRESSION = 0, NUMBER = 1, VARIABLE = 2;

    public Element(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public abstract double simplify();
}
