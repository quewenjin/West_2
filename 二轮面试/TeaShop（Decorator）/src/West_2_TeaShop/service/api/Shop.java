package West_2_TeaShop.service.api;

import West_2_TeaShop.beverage.Ingredient;
import West_2_TeaShop.exception.SoldOutException;

public interface Shop {

    public void AddGoods(Ingredient ingredient);

    public void SellGoods(String name) throws SoldOutException;

}
