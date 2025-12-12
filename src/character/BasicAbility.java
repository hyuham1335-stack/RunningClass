package character;

public enum BasicAbility {
    BASEHP(600),
    BASEAD(50),
    BASEDF(30);

    private final int figure;

    BasicAbility(int figure) {
        this.figure = figure;
    }

    public int getFigure() {
        return figure;
    }
}
