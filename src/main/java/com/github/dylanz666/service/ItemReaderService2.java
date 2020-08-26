package com.github.dylanz666.service;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/26/2020
 */
@Service
public class ItemReaderService2 implements ItemReader {
    private int count = 0;

    public String read() throws Exception {
        if (ItemProcessorService.message != null && count < ItemProcessorService.message.length) {
            return ItemProcessorService.message[count++];
        }
        count = 0;
        return null;
    }
}
