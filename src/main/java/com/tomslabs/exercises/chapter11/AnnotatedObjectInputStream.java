package com.tomslabs.exercises.javaImpatnient.chapter11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AnnotatedObjectInputStream {
    public static final Charset charset = StandardCharsets.UTF_8;
    public static final String classMarker = ">>>";
    private static final int MAX_SERIALIZED_FIELD_LENGTH = 2048;
    public static final String lineSeprator = System.getProperty("line.separator");
    InputStream in;
    Serializable.SerializationFormat format;
    LineNumberReader reader;
    private Base64.Decoder decoder = Base64.getDecoder();

    public AnnotatedObjectInputStream(InputStream in, Serializable.SerializationFormat format) {
        this.in = in;
        this.format = format;

        if (format.equals(Serializable.SerializationFormat.TEXT)) {
            reader = new LineNumberReader(new InputStreamReader(in, charset));
        }
    }

    public Object readObject() throws IOException {
        if (Serializable.SerializationFormat.TEXT.equals(format)) {
            reader.mark(MAX_SERIALIZED_FIELD_LENGTH);
            List<String> instanceData = readInstanceData();
            System.out.println(instanceData);

            String classHeader = instanceData.get(0);
            if (!classHeader.startsWith(classMarker))
                throw new IllegalStateException("Cannot read object, corrupted file");
            else {
                String className = classHeader.replace(classMarker, "");
                try {
                    Class<?> deserializedClass = Class.forName(className);
                    Object object = deserializedClass.newInstance();

                    for (int i = 1; i < instanceData.size(); i++) {
                        String fieldLine = instanceData.get(i);
                        String[] splitFieldLine = fieldLine.split(":");
                        String fieldName = splitFieldLine[0];
                        String fieldStringValue = new String(decoder.decode(splitFieldLine[1]), charset);

                        Field field = deserializedClass.getDeclaredField(fieldName);
                        Object fieldValue = deserializeField(field.getGenericType().getTypeName(), fieldStringValue);
                        field.set(object, fieldValue);
                    }
                    return object;

                } catch (ClassNotFoundException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException("Deserialization failure" + className, e);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return null;
    }

    private List<String> readInstanceData() throws IOException {
        List<String> instanceData = new ArrayList<>();

        boolean firstLine = true;
        String nextLine = reader.readLine();
        while (nextLine != null && (firstLine || !nextLine.startsWith(classMarker))) {
            firstLine = false;
            instanceData.add(nextLine);
            nextLine = reader.readLine();
        }

        return instanceData;
    }

    private static Object deserializeField(String typeName, String fieldStringValue) throws IllegalAccessException {
        if (typeName.equals("int")) {
            return Integer.parseInt(fieldStringValue);
        } else if (typeName.equals("byte")) {
            return Byte.parseByte(fieldStringValue);
        } else if (typeName.equals("short")) {
            return Short.parseShort(fieldStringValue);
        } else if (typeName.equals("long")) {
            return Long.parseLong(fieldStringValue);
        } else if (typeName.equals("double")) {
            return Double.parseDouble(fieldStringValue);
        } else if (typeName.equals("float")) {
            return Float.parseFloat(fieldStringValue);
        } else if (typeName.equals("char")) {
            return fieldStringValue.charAt(0);
        } else if (typeName.equals("boolean")) {
            return Boolean.parseBoolean(fieldStringValue);
        } else {
            System.out.println(typeName);
        }

        return null;
    }

}
