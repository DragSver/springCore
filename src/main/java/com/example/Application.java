package com.example;

import com.example.modules.Module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static List<Module> modules;

    @Autowired
    public Application(List<Module> modules) {
        Application.modules = modules;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Scanner scanner = new Scanner(System.in);

        // Запрашиваем данные о файле
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        execute(filePath);
    }

    public static void execute(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            LOGGER.error("Файл {} не найден.", filePath);
            return;
        }

        List<Module> suitableModules = modules.stream().filter(m -> m.supports(getFileExtension(file))).toList();

        if (suitableModules.size() == 0) throw new RuntimeException("Не найден соответствующий модуль.");

        System.out.print("Подходящие модули:\n");
        for (int i=0; i<suitableModules.size(); i++) {
            System.out.print(i+1 + ". " + suitableModules.get(i).description() + "\n");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цифру выбранного модуля: ");
        int numModule = scanner.nextInt();
        Module module;
        try {
            module = suitableModules.get(--numModule);
        } catch (Exception e) {
            throw new RuntimeException("Введен неправильный номер модуля.");
        }

        LOGGER.info("Выбран модуль: {}", module.description());

        module.process(file);
    }

    private static String getFileExtension(File file) {
        int index = file.getName().indexOf('.');
        return index == -1? "dir" : file.getName().substring(++index);
    }

}

