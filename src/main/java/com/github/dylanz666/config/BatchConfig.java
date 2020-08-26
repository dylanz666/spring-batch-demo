package com.github.dylanz666.config;

import com.github.dylanz666.service.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@Configuration
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReaderService itemReaderService;
    @Autowired
    private ItemReaderService2 itemReaderService2;
    @Autowired
    private ItemProcessorService itemProcessorService;
    @Autowired
    private ItemProcessorService2 itemProcessorService2;
    @Autowired
    private ItemWriterService itemWriterService;
    @Autowired
    private JobListener jobListener;

    @Bean
    public Job singleStepJob() {
        return jobBuilderFactory.get("singleStepJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(uppercaseStep())
                .build();
    }

    @Bean
    public Job multiBoundStepsJob() {
        return jobBuilderFactory.get("multiBoundStepsJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(uppercaseStep())
                .next(addMessageStep())
                .build();
    }

    @Bean
    public Step uppercaseStep() {
        return stepBuilderFactory.get("uppercaseStep")
                .<String, String>chunk(1)
                .reader(itemReaderService)
                .processor(itemProcessorService)
                .writer(itemWriterService).build();
    }

    @Bean
    public Step addMessageStep() {
        return stepBuilderFactory.get("addMessageStep")
                .<String, String>chunk(1)
                .reader(itemReaderService2)
                .processor(itemProcessorService2)
                .writer(itemWriterService).build();
    }

    @Bean
    public JobExecutionListener listener() {
        return jobListener;
    }
}
