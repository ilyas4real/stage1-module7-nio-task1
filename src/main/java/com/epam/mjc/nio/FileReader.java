package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = Paths.get("C:\\Users\\Fora\\IdeaProjects\\stage1-module7-nio-task1\\src\\main\\resources\\"+file);
        Map<String, String> map = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] k = line.split(": ");
                String key = k[0];
                String value = k[1];
                map.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Profile(map.get("Name"), Integer.parseInt(map.get("Age")), map.get("Email"), Long.parseLong(map.get("Phone")));
    }
}
