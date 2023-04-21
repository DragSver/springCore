package com.example.modules.directory;

import com.example.modules.Module;

import java.io.File;

public class DirectoryFileData implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("dir");
    }

    @Override
    public String description() {
        return "Вывод данных о файлах в каталоге.";
    }

    @Override
    public void process(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("Файл: " + f.getName());
                    System.out.printf("Размер: %d bytes%n", f.length());
                    System.out.println("Создан: " + f.lastModified());
                    System.out.println("------------------------------");
                }
            }
        }
    }
}
