package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> post = new HashMap<>();
        post.put("sledakvrn@gmail.com", "Nikita Shcherbakov");
        for (String key : post.keySet()) {
            String value = post.get(key);
            System.out.println(value + " - " + key);
        }
    }
}
