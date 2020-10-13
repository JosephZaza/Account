import java.util.Date;
/**
 * interface Account represents an account.
 * @author Joseph Kern
 */

public interface Account {
  public String getName();
  
  public int getId();
  
  public double getBalance();
  
  public void setAnnualInterestRate(double rate);
  
  public double getAnnualInterestRate();
  
  public Date getDateCreated();
  
  public double getMonthlyInterestRate();
  
  public double getMonthlyInterest();
  
  public void addInterest();
}
