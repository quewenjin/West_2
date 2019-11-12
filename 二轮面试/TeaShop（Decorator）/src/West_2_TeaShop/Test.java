package West_2_TeaShop;

import West_2_TeaShop.beverage.*;
import West_2_TeaShop.exception.SoldOutException;
import West_2_TeaShop.service.impl.AddOrSellGoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) throws SoldOutException {

        //创建珍珠和椰果
        Bubble bubble1 = new Bubble();
        bubble1.setName("珍珠1");
        bubble1.setGuaranteeDay();
        bubble1.setProduceDate("2018-12-06");
        bubble1.setGuaranteeDate();

        Bubble bubble2 = new Bubble();
        bubble2.setName("珍珠2");
        bubble2.setGuaranteeDay();
        bubble2.setProduceDate("2019-12-06");
        bubble2.setGuaranteeDate();

        Coconut coconut1 = new Coconut();
        coconut1.setName("椰果1");
        coconut1.setGuaranteeDay();
        coconut1.setProduceDate("2018-12-06");
        coconut1.setGuaranteeDate();

        Coconut coconut2 = new Coconut();
        coconut2.setName("椰果2");
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
        System.out.println("--------------------------这一家奶茶店--------------------------");
        System.out.println(" 欢迎光临,本奶茶店刚刚开张，只有三种饮品，两种配料，请见谅，具体如下：");
        System.out.println("饮品：       奶茶--10.0￥        抹茶--15.0￥        可可--20.0￥");
        System.out.println("配料：       椰果--2.0￥         珍珠--3.0￥                    ");

        Scanner sc = new Scanner(System.in);
        String name1 = "";
        String name2 = "";

        //交易
        int flag = 0;
        float sum = 0;
        while(true) {
            System.out.println("请选择操作：购买纯饮品请输入1，购买添加配料的饮品请输入2，离开请输入0");
            flag = sc.nextInt();

            if(flag == 1) {
                Scanner buy = new Scanner(System.in);
                System.out.println("请输入饮品的名称：");
                name1 = buy.nextLine();

                if (name1.equals("奶茶")) {
                    Ingredient milkTea = new MilkTea();
                    System.out.println(milkTea.getName() + " 调制完成,价格为 " + milkTea.cost() + " 元 ，请选择下一步操作");
                } else if (name1.equals("抹茶")) {
                    Ingredient matcha = new Matcha();
                    System.out.println(matcha.getName() + " 调制完成,价格为 " + matcha.cost() + " 元 ，请选择下一步操作");
                } else if (name1.equals("可可")) {
                    Ingredient cocoa = new Cocoa();
                    System.out.println(cocoa.getName() + " 调制完成,价格为 " + cocoa.cost() + " 元 ，请选择下一步操作");
                } else {
                    System.out.println("本店没有这样的饮品，再看看菜单吧");
                }

            } else if (flag == 2) {

                Scanner buyName = new Scanner(System.in);
                System.out.println("请输入配料的名称：");
                name2 = buyName.nextLine();
                try {

                    if (name2.equals("椰果")) {

                        Scanner buy = new Scanner(System.in);
                        System.out.println("请输入饮品的名称：");
                        name1 = buy.nextLine();

                        addOrSell.SellGoods(name2);

                        if (name1.equals("奶茶")) {
                            Ingredient milkTea = new MilkTea();
                            milkTea = new Coconut(milkTea);
                            System.out.println(milkTea.getName() + " 调制完成,价格为 " + milkTea.cost() + " 元 ，请选择下一步操作");
                        } else if (name1.equals("抹茶")) {
                            Ingredient matcha = new Matcha();
                            matcha = new Coconut(matcha);
                            System.out.println(matcha.getName() + " 调制完成,价格为 " + matcha.cost() + " 元 ，请选择下一步操作");
                        } else if (name1.equals("可可")) {
                            Ingredient cocoa = new Cocoa();
                            cocoa = new Coconut(cocoa);
                            System.out.println(cocoa.getName() + " 调制完成,价格为 " + cocoa.cost() + " 元 ，请选择下一步操作");
                        } else {
                            System.out.println("本店没有这样的饮品，再看看菜单吧");
                        }

                    } else if (name2.equals("珍珠")) {

                        Scanner buy = new Scanner(System.in);
                        System.out.println("请输入饮品的名称：");
                        name1 = buy.nextLine();

                        addOrSell.SellGoods(name2);

                        if (name1.equals("奶茶")) {
                            Ingredient milkTea = new MilkTea();
                            milkTea = new Bubble(milkTea);
                            System.out.println(milkTea.getName() + " 调制完成,价格为 " + milkTea.cost() + " 元 ，请选择下一步操作");
                        } else if (name1.equals("抹茶")) {
                            Ingredient matcha = new Matcha();
                            matcha = new Bubble(matcha);
                            System.out.println(matcha.getName() + " 调制完成,价格为 " + matcha.cost() + " 元 ，请选择下一步操作");
                        } else if (name1.equals("可可")) {
                            Ingredient cocoa = new Cocoa();
                            cocoa = new Bubble(cocoa);
                            System.out.println(cocoa.getName() + " 调制完成,价格为 " + cocoa.cost() + " 元 ，请选择下一步操作");
                        } else {
                            System.out.println("本店没有这样的饮品，再看看菜单吧");
                        }

                    }
                    else {
                        System.out.println("本店没有这样的配料，再看看菜单吧");
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
            } else if(flag == 0) {

                System.out.println("感谢您的惠顾，欢迎下次再来");
                break;

            } else {

                System.out.println("输入有误，请重新输入");
                continue;

            }
        }

    }
}
