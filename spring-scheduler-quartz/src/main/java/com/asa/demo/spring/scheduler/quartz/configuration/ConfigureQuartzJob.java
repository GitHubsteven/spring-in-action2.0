package com.asa.demo.spring.scheduler.quartz.configuration;

import com.asa.demo.spring.scheduler.quartz.job.JobOne;
import com.asa.demo.spring.scheduler.quartz.job.JobTwo;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Configuration
public class ConfigureQuartzJob {

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(JobOne.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {
        return TriggerBuilder.newTrigger().forJob(jobADetails)
                .withIdentity("TriggerA")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *"))
                .build();
    }

    @Bean
    public JobDetail jobBDetails() {
        return JobBuilder.newJob(JobTwo.class).withIdentity("sampleJobB")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobBTrigger(JobDetail jobBDetails) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("somedata", UUID.randomUUID().toString());
        return TriggerBuilder.newTrigger().forJob(jobBDetails)
                .withIdentity("TriggerB")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * * *"))
                .usingJobData(jobDataMap)
                .build();
    }
}
