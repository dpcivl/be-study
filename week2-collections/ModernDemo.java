import java.util.List;

public class ModernDemo {
    public static void main(String[] args) {
        // 1. var - 타입을 자바가 추론 (지역 변수만)
        var name = "코드런";    // String으로 추론
        var count = 10;         // int
        var books = List.of("A", "B");  // List<String>
        System.out.println(name + " " + count + " " + books);

        // 2. switch 표현식 - 값을 반환하는 switch
        var grade = "B";
        var comment = switch (grade) {
            case "A" -> "훌륭함";
            case "B" -> "좋음";
            case "C" -> "보통";
            default -> "미정";
        };
        System.out.println(comment);

        // 3. 텍스트 블록 - 여러 줄 문자열 (""" """)
        var report = """
            === 도서 정보 ===
            제목: %s
            가격: %d원
            """.formatted("클린 코드", 30000);
        System.out.println(report);
    }
}