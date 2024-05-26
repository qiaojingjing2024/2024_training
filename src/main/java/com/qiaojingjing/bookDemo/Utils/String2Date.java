package com.qiaojingjing.bookDemo.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class String2Date {
    public static LocalDateTime string2Date(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeStr, dateTimeFormatter);

    }
}
