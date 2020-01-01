package WeatherForecast;

import java.sql.SQLException;
import java.util.Scanner;

import static WeatherForecast.QueryUtils.BaseIputil;
import static WeatherForecast.ForecastsTest.Forecast;

public class Test {

    public static void main(String[] args) throws SQLException {

        System.out.println("功能介绍：");
        System.out.println("输入1：查询城市天气");
        System.out.println("输入2：更新全国各省的省会及各个直辖市的4天的天气预报的数据至数据库");
        System.out.println("输入3：退出");
        System.out.println("注意：");
        System.out.println("① 若查询天气未出现对应信息则查询失败请重新输入正确的城市名；② 查询功能可能会输出重名的城市.");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("请输入相应数字选择功能：");
            int flag1 = sc.nextInt();
            System.out.println("");
            if(flag1 == 1) {
                System.out.print("请输入城市名：");
                Scanner sca = new Scanner(System.in);
                String name = sca.nextLine();
                BaseIputil(name);
                System.out.println(" ");
            } else if(flag1 == 2) {
                Forecast();
                System.out.println("更新成功，请打开数据库进行查看");
                System.out.println(" ");
            } else if(flag1 == 3) {
                System.out.println("谢谢使用！");
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
    }

}
