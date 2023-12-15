package com.tomslabs.exercises.chapter11;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AnnotatedObjectOutputStream {
    public static final Charset charset = StandardCharsets.UTF_8;
    public static final String lineSeprator = System.getProperty("line.separator");
    public static final String classMarker = ">>>";
    OutputStream out;

    Serializable.SerializationFormat format;
    private Base64.Encoder encoder = Base64.getEncoder();

    public AnnotatedObjectOutputStream(OutputStream out, Serializable.SerializationFormat format) {
        this.out = out;
        this.format = format;
    }

    public void writeObject(Object object) throws NotSerializableException {
        Class<?> aClass = object.getClass();
        if (!checkIfSerializable(object))
            throw new NotSerializableException(aClass.getName());

        Serializable annotation = aClass.getAnnotation(Serializable.class);
        Serializable.SerializationFormat classFormat = annotation.format();

        if (classFormat != format)
            throw new IllegalArgumentException("Invalid class serialization format for this object output stream");

        if (format.equals(Serializable.SerializationFormat.TEXT)) {
            try (Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)) {
                if (format.equals(Serializable.SerializationFormat.TEXT)) {
                    writer.write(classMarker + aClass.getCanonicalName() + lineSeprator);
                }
                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    try {
                        String value = field.get(object).toString();
                        byte[] encodedValue = encoder.encode(value.getBytes(charset));
                        writer.write(field.getName() + ":" + new String(encodedValue, charset));
                        writer.write(lineSeprator);
                    } catch (IOException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private boolean checkIfSerializable(Object object) {
        Class<?> aClass = object.getClass();
        return aClass.getAnnotation(Serializable.class) != null;
    }
}
