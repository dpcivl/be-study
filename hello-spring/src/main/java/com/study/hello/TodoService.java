package com.study.hello;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // Day1: 생성자 주입 — 스프링이 구현체를 넣어줌
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo create(String title) {
        Todo newTodo = new Todo(title, false);
        return todoRepository.save(newTodo);   // 저장하면 id가 채워져서 돌아옴
    }

    public Optional<Todo> update(Long id, String title, boolean done) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(title);
                    todo.setDone(done);
                    return todoRepository.save(todo);
                });
    }

    public boolean delete(Long id) {
        if (!todoRepository.existsById(id)) {
            return false;
        }
        todoRepository.deleteById(id);
        return true;
    }
}