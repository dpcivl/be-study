import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDemo {
    public static void main(String[] args) {
        List<String> words = List.of("사과", "바나나", "사과", "사과", "바나나");

        // 이전: for 돌면서 getorDefault로 직접 셈
        // 지금: groupingBy + counting 한 줄
        Map<String, Long> count = words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(count);

        // 그룹핑 예제: 글자 수로 묶기
        List<String> names = List.of("김", "이철수", "박", "정영희", "최");
        Map<Integer, List<String>> byLength = names.stream()
            .collect(Collectors.groupingBy(name -> name.length()));
            System.out.println(byLength);
    }
}