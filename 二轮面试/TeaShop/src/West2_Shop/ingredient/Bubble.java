package West2_Shop.ingredient;

public class Bubble extends Ingredient {

    public Bubble() {
    }

    public void setGuaranteeDay() {
        this.guaranteeDay = 7;
    }

    @Override
    public String getName() {
        return "珍珠";
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

}
