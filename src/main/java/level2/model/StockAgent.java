package level2.model;

import java.util.ArrayList;
import java.util.List;

public class StockAgent {
    private List<Observer> observers = new ArrayList<>();
    private double stockValue;
    private String name;

    public StockAgent(String name) {
        this.name = name;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    public void notifyObservers() {
        observers.forEach(o->o.updateStock(stockValue));

    }

    public void printObservers(){
        observers.forEach(o->System.out.println(o.getName()));
    }

    public void updateStock(double stockValue) {
        this.stockValue = stockValue;
        notifyObservers();
    }

}
