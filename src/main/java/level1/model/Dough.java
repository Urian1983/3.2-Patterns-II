package level1.model;

public class Dough {
    private DoughType doughType;

    public Dough(DoughType doughType) {
        this.doughType = doughType;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public enum DoughType {
        NAPOLITANA,
        ROMANA,
        AMERICANA,
        PIZZA_BLANCA;
    }

}