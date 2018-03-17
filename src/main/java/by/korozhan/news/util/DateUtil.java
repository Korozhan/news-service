package by.korozhan.news.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Veronika Korozhan March 11, 2018.
 */
public class DateUtil {
    public static final String FORMAT_DMY_UNDERLINE = "dd-MM-yyyy";

    public static Date stringToDate(String dateInString, String datePattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
        return formatter.parse(dateInString);
    }

    public static Object dateToString(Date date, String datePattern) {
        return new SimpleDateFormat(datePattern).format(date);
    }
}
