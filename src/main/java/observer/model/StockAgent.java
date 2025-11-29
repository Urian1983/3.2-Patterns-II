package observer.model;

import java.util.ArrayList;
import java.util.List;

public class StockAgent {
    private List<Trader> traders = new ArrayList<>();
    private double stockValue;
    private String name;

    public StockAgent(String name) {
        this.name = name;
    }

    public void addObserver(Trader trader) {
        traders.add(trader);


    }

    public void removeObserver(Trader trader) {
        traders.remove(trader);

    }

    public void notifyObservers() {
        traders.forEach(o->o.updateStock(stockValue));

    }

    public void printObservers(){
        traders.forEach(o->System.out.println(o.getName()));
    }

    public void updateStock(double stockValue) {
        this.stockValue = stockValue;
        notifyObservers();
    }

}
