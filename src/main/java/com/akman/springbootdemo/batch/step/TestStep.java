package com.akman.springbootdemo.batch.step;

import com.akman.springbootdemo.model.User;
import com.akman.springbootdemo.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@EnableAutoConfiguration
@Slf4j
public class TestStep implements Step {

    @NonNull
    @Override
    public String getName() {
        return "testStep";
    }

    @Override
    public boolean isAllowStartIfComplete() {
        return false;
    }

    @Override
    public int getStartLimit() {
        return 1;
    }

    private final UserService userService;

    @Override
    public void execute(@NonNull StepExecution stepExecution) {
        log.info("TestStep has called");
        //do something here;
        User user = userService.saveUser();
    }
}
