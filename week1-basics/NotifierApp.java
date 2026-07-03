public class NotifierApp {
    public static void main(String[] args) {
        // 타입은 인터페이스(Notifier), 실물은 구현체
        Notifier notifier = new EmailNotifier();
        sendWelcome(notifier);

        // 구현체만 바꾸면 동작이 통째로 바뀐다 (다형성)
        notifier = new SmsNotifier();
        sendWelcome(notifier);

        notifier = new SlackNotifier();
        sendWelcome(notifier);
    }

    // 핵심: 이 메서드는 "Notifier"만 알 뿐, 구체적으로 뭔지 모른다
    static void sendWelcome(Notifier notifier) {
        notifier.send("가입을 환영합니다!");
    }
}

// 약속(규격) - "send를 할 수 있어야 한다"만 정의
interface Notifier {
    void send(String message);      // 몸통 없음. 약속만. 
}

// 구현체 1
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[이메일] " + message);
    }
}

// 구현체 2
class SmsNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[문자] " + message);
    }
}

// 구현체 3
class SlackNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[슬랙] " + message);
    }
}