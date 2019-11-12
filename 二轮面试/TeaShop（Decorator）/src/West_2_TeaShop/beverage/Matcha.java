package West_2_TeaShop.beverage;

public class Matcha extends Ingredient{

    Ingredient ingredient;

    public Matcha(){
        name = "抹茶";
    }

    @Override
    public String getName() {
        return "抹茶";
    }

    @Override
    public Double cost() {
        return 15.0;
    }

    @Override
    public String toString() {
        return "Matcha{" +
                ", name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }
}
