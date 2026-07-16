package com.study.hello;

public record TodoResponse(Long id, String title, boolean done, String categoryName) {

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isDone(),
                todo.getCategory() != null ? todo.getCategory().getName() : null
        );
    }
}
