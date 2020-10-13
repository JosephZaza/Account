import java.text.NumberFormat;
import java.util.Date;

/**
 * class Loan represents a loan.
 * @author Joseph Kern
 */
public class Loan extends AccountImpl implements Account {
  
  /**
   * Class constructor.
   */
  public Loan() {
  }
  
  /**
   * Class constructor.
   */
  public Loan(int id, double balance, String name) {
    super.setId(id);
    super.setBalance(balance);
    super.setName(name);
    super.getTransaction().add(new Transaction(new Date(), 'D', 0, super.getBalance(), "Deposit"));
  }
  
  /**
   * payment removes a specified amount from the balance.
   * @amount the amount to be removed.
   */
  public void payment(double amount) {
    super.setBalance((super.getBalance() - amount));
    super.getTransaction().add(new Transaction(new Date(), 'P', amount, 
        super.getBalance(), "Payment"));
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
    return (1 + super.getAnnualInterestRate() / 365) * 30;
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
