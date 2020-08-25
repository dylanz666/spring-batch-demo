package com.github.dylanz666.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@Service
public class JobListener implements JobExecutionListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void beforeJob(JobExecution jobExecution) {
        logger.info("JOB IS STARTED.");
    }

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.FAILED) {
            logger.info("JOB IS EXECUTED FAILED.");
            return;
        }
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("JOB IS EXECUTED SUCCESSFULLY.");
        }
    }
}
