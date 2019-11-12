package West_2_TeaShop.beverage;

public class Cocoa extends Ingredient{

    Ingredient ingredient;

    public Cocoa(){
        name = "可可";
    }

    @Override
    public String getName() {
        return "可可";
    }

    @Override
    public Double cost() {
        return 20.0;
    }

    @Override
    public String toString() {
        return "Cocoa{" +
                "ingredient=" + ingredient +
                ", name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }
}
