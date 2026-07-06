import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // <String, Integer> = 키는 문자열, 값은 정수
        Map<String, Integer> scores = new HashMap<>();

        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민수", 95);

        System.out.println("영희 점수: " + scores.get("영희"));
        System.out.println("철수 있나? " + scores.containsKey("철수"));

        // 순회: 키-값 함께
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // === 실전 예제: 단어 개수 세기 ===
        String[] words = {"사과", "바나나", "사과", "사과", "바나나"};
        Map<String, Integer> count = new HashMap<>();

        for (String word : words) {
            // 이미 있으면 기존 값+1, 없으면 0에서 시작해 +1
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        System.out.println(count);
    }
}