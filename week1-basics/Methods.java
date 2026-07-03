public class Methods {
    // 메서드: 반환타입 이름(파라미터) { ... }
    static int add(int a, int b) {
        return a + b;
    }

    // 반환값 없으면 void
    static void greet(String name) {
        System.out.println("안녕하세요, " + name + "님");
    }

    // 배열을 받아 합을 반환
    static int sum(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        return total;
    }

    // 배열의 최댓값
    static int max(int[] arr) {
        int result = arr[0];
        for (int x : arr) {
            if (x > result) {
                result = x;
            }
        }
        return result;
    }

    static double average(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        return (double) total / arr.length;
    }

    public static void main(String[] args) {
        System.out.println(add(3, 4));
        greet("코드런");
        
        int[] scores = {70, 95, 82, 60, 88};
        System.out.println("합: " + sum(scores));
        System.out.println("최대: " + max(scores));
        System.out.println("개수: " + scores.length);   // 배열 길이
        System.out.println("평균: " + average(scores));
    }
}
