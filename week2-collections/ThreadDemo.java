import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // === 순차 실행: 3개 작업이 차례로 (총 3초) ===
        System.out.println("=== 순차 ===");
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 3; i++) {
            task(i);    // 하나 끝나야 다음
        }
        System.out.println("순차 소요: " + (System.currentTimeMillis() - start) + "ms");

        // === 스레드풀로 동시 실행 (총 ~1초) ===
        System.out.println("=== 동시 (스레드풀) ===");
        start = System.currentTimeMillis();

        ExecutorService pool = Executors.newFixedThreadPool(3);     // 일꾼 3명
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            pool.submit(() -> task(taskId));    // 일감을 던짐
        }
        pool.shutdown();    // 더 안 받음
        pool.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);    // 끝날 때까지 대기

        System.out.println("동시 소요: " + (System.currentTimeMillis() - start) + "ms");
    }

    // 1초 걸리는 작업 흉내
    static void task(int id) {
        System.out.println("작업 " + id + " 시작 (" + Thread.currentThread().getName() + ")");
        try {
            Thread.sleep(1000);     // 1초 대기 (일하는 척)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("작업 " + id + " 완료");
    }
}