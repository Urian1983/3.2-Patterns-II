package level2.model;

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
        System.out.println("The Updated Stock is: " + updatedStock);
    }
}
