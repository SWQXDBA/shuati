package 学校作业.数据库;

import java.sql.Date;
import java.time.LocalDate;

public class Good {
    private Long number;
    private String name;
    private Date madeTime;
    private Double price;


    @Override
    public String toString() {
        return "Good{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", madeTime=" + madeTime +
                ", price=" + price +
                '}';
    }
}
