package com.study.hello;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)   // 기본은 읽기 전용
public class TodoService {

    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;

    public TodoService(TodoRepository todoRepository, CategoryRepository categoryRepository) {
        this.todoRepository = todoRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAllWithCategory().stream()   // ← 여기만 변경
                .map(TodoResponse::from)
                .toList();
    }

    public Optional<TodoResponse> findById(Long id) {
        return todoRepository.findById(id).map(TodoResponse::from);
    }

    @Transactional   // 쓰기 작업은 readOnly 해제
    public TodoResponse create(String title, Long categoryId) {
        Category category = categoryId == null ? null
                : categoryRepository.findById(categoryId).orElse(null);
        Todo saved = todoRepository.save(new Todo(title, false, category));
        return TodoResponse.from(saved);
    }

    @Transactional
    public Optional<TodoResponse> update(Long id, String title, boolean done) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(title);
                    todo.setDone(done);
                    return TodoResponse.from(todo);   // save 안 해도 반영됨 (아래 설명)
                });
    }

    @Transactional
    public boolean delete(Long id) {
        if (!todoRepository.existsById(id)) {
            return false;
        }
        todoRepository.deleteById(id);
        return true;
    }

    // 실습용: 카테고리 만들기
    @Transactional
    public Category createCategory(String name) {
        return categoryRepository.save(new Category(name));
    }
}