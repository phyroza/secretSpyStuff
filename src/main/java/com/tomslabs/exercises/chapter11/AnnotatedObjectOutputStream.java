package com.tomslabs.exercises.javaImpatnient.chapter11;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.tomslabs.exercises.javaImpatnient.chapter11.Serializable.SerializationFormat.TEXT;

public class AnnotatedObjectOutputStream {
    public static final Charset charset = StandardCharsets.UTF_8;
    public static final String lineSeparator = System.getProperty("line.separator");
    public static final String classMarker = ">>>";
    OutputStream out;
    Serializable.SerializationFormat format;
    private Base64.Encoder encoder = Base64.getEncoder();

    public AnnotatedObjectOutputStream(OutputStream out, Serializable.SerializationFormat format) {
        this.out = out;
        this.format = format;
    }

    public void writeObject(Object object) throws IOException {
        Class<?> aClass = object.getClass();
        if (!checkIfSerializable(object))
            throw new NotSerializableException(aClass.getName());

        Serializable annotation = aClass.getAnnotation(Serializable.class);
        Serializable.SerializationFormat classFormat = annotation != null ? annotation.format() : TEXT;

        if (classFormat != format)
            throw new IllegalArgumentException("Invalid class serialization format for this object output stream");

        if (format.equals(TEXT)) {
            {
                Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                if (format.equals(TEXT)) {
                    writer.write(classMarker + aClass.getCanonicalName() + lineSeparator);
                }
                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    try {
                        if (field.getType().isPrimitive())
                            writePrimitiveField(object, field, writer);
                        else {
                            field.setAccessible(true);
                            writeObject(field.get(object));
                        }
                    } catch (IOException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


    }

    private void writePrimitiveField(Object object, Field field, Writer writer) throws IllegalAccessException, IOException {
        String value = field.get(object).toString();
        byte[] encodedValue = encoder.encode(value.getBytes(charset));
        writer.write(field.getName() + ":" + new String(encodedValue, charset));
        writer.write(lineSeparator);
    }

    private boolean checkIfSerializable(Object object) {
        return true;
//        Class<?> aClass = object.getClass();
//        return aClass.getAnnotation(Serializable.class) != null;
    }
}
