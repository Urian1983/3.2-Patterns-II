package level2.view;

import level2.model.StockAgent;
import level2.model.StockTrader;

import java.util.Scanner;

public class StockView {

    private Scanner scanner = new Scanner(System.in);
    private StockAgent stockAgent = new StockAgent("Agent");

    public void run(){
        boolean exit = false;

        while(!exit){
            System.out.println("\n--- Stock System Menu ---");
            System.out.println("1. Add new trader");
            System.out.println("2. Set new stock value");
            System.out.println("3. Print all the StockAgents");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addTrader();
                    break;
                case 2:
                    updateStockValue();
                    break;
                case 3:
                    stockAgent.notifyObservers();
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        System.out.println("Exiting...");
    }

    public void addTrader(){
        System.out.println("Type the name of the new trader");
        String traderName = scanner.nextLine();

        StockTrader newTrader = new StockTrader(traderName);

        stockAgent.addObserver(newTrader);

        System.out.println(traderName + " added to the list of observers");
    }

    public void updateStockValue(){
        System.out.println("Enter the new stock value");
        double newStockValue = scanner.nextDouble();
        scanner.nextLine();

        stockAgent.updateStock(newStockValue);

        System.out.println("Stock value updated: " + newStockValue);
    }
}

