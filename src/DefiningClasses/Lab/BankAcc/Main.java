package DefiningClasses.Lab.BankAcc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Map<Integer, Bank> bankAccounts = new LinkedHashMap<>();
        while (!line.equals("End")) {
            String output = null;
            String[] elements = line.split(" ");
            String command = elements[0];
            Bank bankAccount;
            switch (command) {
                case "Create":
                     bankAccount = new Bank();
                    bankAccounts.put(bankAccount.getIds(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(elements[1]);
                    int amount = Integer.parseInt(elements[2]);
                    if (bankAccounts.containsKey(id)) {
                        Bank bank = bankAccounts.get(id);
                        bank.deposit(amount);
                        output = String.format("Deposited %s to ID%d", amount, bank.getId());
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(elements[1]);
                    Bank.setInterest_Rate(interest);
                    break;
                case "GetInterest":
                    int ID = Integer.parseInt(elements[1]);
                    if (bankAccounts.containsKey(ID)) {
                        int years = Integer.parseInt(elements[2]);
                        bankAccount = bankAccounts.get(ID);
                        output = String.format("%.2f", bankAccount.getInterest(years));
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            System.out.println(output);
            line = sc.nextLine();
        }
    }
}
