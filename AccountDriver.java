import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDriver {

  /**
   * This is the start of the program.
   * This was provided for the project from @author John Audas
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    List<Account> accountList = new ArrayList<>();
    String more = "Y";
    do {
      System.out.println("What Type of account, enter �L� for Loan or �S� for Savings account?");
      final String accountType = input.next();
      System.out.println("Account Id?");
      int accountId = input.nextInt();
      System.out.println("Initial Balance?");
      double balance = input.nextDouble();
      System.out.println("Account Name?");
      String name = input.next();
      System.out.println("Annual Interest Rate?");
      double apr = input.nextDouble();
      Account account;

      if ("L".equalsIgnoreCase(accountType)) {
        account = new Loan(accountId, balance, name);
      } else if ("S".equalsIgnoreCase(accountType)) {
        account = new Savings(accountId, balance, name);
      } else {
        System.out.println(accountType + " is not a valid type of account");
        continue;
      }
      account.setAnnualInterestRate(apr);
      accountList.add(account);
      enterTransactions(input, account);
      System.out.println("Enter another Account, enter �Y� for yes?");
      more = input.next();

    } while ("Y".equalsIgnoreCase(more));

    addInterestAccounts(accountList);
    printAccounts(accountList);
  }

  private static void enterTransactions(Scanner input, Account account) {
    String more;
    do {
      System.out.println("What Type of Transaction, enter �W� for withdraw, "
              + "�D� for Deposit, or 'P' for payment?");
      String transactionType = input.next();
      System.out.println("Transaction amount?");
      double transactionAmount = input.nextDouble();

      switch (transactionType.toUpperCase()) {
        case "W":
          ((Savings) account).withdraw(transactionAmount);
          break;
        case "D":
          ((Savings) account).deposit(transactionAmount);
          break;
        case "P":
          ((Loan) account).payment(transactionAmount);
          break;
        default:
          System.out.printf("Transaction Type %s is not supported", transactionType);
      }
      System.out.println("Enter another Transaction, enter �Y� for yes?");
      more = input.next();
    } while ("Y".equalsIgnoreCase(more));
  }

  private static void addInterestAccounts(List<Account> accountList) {
    for (Account account : accountList) {
      account.addInterest();
    }
  }

  private static void printAccounts(List<Account> accountList) {
    for (Account account : accountList) {
      System.out.println(account.toString());
      System.out.println();
    }
  }
}
