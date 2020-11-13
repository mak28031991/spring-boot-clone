package com.airbnb.crud.exceptions;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(Class clazz, String... paramsValuesMap){
        super(generateMessage(clazz.getSimpleName(),ExceptionUtils.toMap(String.class, String.class, paramsValuesMap)));
    }
    private static String generateMessage(String entity, Map<String,String> paramsValuesMap){
        return StringUtils.capitalize(entity)+ " was not found for parameters "+paramsValuesMap;
    }
}
