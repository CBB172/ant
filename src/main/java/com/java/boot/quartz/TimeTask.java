package com.java.boot.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 19:48
 * @Description: No Description
 */
@Component
public class TimeTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron="0 * * * * ?")
    public void test(){
        System.out.println("...定时任务...");
    }
    
    @Scheduled(fixedRate = 10000)
    public void nowTime() {
        System.out.println("现在时间是"+sdf.format(new Date()));
    }
}
