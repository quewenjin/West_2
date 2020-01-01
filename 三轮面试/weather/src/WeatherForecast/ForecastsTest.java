package WeatherForecast;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static WeatherForecast.WeatherUtils.CastIputil;

public class ForecastsTest {

    //public static void main(String[] args) throws SQLException {
    public static void Forecast() throws SQLException {

        //清空数据库
        WeatherForecast.Conn c = new WeatherForecast.Conn(); // 连接数据库
        Connection con = c.getConn();
        String sql="delete from forecast where week > 0";//生成一条sql语句
        Statement stmt=con.createStatement();//创建Statement对象
        stmt.executeUpdate(sql);//执行sql语句
        con.close();

        //更新数据库
        ArrayList<String> cityArray = new ArrayList<String> ();
        cityArray.add("110100");//北京市市辖区
        cityArray.add("120100");//天津市市辖区
        cityArray.add("130100");//河北省石家庄市
        cityArray.add("140100");//山西省太原市
        cityArray.add("150100");//内蒙古省呼和浩特市
        cityArray.add("210100");//辽宁省沈阳市
        cityArray.add("220100");//吉林省长春市
        cityArray.add("230100");//黑龙江省哈尔滨市
        cityArray.add("310100");//上海市市辖区
        cityArray.add("320100");//江苏省南京市
        cityArray.add("330100");//浙江省杭州市
        cityArray.add("340100");//安徽省合肥市
        cityArray.add("350100");//福建省福州市
        cityArray.add("360100");//江西省南昌市
        cityArray.add("370100");//山东省济南市
        cityArray.add("410100");//河南省郑州市
        cityArray.add("420100");//湖北省武汉市
        cityArray.add("430100");//湖南省长沙市
        cityArray.add("440100");//广东省广州市
        cityArray.add("450100");//广西省南宁市
        cityArray.add("460100");//海南省海口市
        cityArray.add("500100");//重庆市市辖区
        cityArray.add("510100");//四川省成都市
        cityArray.add("520100");//贵州省贵阳市
        cityArray.add("530100");//云南省昆明市
        cityArray.add("540100");//西藏省拉萨市
        cityArray.add("610100");//陕西省西安市
        cityArray.add("620100");//甘肃省兰州市
        cityArray.add("630100");//青海省西宁市
        cityArray.add("640100");//宁夏省银川市
        cityArray.add("650100");//新疆省乌鲁木齐市
        for(int i = 0; i < cityArray.size(); i++) {
            CastIputil(cityArray.get(i));
        }
        //System.out.println("全国各省的省会及各个直辖市的四天的预报天气已导入数据库！");
    }

}
