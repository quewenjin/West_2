package West_2_TeaShop.beverage;

public class MilkTea extends Ingredient {

    public MilkTea(){
        name = "奶茶";
    }

    @Override
    public String getName() {
        return "奶茶";
    }

    @Override
    public Double cost() {
        return 10.0;
    }

    @Override
    public String toString() {
        return "MilkTea{" +
                ", name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }
}
