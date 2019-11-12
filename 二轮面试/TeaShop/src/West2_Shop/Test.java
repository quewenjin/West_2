package West2_Shop;

import West2_Shop.exception.SoldOutException;
import West2_Shop.ingredient.Bubble;
import West2_Shop.ingredient.Coconut;
import West2_Shop.ingredient.MilkTea;
import West2_Shop.service.AddOrSellGoods;

import java.util.Scanner;


public class Test {

    public static void main(String args[]) throws SoldOutException {

        //创建珍珠和椰果
        Bubble bubble1 = new Bubble();
        bubble1.setName("珍珠");
        bubble1.setGuaranteeDay();
        bubble1.setProduceDate("2018-12-06");
        bubble1.setGuaranteeDate();

        Bubble bubble2 = new Bubble();
        bubble2.setName("珍珠");
        bubble2.setGuaranteeDay();
        bubble2.setProduceDate("2019-12-06");
        bubble2.setGuaranteeDate();

        Coconut coconut1 = new Coconut();
        coconut1.setName("椰果");
        coconut1.setGuaranteeDay();
        coconut1.setProduceDate("2018-12-06");
        coconut1.setGuaranteeDate();

        Coconut coconut2 = new Coconut();
        coconut2.setName("椰果");
        coconut2.setGuaranteeDay();
        coconut2.setProduceDate("2019-12-06");
        coconut2.setGuaranteeDate();

        AddOrSellGoods addOrSell = new AddOrSellGoods();

        //初始添加
        addOrSell.addBubble(bubble1);
        addOrSell.addBubble(bubble2);
        addOrSell.addCoconut(coconut1);
        addOrSell.addCoconut(coconut2);

        //开始
        System.out.println("----------------------------西二奶茶店--------------------------");
        System.out.println(" 欢迎光临,本奶茶店刚刚开张，仅有两种饮品和两种配料，请见谅，具体如下：");
        System.out.println(" 饮品：① 奶茶 ② 抹茶                           配料：① 椰果 ② 珍珠");
        System.out.println(" --------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        String name1 = "";
        String name2 = "";

        //交易
        int flag1 = 0;
        int flag2 = 0;
        while(true) {
            System.out.println("请选择操作：购买饮品请输入1，离开请输入0");
            flag1 = sc.nextInt();
            if(flag1 == 1) {
                Scanner buyname = new Scanner(System.in);

                System.out.println("请输入你想要购买的饮品的名字:");
                MilkTea milkTea = new MilkTea();

                name1 = buyname.nextLine();
                if(name1.equals("奶茶") || name1.equals("抹茶")){
                    milkTea.setName(name1);
                } else {
                    System.out.println("抱歉，本店没有该饮品");
                    continue;
                }

                System.out.println("请输入你想要添加的配料的名字:");

                name2 = buyname.nextLine();
                if (name2.equals("珍珠") || name2.equals("椰果")){
                    try {
                        addOrSell.SellGoods(name2);

                        if (name2.equals("珍珠")){
                            Bubble bubble = new Bubble();
                            milkTea.Fix(bubble);
                        }
                        if (name2.equals("椰果")){
                            Coconut coconut = new Coconut();
                            milkTea.Fix(coconut);
                        }
                    } catch (SoldOutException e) {
                        System.out.println("抱歉，该配料已售完，正在进货中");
                        if (name2.equals("珍珠")){
                            Bubble bubble = new Bubble();
                            addOrSell.AddGoods(bubble);
                        }
                        if (name2.equals("椰果")){
                            Coconut coconut = new Coconut();
                            addOrSell.AddGoods(coconut);
                        }
                        continue;
                    }
                } else {
                    System.out.println("抱歉，本店没有该配料");
                }
            } else if(flag1 == 0){
                System.out.println("欢迎下次光临");
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
                continue;

            }
        }

    }

}
