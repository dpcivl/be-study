import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // 크기가 자유로운 목록. <String> = "문자열만 담는다"
        List<String> books = new ArrayList<>();

        books.add("클린 코드");
        books.add("이펙티브 자바");
        books.add("리팩터링");

        System.out.println("개수: " + books.size());
        System.out.println("첫 번째: " + books.get(0));

        books.remove("리팩터링");
        System.out.println("삭제 후 개수: " + books.size());

        // 순회 (Day 2의 for-each 그대로)
        for (String book : books) {
            System.out.println("- " + book);
        }

        // 숫자 리스트
        List<Integer> scores = new ArrayList<>();
        scores.add(90);
        scores.add(85);
        scores.add(95);

        int total = 0;
        for (int s : scores) {
            total += s;
        }
        System.out.println("합계: " + total);
    }
}