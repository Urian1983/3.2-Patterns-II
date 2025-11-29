package builder.model;

import java.util.Collections;
import java.util.List;

public class Pizza {

    private Size size;
    private Dough dough;
    private List<Ingredients> toppings;

    public Pizza(Size size, Dough dough, List<Ingredients> toppings) {
        this.size = size;
        this.dough = dough;
        this.toppings = Collections.unmodifiableList(toppings);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", dough=" + dough +
                ", toppings=" + toppings +
                '}';
    }

    public Size getSize(){
        return size;
    }

    public Dough getDough(){
        return dough;
    }

    public List<Ingredients> getToppings(){
        return toppings;
    }

}