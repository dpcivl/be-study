package com.study.hello;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")   // 이 컨트롤러의 모든 주소는 /todos로 시작
public class TodoController {

    // 임시 저장소 (진짜 DB는 15과에서. 지금은 메모리 리스트)
    private final List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;   // id 자동 증가용

    // 생성 요청은 title만 받으면 됨
    public record CreateTodoRequest(String title) {}

    // 전체 조회: GET /todos
    @GetMapping
    public List<Todo> getAll() {
        return todos;
    }

    // 하나 조회: GET /todos/1
    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Long id) {
        // 6·7과의 스트림 + Optional!
        Optional<Todo> found = todos.stream()
                .filter(t -> t.id().equals(id))
                .findFirst();
        return found.orElse(null);   // 지금은 없으면 null (13과에서 제대로 고침)
    }

    // 생성: POST /todos
    @PostMapping
    public Todo create(@RequestBody CreateTodoRequest request) {   // Todo → CreateTodoRequest
        Todo newTodo = new Todo(nextId++, request.title(), false);
        todos.add(newTodo);
        return newTodo;
    }

        // 수정: PUT /todos/1
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo request) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).id().equals(id)) {
                Todo updated = new Todo(id, request.title(), request.done());
                todos.set(i, updated);   // 해당 위치를 교체
                return updated;
            }
        }
        return null;   // 없으면 null (13과에서 개선)
    }

    // 삭제: DELETE /todos/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        todos.removeIf(t -> t.id().equals(id));   // 조건 맞는 것 제거
        return "삭제 완료";
    }
}