package com.study;

import com.google.gson.Gson;

public class App {
    record Book(String title, int price) {}

    public static void main(String[] args) {
        Gson gson = new Gson();

        // 자바 객체 -> JSON 문자열
        Book book = new Book("클린 코드", 30000);
        String json = gson.toJson(book);
        System.out.println("JSON으로: " + json);

        // JSON 문자열 -> 자바 객체
        String input = "{\"title\":\"이펙티브 자바\",\"price\":36000}";
        Book parsed = gson.fromJson(input, Book.class);
        System.out.println("객체로: " + parsed);
    }
}