package com.hhuc.wechat.x.test;

/**
 * @program: Wechat_1
 * @description:
 * @author: LYX
 * @create: 2019-02-22 20:02
 **/
import java.util.*;
import java.text.*;

public class DateDemo {
    public static void main(String args[]) {

        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));
    }
}
    UUID uuid = UUID.randomUUID();