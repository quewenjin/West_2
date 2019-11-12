package West_2_TeaShop.beverage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Ingredient {

    protected String name;
    protected int guaranteeDay;
    protected String guaranteeDate;
    protected String produceDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuaranteeDay() {
        return guaranteeDay;
    }

    public void setGuaranteeDay(int guaranteeDay) {
        this.guaranteeDay = guaranteeDay;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setGuaranteeDate() {
        this.guaranteeDate = getAfterDay(this.produceDate,this.guaranteeDay);
    }

    //返回得到过期的日期
    String getAfterDay(String startDay, int count) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(startDay);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.DATE, count);
            return sdf.format(cl.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    //花费
    public abstract Double cost();

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", guaranteeDay=" + guaranteeDay +
                ", guaranteeDate='" + guaranteeDate + '\'' +
                ", produceDate='" + produceDate + '\'' +
                '}';
    }
}
