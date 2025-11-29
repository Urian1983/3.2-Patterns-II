package builder.interfaces;

import builder.model.Dough;
import builder.model.Ingredients;
import builder.model.Pizza;
import builder.model.Size;

import java.util.List;

public interface Builder {

    public Builder setSize(Size size);
    public Builder setDough (Dough dough);
    public Builder addTopping (Ingredients ingredient);
    public Builder addToppings(List<Ingredients> ingredients);
    public void reset();
    public Pizza getPizza();
}
