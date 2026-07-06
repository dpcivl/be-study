import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> books = List.of("클린 코드", "이펙티브 자바", "리팩터링");

        // 조건에 맞는 첫 요소 찾기 -> 있을 수도, 없을 수도
        Optional<String> found = books.stream()
            .filter(b -> b.startsWith("이"))
            .findFirst();

        // 값이 있을 때만 실행
        found.ifPresent(b -> System.out.println("찾음 " + b));

        // 값이 없으면 기본값
        Optional<String> notFound = books.stream()
            .filter(b -> b.startsWith("파이썬"))
            .findFirst();
        String result = notFound.orElse("결과 없음");
        System.out.println(result);

        // 값을 변환하되, 없으면 기본 문자열
        String label = found.map(b -> "[" + b + "]").orElse("[없음]");
        System.out.println(label);
    }
}