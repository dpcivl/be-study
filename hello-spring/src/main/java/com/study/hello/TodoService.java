package com.study.hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service   // Day1: 스프링이 이걸 빈으로 관리
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Todo> findAll() {
        return todos;
    }

    public Optional<Todo> findById(Long id) {
        return todos.stream()
                .filter(t -> t.id().equals(id))
                .findFirst();
    }

    public Todo create(String title) {
        Todo newTodo = new Todo(nextId++, title, false);
        todos.add(newTodo);
        return newTodo;
    }

    public Optional<Todo> update(Long id, String title, boolean done) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).id().equals(id)) {
                Todo updated = new Todo(id, title, done);
                todos.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();   // 없으면 빈 Optional
    }

    public boolean delete(Long id) {
        return todos.removeIf(t -> t.id().equals(id));
    }
}