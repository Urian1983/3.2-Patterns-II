package builder;
import builder.view.PizzaCLI;

import java.util.Scanner;

public class MainBuilder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PizzaCLI pizzaRestaurant = new PizzaCLI();
        pizzaRestaurant.run(scanner);
    }
}
