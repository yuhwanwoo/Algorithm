package test.tren;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class exam02 {
    public static void main(String[] args) throws ParseException {
        String p = "PM 01:00:00";
        int n = 10;

        solution(p, n);
    }

    public static String solution(String p, int n) throws ParseException {
        String answer = "";
        SimpleDateFormat origin = new SimpleDateFormat("a hh:mm:ss", Locale.US);
        DateFormat new_format = new SimpleDateFormat("HH:mm:ss");

        Date from = origin.parse(p);
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);

        cal.add(Calendar.SECOND, n);
        answer = new_format.format(cal.getTime());

        return answer;
    }
}
