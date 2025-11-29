package builder.model;

import java.util.List;

public class PizzaMaster {

    private PizzaBuilder pizzaBuilder = new PizzaBuilder();
    public PizzaMaster(PizzaBuilder pizzaBuilder) {

        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza buildPizza(Size size, Dough dough, List<Ingredients> toppings) {
                pizzaBuilder.reset();

                pizzaBuilder.setSize(size)
                   .setDough(dough)
                   .addToppings(toppings);

        return pizzaBuilder.getPizza();
    }


}
