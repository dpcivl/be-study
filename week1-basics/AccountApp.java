public class AccountApp {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("코드런", 10000);

        acc.deposit(5000);
        acc.withdraw(3000);
        System.out.println("잔액: " + acc.getBalance());    // 12000

        // 말도 안 되는 인출 시드
        acc.withdraw(999999);   // 메서드가 막아준다

        System.out.println("최종 잔액: " + acc.getBalance());
    }
}

class BankAccount {
    private String owner;   // private = 바깥에서 직접 못 건드림
    private int balance;

    BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족! 인축 불가");
            return;     // 조건 안 맞으면 아무 일도 안 하고 빠져나감
        }
        balance -= amount;
    }

    // getter: 읽기는 허용
    int getBalance() {
        return balance;
    }
}