/**
 * @author: asx
 * @date: 2023/6/1
 * @descrition:
 */
package com.asa.demo.spring.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CronScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(FixRateScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 15 10 15 * ?")
    public void reportCurrentTime() {
        long now = System.currentTimeMillis() / 1000;
        log.info("schedule tasks using cron jobs - " + now);
    }
}
