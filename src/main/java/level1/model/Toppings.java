package level1.model;

import java.util.ArrayList;
import java.util.List;

public class Toppings {

    private List<Ingredients> ingredients = new ArrayList<>();

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Ingredients ingredient){

    }

    public enum Ingredients {
        MOZZARELLA,
        PROSCIUTTO,
        SALAMI,
        RUCCULA;

    }

}
