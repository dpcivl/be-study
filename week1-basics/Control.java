public class Control {
    public static void main(String[] args) {
        int score = 85;

        // if / else if / else
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }

        // switch 표현식 (모던 자바 방식, break 불필요)
        String grade = "B";
        String comment = switch (grade) {
            case "A" -> "훌륭함";
            case "B" -> "좋음";
            default  -> "분발";
        };
        System.out.println(comment);

        // for
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        // while
        int n = 3;
        while (n > 0) {
            System.out.println("카운트다운 " + n);
            n--;
        }

        // 향상된 for (배열/리스트 순회용) - 다음 스텝 배열에서 다시 씀
        int[] nums ={10, 20, 30};
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}