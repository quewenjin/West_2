package West_2_TeaShop.beverage;

public class Bubble extends CondimentDecorator {

    Ingredient ingredient;

    public Bubble(Ingredient ingredient2){
        this.ingredient = ingredient2;
        this.name = "珍珠" + ingredient2.name;
        this.guaranteeDate = ingredient2.guaranteeDate;
        this.produceDate = ingredient2.produceDate;
        this.guaranteeDay = ingredient2.guaranteeDay;
    }

    public Bubble() {

    }

    public void setGuaranteeDay() {
        this.guaranteeDay = 7;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }

    @Override
    public Double cost() {
        return ingredient.cost() + 3.0;
    }

    @Override
    public String getName() {
        return name;
    }
}
