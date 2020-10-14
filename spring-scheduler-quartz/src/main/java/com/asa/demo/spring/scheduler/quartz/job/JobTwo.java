package com.asa.demo.spring.scheduler.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class JobTwo implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String data = jobDataMap.getString("somedata");
        System.out.println("Job Two fired with data: " + data);
    }
}
