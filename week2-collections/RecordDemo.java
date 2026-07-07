public class RecordDemo {
    public static void main(String[] args) {
        // record로 만든 객체
        Book book = new Book("클린 코드", "로버트 마틴", 30000);

        // 접근자: getTitle()이 아니라 title() (괄호 있음)
        System.out.println(book.title());
        System.out.println(book.author());
        System.out.println(book.price());

        // toString 자동 생성 - 그냥 출력하면 내용이 다 나옴
        System.out.println(book);

        // equals 자동 생성 - 값이 같으면 같은 것으로 취급
        Book same = new Book("클린 코드", "로버트 마틴", 30000);
        System.out.println("값이 같나? " + book.equals(same));
    }
}

// 이 한 줄이 필드 + 생성자 + 접근자 + toString + equals + hashCode를 다 만들어줌
record Book(String title, String author, int price) {}