package observer.view;

import observer.model.StockAgent;
import observer.model.StockTrader;

import java.util.Scanner;

public class StockView {

    private Scanner scanner = new Scanner(System.in);
    private StockAgent stockAgent = new StockAgent("Agent");

    public void run(){
        boolean exit = false;

        while(!exit){
            System.out.println("\n--- Stock System Menu ---");
            System.out.println("1. Add new trader");
            System.out.println("2. Remove existing trader");
            System.out.println("3. Set new stock value");
            System.out.println("4. Print all the current traders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addTrader();
                    break;
                case 2:
                    removeTrader();
                    break;
                case 3:
                    updateStockValue();
                    break;
                case 4:
                    stockAgent.printObservers();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        System.out.println("Exiting...");
    }

    public void removeTrader(){
        System.out.println("Type the name of the trader to remove");
        String traderName= scanner.nextLine();

        StockTrader traderToRemove = new StockTrader(traderName);

        stockAgent.removeObserver(traderToRemove);
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

