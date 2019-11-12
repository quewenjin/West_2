package West_2_TeaShop.beverage;

public class Coconut extends CondimentDecorator {

    Ingredient ingredient;

    public Coconut(){
    }

    public Coconut(Ingredient ingredient1){
        this.ingredient = ingredient1;
        this.name = "椰果" + ingredient1.name;
        this.guaranteeDate = ingredient1.guaranteeDate;
        this.produceDate = ingredient1.produceDate;
        this.guaranteeDay = ingredient1.guaranteeDay;
    }

    public void setGuaranteeDay() {
        this.guaranteeDay = 5;
    }

    @Override
    public String toString() {
        return "Coconut{" +
                "ingredient=" + ingredient +
                "name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }

    @Override
    public Double cost() {
        return ingredient.cost() + 2.0;
    }

    @Override
    public String getName() {
        return name;
    }
}
