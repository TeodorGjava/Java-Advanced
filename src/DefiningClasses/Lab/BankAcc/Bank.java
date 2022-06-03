package DefiningClasses.Lab.BankAcc;

public class Bank {
    private int id;

    public int getIds() {
        return ids;
    }

    private int ids = 1;

    private static double Interest_Rate = 0.02;
    public Bank() {
        this.id = ids;
        ids++;
    }

    private double Balance;
    public static void setInterest_Rate(double interest_Rate) {
        Interest_Rate = interest_Rate;
    }

    public double getInterest(double years){
        return Interest_Rate*years*this.Balance;
    }

    public void deposit(double amount){
        this.Balance+=amount;
    }

    public int getId() {
        return id;
    }
}
