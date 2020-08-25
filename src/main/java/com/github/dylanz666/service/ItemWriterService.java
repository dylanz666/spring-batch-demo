package com.github.dylanz666.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@Service
public class ItemWriterService implements ItemWriter<String> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //在此处进行数据输出操作，如写入数据库、写入文件、打印log等，本例为打印log；
    public void write(List<? extends String> messages) throws Exception {
        for (String message : messages) {
            logger.info("Writing data: " + message);
        }
    }
}
