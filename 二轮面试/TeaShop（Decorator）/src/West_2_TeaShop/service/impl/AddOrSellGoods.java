package West_2_TeaShop.service.impl;

import West_2_TeaShop.beverage.Bubble;
import West_2_TeaShop.beverage.Coconut;
import West_2_TeaShop.beverage.Ingredient;
import West_2_TeaShop.exception.SoldOutException;
import West_2_TeaShop.service.api.Shop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddOrSellGoods implements Shop {

    private static List<Bubble> BubbleList = new ArrayList<Bubble>();
    private static List<Coconut> CoconutList = new ArrayList<Coconut>();

    //获取当前的日期
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String nowDate = sdf.format(date);

    //添加配料
    @Override
    public void AddGoods(Ingredient ingredient) {
        if (ingredient instanceof Bubble){
            Bubble ingredientB = (Bubble)ingredient;
            this.getIngredient(ingredientB);
        } else if (ingredient instanceof Coconut){
            Coconut ingredientC = (Coconut)ingredient;
            this.getIngredient(ingredientC);
        }
    }

    //交易
    @Override
    public void SellGoods(String name) throws SoldOutException {

        int flagB = 1;
        int flagC = 1;

        //卖出珍珠
        if (name.equals("珍珠")){
            int i = BubbleList.size() - 1;
            //缺货
            if(BubbleList.size() == 0){
                flagB = 0;
            }
            //过期
            if(BubbleList.size() > 0 && nowDate.compareTo(BubbleList.get(i).getGuaranteeDate()) > 0) {
                System.out.println("当前日期：" + nowDate + " ======= 过期日期" + BubbleList.get(i).getGuaranteeDate());
                BubbleList.remove(i);
            }
            //卖出
            if(BubbleList.size() > 0 && nowDate.compareTo(BubbleList.get(i).getGuaranteeDate()) <= 0) {
                System.out.println("当前日期：" + nowDate + " ======= 过期日期" + BubbleList.get(i).getGuaranteeDate());
                //flagB = 1;
                BubbleList.remove(i);
            }
        }

        //卖出椰果
        if (name.equals("椰果")){
            int i = CoconutList.size() - 1;
            //缺货
            if(CoconutList.size() == 0){
                flagC = 0;
            }
            //过期
            if(CoconutList.size() > 0 && nowDate.compareTo(CoconutList.get(i).getGuaranteeDate()) > 0) {
                System.out.println("当前日期：" + nowDate + " ======= 过期日期" + CoconutList.get(i).getGuaranteeDate());
                CoconutList.remove(i);
            }
            //卖出
            if(CoconutList.size() > 0 && nowDate.compareTo(CoconutList.get(i).getGuaranteeDate()) <= 0) {
                System.out.println("当前日期：" + nowDate + " ======= 过期日期" + CoconutList.get(i).getGuaranteeDate());
                //flagC = 1;
                CoconutList.remove(i);
            }
        }

        //异常
        if(flagB == 0 || flagC == 0) {
            throw new SoldOutException();
        }

    }

    //初始添加珍珠
    public void addBubble(Bubble bubble){
        BubbleList.add(bubble);
    }

    //初始添加椰果
    public void addCoconut(Coconut coconut){
        CoconutList.add(coconut);
    }

    //思考后我决定一次只进三份

    //进货添加珍珠
    private void getIngredient(Bubble bubble){

        if (BubbleList.size() == 0 || BubbleList == null ){
            for (int i = 0; i < 3; i++) {
                BubbleList.add(bubble);
                BubbleList.get(i).setName("珍珠");
                BubbleList.get(i).setGuaranteeDay();
                BubbleList.get(i).setProduceDate(nowDate);
                BubbleList.get(i).setGuaranteeDate();
            }
        }

    }

    //进货添加椰果
    private void getIngredient(Coconut coconut){

        if (CoconutList.size() == 0 || CoconutList == null ){
            for (int i = 0; i < 3; i++) {
                CoconutList.add(coconut);
                BubbleList.get(i).setName("椰果");
                CoconutList.get(i).setGuaranteeDay();
                CoconutList.get(i).setProduceDate(nowDate);
                CoconutList.get(i).setGuaranteeDate();
            }
        }

    }

}
