package com.example.modules.directory;

import com.example.modules.Module;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryFileAccess implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("dir");
    }

    @Override
    public String description() {
        return "Вывод доступа всех файлов в каталоге.";
    }

    @Override
    public void process(File file) {
        Path directory = Paths.get(file.getPath());

        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Файл: " + file.toString());
                    System.out.println("Параметры доступа: " + Files.getPosixFilePermissions(file));
                    System.out.printf("Создан: %s%n", Files.getAttribute(file, "basic:creationTime"));
                    System.out.printf("Изменен: %s%n", Files.getAttribute(file, "basic:lastModifiedTime"));
                    System.out.printf("Размер: %s%n", Files.size(file));
                    System.out.println();
                    return FileVisitResult.CONTINUE;
            }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
