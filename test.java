package in.kgcoding.challange78;

public class test {
    public static void main(String[]args){
        BankAccount account = new BankAccount("111", "Aman Pati Tripathi");
        account.depositMoney(100);
        System.out.println(account.withdrawMoney(500));
        account.depositMoney(-100);
        account.withdrawMoney(0);
    }
}
