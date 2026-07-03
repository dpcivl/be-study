public class BookApp {
    public static void main(String[] args) {
        // 설계도(Book)로 실물(객체)을 찍어낸다
        Book b1 = new Book("클린 코드", "로버트 마틴", 30000);
        Book b2 = new Book("이펙티브 자바", "조슈아 블로크", 36000);

        // 각 객체는 자기만의 값을 가진다
        b1.printInfo();
        b2.printInfo();

        // 메서드로 값을 바꿔본다
        b1.discount(5000);
        b1.printInfo();
    }
}


// 설계도(클래스)
class Book {
    // 필드: 이 클래스가 가지는 데이터
    String title;
    String author;
    int price;

    // 생성자: new 할 때 호출되어 필드를 채운다 (클래스 이름과 똑같음)
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 메서드: 이 클래스가 할 수 있는 동작
    void printInfo() {
        System.out.println(title + " / " + author + " / " + price + "원");
    }

    void discount(int amount) {
        price = price - amount;
    }
}