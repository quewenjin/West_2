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
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    /**
     * 通过get请求向网站https://restapi.amap.com/v3/weather/weatherInfo?parameters
     * 获取某个城市的当前天气数据 Json
     */
    // city 为对应的城市名 --> cityname
    public static String GetLives(String city) {
        StringBuilder sb = new StringBuilder();
        try {
            // city = URLEncoder.encode(city, "UTF-8");

            String key = "b7fd282a4d3cf50a602171fcb19f554e";
            String weather_url = "https://restapi.amap.com/v3/weather/weatherInfo?parameters"
                    + "&key=" + key + "&city=" + city + "&extensions=" + "base";

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


    /**
     * 得到 Json 后进行处理
     * 存入数据库
     */
    public static void BaseIputil(String city){
        WeatherForecast.BaseBean baseBean = new WeatherForecast.BaseBean();

        // 得到 json 部分
        String urlString = GetLives(city);

        JSONObject json = JSONObject.fromObject(urlString);
        baseBean.setStatus(json.optString("status"));
        baseBean.setCount(json.optString("count"));
        baseBean.setInfo(json.optString("info"));
        baseBean.setInfocode(json.optString("infocode"));

        List<BaseBean.LivesBean> livesBeansList = new ArrayList<>();

        JSONArray livesArray = json.optJSONArray("lives");

        for (int i = 0; i < livesArray.size(); i++) {
            JSONObject livesObj = livesArray.optJSONObject(i);
            BaseBean.LivesBean livesBean = new BaseBean.LivesBean();

            livesBean.setProvince(livesObj.optString("province"));
            livesBean.setTheCity(livesObj.optString("city"));
            livesBean.setTheAdcode(livesObj.optString("adcode"));
            livesBean.setWeather(livesObj.optString("weather"));
            livesBean.setTemperature(livesObj.optString("temperature"));
            livesBean.setWinddirection(livesObj.optString("winddirection"));
            livesBean.setWindpower(livesObj.optString("windpower"));
            livesBean.setHumidity(livesObj.optString("humidity"));
            livesBean.setReporttime(livesObj.optString("reporttime"));

            livesBeansList.add(livesBean);
        }
        //    System.out.println(castsBeansList);
        baseBean.setLives(livesBeansList);

        for (int i = 0; i < baseBean.getLives().size(); i++) {
               System.out.println(""
                       + "省份名:"
                       + baseBean.getLives().get(i).getProvince()
                       + "   城市名:"
                       + baseBean.getLives().get(i).getTheCity()
                       + "   区域编码:"
                       + baseBean.getLives().get(i).getTheAdcode()
                       + "   天气现象:"
                       + baseBean.getLives().get(i).getWeather()
                       + "   实时气温:"
                       + baseBean.getLives().get(i).getTemperature()
                       + "℃   风向描述:"
                       + baseBean.getLives().get(i).getWinddirection()
                       + "   风力级别:"
                       + baseBean.getLives().get(i).getWindpower()
                       + "级   空气湿度:"
                       + baseBean.getLives().get(i).getHumidity()
                       + "   数据发布的时间:"
                       + baseBean.getLives().get(i).getReporttime());
        }

    }



}
