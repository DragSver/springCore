package com.example.modules.text;

import com.example.modules.Module;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class TextWordCounter implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Вывод частоты вхождения каждого слова в текстовом файле.";
    }

    @Override
    public void process(File file) {
        BufferedReader reader = null;
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(file.getPath()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String word : words) {
                    if(wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}