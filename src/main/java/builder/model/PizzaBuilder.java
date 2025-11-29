package builder.model;

import builder.interfaces.Builder;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder implements Builder {

    Size size;
    Dough dough;
    private List<Ingredients> toppings = new ArrayList<>();

    public void reset() {
        size = null;
        dough = null;
        toppings = new ArrayList<>();
    }

    @Override
    public PizzaBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    @Override
    public PizzaBuilder setDough(Dough dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public PizzaBuilder addTopping(Ingredients ingredient) {
        toppings.add(ingredient);
        return this;
    }

    @Override
    public Pizza getPizza() {

        return new Pizza(size, dough, new ArrayList<>(toppings));

    }

    @Override
    public PizzaBuilder addToppings(List<Ingredients> ingredients) {
        this.toppings.addAll(ingredients);
        return this;
    }

}
