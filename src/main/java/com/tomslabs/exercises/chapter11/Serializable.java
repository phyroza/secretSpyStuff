package com.tomslabs.exercises.chapter11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Serializable {
    SerializationFormat format() default SerializationFormat.BINARY;

    public enum SerializationFormat {BINARY, TEXT}
}
