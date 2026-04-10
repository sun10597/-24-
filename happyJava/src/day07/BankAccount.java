package day07;

public class BankAccount {
    private String 계좌번호;
    private String 소유자;
    private int 잔액;

    public BankAccount(String 계좌번호,String 소유자, int 잔액){
        this.계좌번호 = 계좌번호;
        this.소유자 = 소유자;
        this.잔액 = 잔액;
    }

    public void 입금(int money){
        this.잔액 += money;
        System.out.printf("입금 %d\n", money);
    }

    public void 출금(int money) {
        if (money > 잔액) {
            System.out.println("잔액부족");
        } else {
            this.잔액 -= money;
            System.out.printf("출금 %d\n", money);
        }
    }

    public void 조회(){
        System.out.printf("잔액: %d원", 잔액);
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("1000-1234-1234", "김선우", 10000);
        a.입금(1100000);
        a.출금(600000);
        a.조회();
    }
}
