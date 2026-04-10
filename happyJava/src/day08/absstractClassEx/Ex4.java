package day08.absstractClassEx;

abstract class Payment{
    double amount;

    Payment(double amount){
        this.amount = amount;
    }

    abstract void pay();
}

class CardPayment extends  Payment{
    CardPayment(double amount) {
        super(amount);
    }
    @Override
    void pay() {
        System.out.printf("신용카드로 %.0f원 결제하였습니다.\n", amount);
    }
}

class PaypalPayment extends  Payment{
    PaypalPayment(double amount) {
        super(amount);
    }
    @Override
    void pay() {
        System.out.printf("PayPal로 %.0f원 결제하였습니다.\n", amount);
    }
}
public class Ex4 {
    public static void main(String[] args) {
        Payment p1 = new CardPayment(10000);
        Payment p2 = new PaypalPayment(20000);
        p1.pay();
        p2.pay();
    }
}
