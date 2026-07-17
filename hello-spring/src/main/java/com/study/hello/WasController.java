package com.study.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/was")
public class WasController {
    
    // 어떤 스레드가 내 요청을 처리하나?
    @GetMapping("/thread")
    public String whoAmI() {
        String threadName = Thread.currentThread().getName();
        System.out.println(">>> 요청 처리 스레드: " + threadName);
        return "이 요청을 처리한 스레드: " + threadName;
    }

    // 3초 걸리는 느린 작업 (Step 3에서 씀)
    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(">>> [시작] " + threadName);
        Thread.sleep(3000);   // 3초 일하는 척
        System.out.println(">>> [완료] " + threadName);
        return "완료 (스레드: " + threadName + ")";
    }
}
