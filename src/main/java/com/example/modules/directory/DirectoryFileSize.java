package com.example.modules.directory;

import com.example.modules.Module;

import java.io.File;

public class DirectoryFileSize implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("dir");
    }

    @Override
    public String description() {
        return "Подсчет размера всех файлов в каталоге.";
    }

    @Override
    public void process(File file) {
        long totalSize = calculateFolderSize(file);
        System.out.println("Размер каталога в байтах: " + totalSize);
    }

    public static long calculateFolderSize(File directory) {
        long length = 0;
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += calculateFolderSize(file);
            }
        }

        return length;
    }
}
