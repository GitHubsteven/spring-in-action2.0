/**
 * @author: asx
 * @date: 2023/3/2
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    protected static ObjectMapper OM = new ObjectMapper();

    static {
        OM.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return OM.readValue(json, OM.getTypeFactory()
                    .constructMapType(HashMap.class, String.class, Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
