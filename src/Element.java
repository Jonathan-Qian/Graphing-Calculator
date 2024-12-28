public abstract class Element {
    private final int TYPE;
    public static final int SUB_EQUATION = 0, NUMBER = 1, OPERATION = 2;

    public Element(int type) {
        TYPE = type;
    }

    public int getTYPE() {
        return TYPE;
    }

    public abstract double simplify();
}
