package com.akman.springbootdemo.batch.job;

import com.akman.springbootdemo.batch.step.TestStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@EnableAutoConfiguration
@Slf4j
public class TestJob {

    private final TestStep testStep;
    //private final NewStep newStep;

    /*@Bean
    public Job callNewJob(JobBuilderFactory jobBuilderFactory) {
        log.info("newJob has called");
        return jobBuilderFactory.get("callNewJob").start(newStep).build();
    }*/

    @Bean
    @Transactional
    public Job callTestJob(JobBuilderFactory jobBuilderFactory) {
        log.info("TestJob has called");
        return jobBuilderFactory.get("callTestJob").start(testStep).build();
    }
}
