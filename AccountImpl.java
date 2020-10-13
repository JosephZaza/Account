import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * class AccountImp represent an account.
 * @author Joseph Kern
 */
public abstract class AccountImpl {
  
  private String name = "";
  private int id = 0;
  private double balance = 0;
  private ArrayList<Transaction> transaction = new ArrayList<Transaction>();
  private double annualInterestRate = 0;
  private Date dateCreated;
  
  /**
   * Class constructor.
   */
  public AccountImpl() {
    Calendar calendar = new GregorianCalendar(2018, 7, 13);    
    dateCreated = calendar.getTime();
  }

  /**
   * Class constructor.
   * @param id int to be stored in id.
   * @param balance double to be stored in balance.
   * @param annualInterestRate double to store in annualInterestRate.
   */
  public AccountImpl(int id, double balance, double annualInterestRate) {
    this.id = id;
    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
    Calendar calendar = new GregorianCalendar(2018, 7, 13);    
    dateCreated = calendar.getTime();
  }

  /**
   * getName retrieves the value stored in name.
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * setName assigns a value to name.
   * @param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * getId retrieves the value stored in id.
   * @return the id.
   */
  public int getId() {
    return id;
  }

  /**
   * setId assigns a value to id.
   * @param id the id to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * getBalance retrieves the value stored in balance.
   * @return the balance.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * setBalance assigns a value to balance.
   * @param balance the balance to set.
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * getAnnualInterestRate retrieves the value stored in annualInterestRate.
   * @return the annualInterestRate.
   */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /**
   * setAnnualInterestRate assigns a value to annualInterestRate.
   * @param annualInterestRate the annualInterestRate to set.
   */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /**
   * getTransaction retrieves the value stored in transaction.
   * @return the transaction.
   */
  public ArrayList<Transaction> getTransaction() {
    return transaction;
  }

  /**
   * getDatecreated retrieves the value stored in dateCreated.
   * @return the dateCreated.
   */
  public Date getDateCreated() {
    return dateCreated;
  }
  
  /**
   * getMonthlyInterestRate retrieves the value stored in monthlyInterestRate.
   */
  public abstract double getMonthlyInterestRate();
  
  /**
   * getMonthlyInterest retrieves the value stored in monthlyInterest.
   */
  public abstract double getMonthlyInterest();
  
  /**
   * addInterest adds the value stored in monthlyInterest to balance 
   * and then adds it to transaction.
   */
  public void addInterest() {
    balance += getMonthlyInterest();
    this.getTransaction().add(new Transaction(new Date(), 'D', getMonthlyInterest(), 
        this.getBalance(), "Monthly Interest"));
  }

  @Override
  public String toString() {
    return "AccountImpl [name=" + name + ", id=" + id + ", balance=" 
        + balance + ", annualInterestRate="
        + annualInterestRate + ", dateCreated=" + dateCreated + "]";
  }
}
