package com.example.modules.text;

import com.example.modules.Module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextLineCounter implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Подсчет и вывод количества строк в текстовом файле.";
    }

    @Override
    public void process(File file) {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            while ((br.readLine()) != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Количество строк в файле: " + lineCount);
    }
}
