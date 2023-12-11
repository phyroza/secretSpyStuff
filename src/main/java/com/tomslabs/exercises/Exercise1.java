package com.tomslabs.exercises;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise1 {
    private static void copyContents(InputStream source, OutputStream dst) {
        try {
            byte[] buffer = new byte[1024];
            while ((source.available() > 0)) {
                int readBytes = source.read(buffer);
                dst.write(buffer, 0, readBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyContents2(InputStream source, OutputStream dst) {
        try {
            Path tmpFile = Files.createTempFile(Paths.get("."), "tmp", ".txt");
            Files.write(tmpFile, source.readAllBytes());
            tmpFile.toFile().deleteOnExit();
            dst.write(Files.readAllBytes(tmpFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = "testChars".getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);

        copyContents2(inputStream, outputStream);

        System.out.println("outputStream = " + outputStream);
        outputStream.close();
        inputStream.close();
    }
}
