package level1.model;

public class Pizza {
    private Base base;
    private Dough dough;
    private Toppings toppings;

    public Pizza(Base base, Dough dough, Toppings toppings) {
        this.base = base;
        this.dough = dough;
        this.toppings = toppings;
    }

    public Base getBase() {
        return base;
    }

    public Dough getDough() {
        return dough;
    }

    public Toppings getToppings() {
        return toppings;
    }
}
