import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> books = List.of("클린 코드", "이펙티브 자바", "리팩터링", "자바의 정석");

        // 이전 방식: for문으로 4글자 이상만 골라 출력
        System.out.println("=== for문 ===");
        for (String book : books) {
            if (book.length() >= 5) {
                System.out.println(book);
            }
        }

        // 지금 방식: 스트림
        System.out.println("=== 스트림 ===");
        books.stream()
        .filter(book -> book.length() >= 5)     // 조건에 맞는 것만 통과
        .forEach(book -> System.out.println(book));
    }

    // 변환(map): 각 요소를 다른 값으로 바꾸기
    System.out.println("=== 대문자로? 아니 글자수로 ===")
    books.stream()
    .map(book -> book + " (" + book.length() + "자)")   // 각 요소를 변형
    .forEach(System.out::println);  // 메서드 참조

    // 숫자 예제: 필터 + 변환 + 리스트로 수집
    List<Integer> scores = List.of(90, 55, 85, 40, 95);
    List<integer> passed = scores.stream()
    .filter(s -> s >= 60)       // 60점 이상만
    .map(s -> s + 5)            // 보너스 5점
    .toList();                  // 다시 리스트로
    System.out.Println("합격+보너스: " + passed);   // [95, 90, 100]
}