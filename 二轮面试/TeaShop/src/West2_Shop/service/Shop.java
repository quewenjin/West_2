package West2_Shop.service;

import West2_Shop.ingredient.Ingredient;
import West2_Shop.exception.SoldOutException;

public interface Shop {

    public void AddGoods(Ingredient ingredient);

    public void SellGoods(String name) throws SoldOutException;

}