package level2.model;

import java.util.Objects;

public class StockTrader implements Observer{
    private String name;

    public StockTrader(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateStock(double updatedStock){
        System.out.println("  → " + name + " notified! Stock value: $" + updatedStock);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        StockTrader that = (StockTrader) object;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
