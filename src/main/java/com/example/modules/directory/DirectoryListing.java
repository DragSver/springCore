package com.example.modules.directory;

import com.example.modules.Module;

import java.io.File;
import java.util.Arrays;

public class DirectoryListing implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("dir");
    }

    @Override
    public String description() {
        return "Вывод списка файлов в каталоге.";
    }

    @Override
    public void process(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(f -> System.out.println(f.getName()));
            }
        } else {
            System.out.println(file.getName() + " не является директорией.");
        }
    }
}
