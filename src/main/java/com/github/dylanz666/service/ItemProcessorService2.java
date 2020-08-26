package com.github.dylanz666.service;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/26/2020
 */
@Service
public class ItemProcessorService2 implements ItemProcessor<String, String> {
    public String process(String data) throws Exception {
        return data + " dylanz";
    }
}
