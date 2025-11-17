package level1.View;

import level1.model.*;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PizzaView {

    Scanner scanner = new Scanner(System.in);
    PizzaBuilder pizzaBuilder = new PizzaBuilder();


    public void run() throws IllegalArgumentException{
       chooseBase();
       chooseDough();
       chooseToppings();

        Pizza pizza = pizzaBuilder.build();

        System.out.println("Your pizza is ready!");
        System.out.println("Base: " + pizza.getBase().getBaseType());
        System.out.println("Dough: " + pizza.getDough().getDoughType());
        System.out.println("Toppings:");
        pizza.getToppings().getIngredients()
                .forEach(t -> System.out.println("- " + t));
    }

    public void chooseBase() {

        Base.BaseType[] bases = Base.BaseType.values();

        System.out.println("Available bases:");
        IntStream.range(0, bases.length)
                .forEach(i -> System.out.println(i + 1 + " " + bases[i]));

        System.out.println("Please, choose and option");
        int option = readOption(1, bases.length);

        Base.BaseType choosenBase = bases[option - 1];
        pizzaBuilder.setBase(new Base(choosenBase));

    }

    public void chooseDough() {

        Dough.DoughType[] doughs = Dough.DoughType.values();

        System.out.println("Available doughs:");
        IntStream.range(0,doughs.length)
                .forEach(i -> System.out.println(i+1 + " " + doughs[i]));

        System.out.println("Please, choose and option");
        int option = readOption(1, doughs.length);


        Dough.DoughType choosenDough = doughs[option-1];
        pizzaBuilder.setDough(new Dough(choosenDough));

        }

    public void chooseToppings() throws IllegalArgumentException{

        Toppings.Ingredients[] ingredients = Toppings.Ingredients.values();

        System.out.println("Available ingredients/topics:");

        IntStream.range(0, ingredients.length)
                .forEach(i -> System.out.println(i+1 + " " + ingredients[i]));

        System.out.println("Choose toppings (0 to finish):");
        while(true){
            int option = readOption(0, ingredients.length);
            if(option == 0) break;
            pizzaBuilder.setToppings(ingredients[option - 1]);
        }

    }

    private int readOption(int min, int max){
        int option;

        while (true) {
            System.out.print("Option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine();

            if (option >= min && option <= max) {
                return option;
            }

            System.out.println("Option out of range. Choose between " + min + " and " + max + ".");
        }
    }

    }


