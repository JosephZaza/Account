import java.text.NumberFormat;
import java.util.Date;

/**
 * class Savings represents a savings account.
 * @author Joseph Kern
 */
public class Savings extends AccountImpl implements Account {

  /**
   * Class constructor.
   */
  public Savings() {
  }
  
  /**
   * Class constructor.
   * @param id int to be stored in id.
   * @param balance double to be stored in balance.
   * @param name string to be stored in name.
   */
  public Savings(int id, double balance, String name) {
    super.setId(id);
    super.setBalance(balance);
    super.setName(name);
    super.getTransaction().add(new Transaction(new Date(), 'D', 0, super.getBalance(), "Deposit"));
  }
  
  /**
   * withdraw removes a specified amount from the balance.
   * @amount amount to withdraw.
   */
  public void withdraw(double amount) {
    super.setBalance((super.getBalance() - amount));
    super.getTransaction().add(new Transaction(new Date(), 'W', amount, 
        super.getBalance(), "Withdraw"));
  }
  
  /**
   * deposit adds a specified amount to the balance.
   * @amount amount to deposit.
   */
  public void deposit(double amount) {
    super.setBalance((super.getBalance() + amount));
    super.getTransaction().add(new Transaction(new Date(), 'D', amount, 
        super.getBalance(), "Deposit"));
  }
  
  /**
   * getMonthlyInterestRate retrieves the monthly interest rate.
   * @return the value of the monthly interest rate.
   */
  public double getMonthlyInterestRate() {
    return super.getAnnualInterestRate() / 12;
  }
  
  /**
   * getMonthlyInterest retrieves the monthly interest.
   * @return the value of the monthly interest.
   */
  public double getMonthlyInterest() {
    return super.getBalance() * getMonthlyInterestRate();
  }

  @Override
  public String toString() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    String output = "Savings: name:'" + super.getName() + "', id: " + super.getId() + ", balance: " 
                    + formatter.format(super.getBalance()) + ", transactions [";
    for (Transaction transaction: super.getTransaction()) {
      output += transaction.toString();
    }
    output += "]\n, annualInterestRate: " + super.getAnnualInterestRate() + ", dateCreated: " 
              + super.getDateCreated();
    return output;
  }
}
