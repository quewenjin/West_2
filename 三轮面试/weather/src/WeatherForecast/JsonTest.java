package WeatherForecast;

public class JsonTest {

    public static void main(String[]  args){
        String info = WeatherUtils.GetWeatherData("110101");
        System.out.println(info);
    }

}
