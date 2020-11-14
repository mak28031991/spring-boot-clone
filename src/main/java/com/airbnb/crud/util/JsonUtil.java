package com.airbnb.crud.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

public class JsonUtil {
    public static ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    public static <T> T jsonDecode(String jsonString, Class<T> type){
        if(StringUtils.isEmpty(jsonString)){
            return null;
        }
        return objectMapper.reader(type).readValue(jsonString);
    }
}
