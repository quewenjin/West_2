package West2_Shop.ingredient;

public class MilkTea {

    Ingredient ingredient;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *     为了体现多态
     * @param ingredient
     */
    public void Fix(Ingredient ingredient){
        System.out.println(getName() + "调制完成，配料为" + ingredient.getName() + ",请选择下一步操作");
    }

    @Override
    public String toString() {
        return "MilkTea{" +
                "name='" + name + '\'' +
                '}';
    }
}
