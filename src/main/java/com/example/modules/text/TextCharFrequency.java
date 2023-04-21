package com.example.modules.text;

import com.example.modules.Module;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextCharFrequency implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Вывод частоты вхождения каждого символа в текстовом файле.";
    }

    @Override
    public void process(File file) {
        try {
            Scanner scanner = new Scanner(file);
            Map<Character, Integer> frequencyMap = new HashMap<>();

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                for(char c : line.toCharArray()){
                    if(!frequencyMap.containsKey(c)){
                        frequencyMap.put(c, 1);
                    } else {
                        int count = frequencyMap.get(c);
                        frequencyMap.put(c, count + 1);
                    }
                }
            }

            for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}