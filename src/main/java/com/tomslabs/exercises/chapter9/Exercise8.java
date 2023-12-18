package com.tomslabs.exercises.javaImpatnient.chapter9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

public class Exercise8 {
    public static void main(String[] args) {
        Path sourceDataPath = Paths.get("C:/training");
        Path resultingZipPath = Paths.get("C:/tmp", sourceDataPath.getFileName().toString() + ".zip");
        zipDirectory(sourceDataPath, resultingZipPath);
    }

    private static void zipDirectory(Path sourcePath, Path zipPath) {
        URI zipUri;
        try {
            zipUri = new URI("jar", zipPath.toUri().toString(), null);
            Files.deleteIfExists(zipPath);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, Collections.singletonMap("create", true))) {
            Files.walk(sourcePath).filter(p -> !p.equals(sourcePath)).forEach(p -> {
                        try {
                            Path relativeFilePath = sourcePath.relativize(p);
                            System.out.print(p + "->");
                            System.out.println(zipUri + "/" + relativeFilePath);
                            Files.copy(p, zipFileSystem.getPath(relativeFilePath.toString()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
