package com.java.boot.quartz;

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

    @Scheduled(cron="0 * * * * ?")
    public void test(){
        System.out.println("...定时任务...");
    }
}
