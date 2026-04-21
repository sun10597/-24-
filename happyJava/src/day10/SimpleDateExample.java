package day10;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class SimpleDateExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(1) + " " + (calendar.get(2)+1) +" " + calendar.get(3));
        System.out.println(calendar.get(Calendar.YEAR)+" " + (calendar.get(Calendar.MONTH)+1) + " " + calendar.get(Calendar.DAY_OF_MONTH));
    }
}
