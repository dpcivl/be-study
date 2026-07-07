public class ExceptionDemo {
    public static void main(String[] args) {
        // 에러가 날 수 있는 코드
        int[] arr = {10, 20, 30};

        // try 없이 이러면 프로그램이 죽는다 (일부러 범위 밖 접근)
        // System.out.println(arr[5]);  // 주석 풀면 크래시

        // try-catch로 감싸면 잡아서 처리
        try {
            System.out.println(arr[5]);     // 여기서 예외 발생
            System.out.println("이 줄은 실행 안 됨");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("잘못된 인덱스에 접근했어요: " + e.getMessage());
        }

        System.out.println("프로그램은 계속 살아있음");     // 실행됨!

        // 나눗셈 예외
        try {
            int result = 10 / 0;    // 0으로 나누기 -> 예외
        } catch (ArithmeticException e) {
            System.out.println("0으로 못 나눠요: " + e.getMessage());
        }

        // finally: 예외가 나든 안 나든 무조건 실행
        try {
            System.out.println("작업 시작");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("에러 발생");
        } finally {
            System.out.println("이건 무조건 실행 (뒷정리용)");
        }
    }
}