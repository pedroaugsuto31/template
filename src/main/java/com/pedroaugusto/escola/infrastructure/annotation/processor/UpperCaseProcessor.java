package com.pedroaugusto.escola.infrastructure.annotation.processor;

import com.pedroaugusto.escola.infrastructure.annotation.UpperCase;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class UpperCaseProcessor {

    public void convertFieldsToUpperCase(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(UpperCase.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value instanceof String) {
                    field.set(obj, ((String) value).toUpperCase());
                }
            }
        }
    }
}
