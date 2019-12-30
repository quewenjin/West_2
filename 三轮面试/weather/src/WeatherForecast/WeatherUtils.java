package WeatherForecast;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过get请求向网站https://restapi.amap.com/v3/weather/weatherInfo?
 * parameters获取某个城市的天气状况数据数据Json
 */

public class WeatherUtils {

    // city 为对应的编码 --> adcode
    public static String GetWeatherData(String city) {
        StringBuilder sb = new StringBuilder();
        ;
        try {
            // city = URLEncoder.encode(city, "UTF-8");

            String key = "b7fd282a4d3cf50a602171fcb19f554e";
            String weather_url = "https://restapi.amap.com/v3/weather/weatherInfo?parameters"
                    + "&key=" + key + "&city=" + city + "&extensions=" + "all";

            // 链接URL
            URL url = new URL(weather_url);
            // 创建链接  
            URLConnection conn = url.openConnection();
            // 读取返回结果集
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));

            String line = null;
            while ((line = reader.readLine()) != null)
                sb.append(line + " ");
            reader.close();

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String json = sb.toString();
        // System.out.println(json);
        return json;
    }

    public static void Iputil(String city) throws SQLException {
        WeatherForecast.JsonBean jsonBean = new WeatherForecast.JsonBean();

        // 得到 json 部分
        String urlString = GetWeatherData(city);

        JSONObject json = JSONObject.fromObject(urlString);
        jsonBean.setStatus(json.optString("status"));
        jsonBean.setCount(json.optString("count"));
        jsonBean.setInfo(json.optString("info"));
        jsonBean.setInfocode(json.optString("infocode"));
        // JSONArray json2=json.optJSONArray("forecasts").optJSONArray("casts");
        JSONArray forecastsArray = json.optJSONArray("forecasts");

        JSONObject casts = forecastsArray.getJSONObject(0);

        List<JsonBean.CastsBean> castsBeansList = new ArrayList<>();

        JSONArray castsArray = casts.optJSONArray("casts");

        for (int i = 0; i < castsArray.size(); i++) {
            JSONObject castsObj = castsArray.optJSONObject(i);
            JsonBean.CastsBean castsBean = new JsonBean.CastsBean();

            castsBean.setCity(casts.optString("city"));

            castsBean.setDate(castsObj.optString("date"));
            castsBean.setWeek(castsObj.optString("week"));
            castsBean.setDayWeather(castsObj.optString("dayweather"));
            castsBean.setNightWeather(castsObj.optString("nightweather"));
            castsBean.setDayTemp(castsObj.optString("daytemp"));
            castsBean.setNightTemp(castsObj.optString("nighttemp"));
            castsBean.setDayWind(castsObj.optString("daywind"));
            castsBean.setNightWind(castsObj.optString("nightwind"));
            castsBean.setDayPower(castsObj.optString("daypower"));
            castsBean.setNightPower(castsObj.optString("nightpower"));

            castsBeansList.add(castsBean);
        }
    //    System.out.println(castsBeansList);
        jsonBean.setCasts(castsBeansList);

        WeatherForecast.Conn c = new WeatherForecast.Conn(); // 连接数据库
        Connection con = c.getConn();
        Statement sql = con.createStatement();
        // ResultSet res;
        try {

            int a;

            for (int i = 0; i < jsonBean.getCasts().size(); i++) {
                a = sql.executeUpdate("insert into forecast (city, date, week, dayweather, daytemp, daywind, daypower, nightweather, nighttemp, nightwind, nightpower) "
                        + "values('"
                        + jsonBean.getCasts().get(i).getCity()
                        + "','"
                        + jsonBean.getCasts().get(i).getDate()
                        + "','"
                        + jsonBean.getCasts().get(i).getWeek()
                        + "','"
                        + jsonBean.getCasts().get(i).getDayWeather()
                        + "','"
                        + jsonBean.getCasts().get(i).getDayTemp()
                        + "','"
                        + jsonBean.getCasts().get(i).getDayWind()
                        + "','"
                        + jsonBean.getCasts().get(i).getDayPower()
                        + "','"
                        + jsonBean.getCasts().get(i).getNightWeather()
                        + "','"
                        + jsonBean.getCasts().get(i).getNightTemp()
                        + "','"
                        + jsonBean.getCasts().get(i).getNightWind()
                        + "','"
                        + jsonBean.getCasts().get(i).getNightPower() + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // res.close();
            sql.close();
            con.close();
        }

    }

}
