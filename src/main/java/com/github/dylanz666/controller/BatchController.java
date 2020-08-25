package com.github.dylanz666.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@RestController
public class BatchController {
    @Autowired
    private Job singleStepJob;
    @Autowired
    private Job multiStepsJob;
    @Autowired
    private Job multiProcessorStepJob;
    @Autowired
    private JobLauncher jobLauncher;

    @GetMapping("/job/step")
    public String invokeStep() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(singleStepJob, jobParameters);
        return "The single step job is proceed.";
    }

    @GetMapping("/job/steps")
    public String invokeSteps() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(multiStepsJob, jobParameters);
        return "The multi steps job is proceed.";
    }

    @GetMapping("/job/test/step")
    public String invokeTestSteps() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(multiProcessorStepJob, jobParameters);
        return "The multi processor step job is proceed.";
    }
}
