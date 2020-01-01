package WeatherForecast;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static WeatherForecast.QueryUtils.GetLives;

/**
 * 查询思路：
 * 因为有部分地区的名字相同, 所以得先把所有的城市与编码导入数据库,
 * 然后查询数据库与输入的城市名相匹配的编码, 如有重复城市, 那么使用List集合来保存编码,
 * 然后再进行api调用数据, 把所有重复的城市天气都查询显示出来, 查询的时候要按照city、province进行排序；
 *
 * 但是写到一半发现 city 参数可以是城市名，
 * 可以直接发送城市名得到所有城市，包括所有重名的，
 * 所以这些先放这个 class 里面。
 */

public class Something {

    /**
     * 读取从网页下载的文件 AMap_adcode_citycode.xlsx （已改为 adcode.xlsx）
     * 存入数据库
     */
    public void read() throws SQLException {
        File file = new File("C:\\Users\\quewenjin\\Desktop\\adcode.xlsx");
        InputStream inputStream = null;
        Workbook workbook = null;

        WeatherForecast.Conn c = new WeatherForecast.Conn(); // 连接数据库
        Connection con = c.getConn();
        Statement sql = con.createStatement();

        try {
            inputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheet = workbook.getSheetAt(0);
            //总行数
            int rowLength = sheet.getLastRowNum()+1;
            //工作表的列
            Row row = sheet.getRow(0);
            //总列数
            int colLength = row.getLastCellNum();
            //得到指定的单元格
            Cell cell = row.getCell(0);
            //得到单元格样式
            CellStyle cellStyle = cell.getCellStyle();
            //System.out.println("行数：" + rowLength + ",列数：" + colLength);

            int a;
            String x = null, y = null;

            for (int i = 0; i < rowLength; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < colLength; j++) {
                    cell = row.getCell(j);

                    //将所有的需要读的Cell表格设置为String格式
                    if (cell != null) {
                        cell.setCellType(1);
                    }

                    if (i > 0 && j == 0){
                        x = cell.getStringCellValue();
                        //System.out.print(cell.getStringCellValue() + "\t");
                    }

                    if (i > 0 && j == 1){
                        y = cell.getStringCellValue();
                        //System.out.print(cell.getStringCellValue() + "\t");
                    }

                }

                a = sql.executeUpdate("insert into adcode (cityname, adcode) "
                        + "values('"
                        + x
                        + "','"
                        + y
                        +"')");
                //System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // res.close();
            sql.close();
            con.close();
        }
    }

    /**
     * 输入城市名
     * 对数据库进行查询
     * @return
     */
    public static BaseBean getLives(String cityname) {
        BaseBean city = null;
        try {
            WeatherForecast.Conn c = new WeatherForecast.Conn(); // 连接数据库
            Connection con = c.getConn();
            Statement sql = con.createStatement();

            ResultSet resultSet = sql.executeQuery("select * from adcode where cityname = '" + cityname + "'");

            if(resultSet.next()) {
                city = new BaseBean();
                city.setCityname(resultSet.getString("cityname"));
                city.setAdcode(resultSet.getString("adcode"));

                //System.out.println(city.getCityname());
                //System.out.println(city.getAdcode());
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return city;
    }

    public static void main(String[] args) throws SQLException {
        new Something().read();
        try{
            BaseBean info = null;
            info = getLives("永定区");

            System.out.println(info.getCityname());
            System.out.println(info.getAdcode());

            String infoJson = GetLives(info.getCityname());
            System.out.println(infoJson);

        } catch (NullPointerException e) {
            System.out.println("抱歉，未查询到该城市，请确保城市名正确");
        }
    }

}
