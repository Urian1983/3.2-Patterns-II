package level1.model;

public class PizzaBuilder {
    private Base base;
    private Dough dough;
    private Toppings toppings = new Toppings();

    public PizzaBuilder setBase(Base base) {
        this.base = base;
        return this;
    }

    public PizzaBuilder setDough(Dough dough) {
        this.dough = dough;
        return this;
    }

    public void setToppings(Toppings.Ingredients ingredient) {
        this.toppings.getIngredients().add(ingredient);
    }

    public Pizza build(){
        if(base == null){
            throw new IllegalStateException("Pizza needs a base");
        }
        if(dough == null){
            throw new IllegalStateException("Pizza needs a Dough");
        }

        return new Pizza(base, dough, toppings);
    }
}

