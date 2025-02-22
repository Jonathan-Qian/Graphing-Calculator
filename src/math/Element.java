package math;

public abstract class Element {
    private final int TYPE;
    public static final int SUB_EXPRESSION = 0, NUMBER = 1, VARIABLE = 2;

    public Element(int type) {
        TYPE = type;
    }

    public int getTYPE() {
        return TYPE;
    }

    public abstract double simplify();
}
