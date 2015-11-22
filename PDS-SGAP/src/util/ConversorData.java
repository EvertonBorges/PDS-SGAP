/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Borges
 */
public class ConversorData {
    
    public static Date convertToDate (String data) throws ParseException{
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.parse(data);
    }
    
    public static Calendar convertToCalendar (String data) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertToDate(data));
        return calendar;
    }
    
    public static String convertToString (Date date) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(date);
    }
}