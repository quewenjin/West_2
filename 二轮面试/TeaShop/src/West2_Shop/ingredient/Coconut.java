package West2_Shop.ingredient;

public class Coconut extends Ingredient {

    public Coconut(){
    }

    public void setGuaranteeDay() {
        this.guaranteeDay = 5;
    }

    @Override
    public String getName() {
        return "椰果";
    }

    @Override
    public String toString() {
        return "Coconut{" +
                "name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }
}
