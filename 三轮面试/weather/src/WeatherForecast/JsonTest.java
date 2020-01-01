package WeatherForecast;

public class JsonTest {

    public static void main(String[]  args){

        String info1 = WeatherUtils.GetWeatherData("350803");
        System.out.println(info1);

        String info2 = QueryUtils.GetLives("永定区");
        System.out.println(info2);
    }

}
