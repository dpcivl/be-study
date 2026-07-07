public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(10000);

        try {
            acc.withdraw(5000);
            System.out.println("잔액: " + acc.getBalance());    // 5000
            acc.withdraw(999999);   // 여기서 예외 던져짐
        } catch (InsufficientBalanceException e) {
            System.out.println("인출 실패: " + e.getMessage());
        }

        System.out.println("최종 잔액: " + acc.getBalance());       // 5000 (안 깎임)
    }
}

// 내가 만든 예외 (RuntimeException을 상속 - Day4 상속!)
class InsufficientBalanceException extends RuntimeException {
    InsufficientBalanceException(String message) {
        super(message);     // 부모 생성자에 메시지 전달
    }
}

class BankAccount {
    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    void withdraw(int amount) {
        if (amount > balance) {
            // 조건이 어긋나면 예외를 "던진다"
            throw new InsufficientBalanceException("잔액 부족: 현재 " + balance + ", 요청 " + amount);
        }
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }
}