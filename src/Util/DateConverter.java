package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DateConverter {
    public static Vector<String> convertDateFormat(Vector<String> dates, String inputFormat, String outputFormat) {
        Vector<String> convertedDates = new Vector<>();
        
        DateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
        DateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
        
        for (String date : dates) {
            try {
                Date inputDate = inputDateFormat.parse(date);
                String convertedDate = outputDateFormat.format(inputDate);
                convertedDates.add(convertedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        return convertedDates;
    }
    public static String convertDateFormat(String date, String inputFormat, String outputFormat) {
        
        DateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
        DateFormat outputDateFormat = new SimpleDateFormat(outputFormat);        
        try {
            Date inputDate = inputDateFormat.parse(date);
            String convertedDate = outputDateFormat.format(inputDate);
            return convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }        
        return date;
    }
}

