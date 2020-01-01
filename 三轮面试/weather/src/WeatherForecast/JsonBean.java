package WeatherForecast;

import java.util.List;

/**
 * 对应数据库更新功能
 */

public class JsonBean {

    private String status;
    private String count;
    private String info;
    private String infocode;

    private List<CastsBean> casts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }


    public static class CastsBean{
        private String city;//城市名
        private String date;//日期
        private String week;//星期
        private String dayWeather;//白天天气
        private String dayTemp;//白天温度
        private String dayWind;//白天风向
        private String dayPower;//白天风力
        private String nightWeather;//晚上天气
        private String nightTemp;//晚上温度
        private String nightWind;//晚上风向
        private String nightPower;//晚上风力

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getDayWeather() {
            return dayWeather;
        }

        public void setDayWeather(String dayWeather) {
            this.dayWeather = dayWeather;
        }

        public String getDayTemp() {
            return dayTemp;
        }

        public void setDayTemp(String dayTemp) {
            this.dayTemp = dayTemp;
        }

        public String getDayWind() {
            return dayWind;
        }

        public void setDayWind(String dayWind) {
            this.dayWind = dayWind;
        }

        public String getDayPower() {
            return dayPower;
        }

        public void setDayPower(String dayPower) {
            this.dayPower = dayPower;
        }

        public String getNightWeather() {
            return nightWeather;
        }

        public void setNightWeather(String nightWeather) {
            this.nightWeather = nightWeather;
        }

        public String getNightTemp() {
            return nightTemp;
        }

        public void setNightTemp(String nightTemp) {
            this.nightTemp = nightTemp;
        }

        public String getNightWind() {
            return nightWind;
        }

        public void setNightWind(String nightWind) {
            this.nightWind = nightWind;
        }

        public String getNightPower() {
            return nightPower;
        }

        public void setNightPower(String nightPower) {
            this.nightPower = nightPower;
        }
    }

}
