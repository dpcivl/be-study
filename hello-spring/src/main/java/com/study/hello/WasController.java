package com.study.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/was")
public class WasController {

    private final TodoService todoService;

    public WasController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/thread")
    public String whoAmI() {
        return "이 요청을 처리한 스레드: " + Thread.currentThread().getName();
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(">>> [시작] " + threadName);
        Thread.sleep(3000);
        System.out.println(">>> [완료] " + threadName);
        return "완료 (스레드: " + threadName + ")";
    }

    // DB를 건드리면서 시간이 걸리는 작업
    @GetMapping("/db-slow")
    public int dbSlow() {
        String threadName = Thread.currentThread().getName();
        System.out.println(">>> [DB 시작] " + threadName);
        List<TodoResponse> todos = todoService.findAll();   // DB 커넥션 사용
        try { Thread.sleep(2000); } catch (InterruptedException e) {}  // 커넥션 오래 붙잡기
        System.out.println(">>> [DB 완료] " + threadName);
        return todos.size();
    }
}