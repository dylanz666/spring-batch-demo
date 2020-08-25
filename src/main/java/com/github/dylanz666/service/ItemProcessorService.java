package com.github.dylanz666.service;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/25/2020
 */
@Service
public class ItemProcessorService implements ItemProcessor<String,String> {
    public String process(String data) throws Exception {
        //在此处进行数据处理操作，如进行计算、逻辑处理、格式转换等，本例将数据变成全大写数据；
        return data.toUpperCase();
    }
}
