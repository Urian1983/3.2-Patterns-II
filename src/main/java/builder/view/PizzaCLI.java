package builder.view;

import builder.model.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class PizzaCLI {

    private final PizzaMaster luigi = new PizzaMaster(new PizzaBuilder());

    public void run(Scanner scanner) {
        int option = displayMenuAndReadOption(scanner);
        Pizza pizza = readComponentsandBuild(scanner, option);
        printResult(pizza);
    }

    private String pizzaMenu() {
        return "Choose the type of Pizza that you want to eat:\n" +
                "1. Vegetarian\n" +
                "2. Hawaiian\n" +
                "3. Customized Pizza\n" +
                "Type a number to choose:";
    }

    private int displayMenuAndReadOption (Scanner scanner) {
        System.out.println("Welcome to our Pizza Restaurant");
        System.out.println(pizzaMenu());

        int option = 0;

        while (option < 1 || option > 3) {
            try {
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    throw new IllegalArgumentException();
                }
                if (option < 1 || option > 3) {
                    System.out.println("Choose an available option (1, 2 or 3)");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid type of input. Please enter a number");
                option = 0;
            }
        }
            return option;
        }

    private Pizza readComponentsandBuild (Scanner scanner, int option){
        Size size =chooseSize(scanner);
        Dough dough = chooseDough(scanner);

        switch (option){
            case 1:
                return buildVegetarianPizza(size,dough);
            case 2:
                return buildHawaiianPizza(size,dough);
            case 3:
                return buildCustomPizza(size, dough, scanner);
            default:
                System.out.println("Unexpected error during Pizza selection");
            return null;
        }
    }

    private void printResult(Pizza pizza){
        if (pizza != null) {

            System.out.println("\n--- Your order ---");
            System.out.println(pizza.toString());
            System.out.println("--------------------");
        }
        else{
            System.out.println("Error: Pizza could not be built");
        }
    }

    private Pizza buildVegetarianPizza(Size size, Dough dough) {
        PizzaBuilder builder = new PizzaBuilder();

        return builder.setSize(size)
                .setDough(dough)
                .addTopping(Ingredients.MOZZARELLA_CHEESE)
                .addTopping(Ingredients.BELL_PEPPER)
                .addTopping(Ingredients.MUSHROOM)
                .addTopping(Ingredients.ONION)
                .addTopping(Ingredients.BLACK_OLIVES)
                .addTopping(Ingredients.TOMATO)
                .getPizza();
    }

    private Pizza buildCustomPizza(Size size, Dough dough, Scanner scanner){

        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        pizzaBuilder.setSize(size)
                .setDough(dough);

        System.out.println("\n--- Build your custom pizza ---");
        System.out.println("Available ingredients:");

        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(Ingredients.values())
                .forEach(ingredient -> System.out.println(i.getAndIncrement() + " " + ingredient));

        System.out.println("\nEnter ingredient numbers separated by commas (e.g., 1,5,8) or 0 to skip");


        scanner.nextLine();
        String input = scanner.nextLine().trim();

        if(!input.equals("0")){
            String[] choices = input.split(",");
            for (String choice: choices){
                try{
                    int option = Integer.parseInt(choice.trim());
                    if (option >= 1 && option <= Ingredients.values().length){
                        pizzaBuilder.addTopping(Ingredients.values()[option-1]);
                    }
                    else{
                        System.out.println("Invalidad option: " + option);
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid input: " +choice);
                }
            }
        }

        return pizzaBuilder.getPizza();

    }

    private Pizza buildHawaiianPizza(Size size, Dough dough) {
        PizzaBuilder builder = new PizzaBuilder();

        return builder.setSize(size)
                .setDough(dough)
                .addTopping(Ingredients.MOZZARELLA_CHEESE)
                .addTopping(Ingredients.HAM)
                .addTopping(Ingredients.PINEAPPLE)
                .getPizza();
    }

    private Size chooseSize(Scanner scanner) {
        System.out.println("Choose the size of your Pizza: ");
        AtomicInteger i = new AtomicInteger(1);
        Arrays.stream(Size.values()).forEach(size -> System.out.println(i.getAndIncrement() + "." + size));
        Size size = null;
        while (size == null) {
            System.out.println("Type the option number");
            int option = scanner.nextInt();
            if (option >= 1 && option <= Size.values().length) {
                size = Size.values()[option - 1];
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
        return size;
    }

    private Dough chooseDough(Scanner scanner) {
        System.out.println("Choose the dough of your Pizza: ");
        AtomicInteger i = new AtomicInteger(1);
        int option;
        Arrays.stream(Dough.values()).forEach(dough -> System.out.println(i.getAndIncrement() + "." + dough));
        Dough dough = null;
        while (dough == null) {
            System.out.println("Type the option number");
            option = scanner.nextInt();
            if (option >= 1 && option <= Dough.values().length) {
                dough = Dough.values()[option - 1];
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
        return dough;
    }

}