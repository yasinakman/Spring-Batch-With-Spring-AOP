package com.akman.springbootdemo.batch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30M")
@Component
@Slf4j
public class Scheduler {

    @Value("${batch.enabled}")
    private boolean enabled;

    private final JobLauncher jobLauncher;

    private final Job callTestJob;

    @Scheduled(cron = "${batch.cron}")
    @SchedulerLock(name = "runTestJob", lockAtLeastFor = "9M", lockAtMostFor = "20M")
    public void runTestJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {
        if (enabled) {
            log.info("testJob is scheduled");
            jobLauncher.run(callTestJob, new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
        }
    }
}
