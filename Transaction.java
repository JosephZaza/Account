import java.text.DecimalFormat;
import java.util.Date;

/**
 * This class represent the transactions.
 */
public class Transaction {
  private final Date transactionDate;
  private final char type;
  private final double amount;
  private final double balance;
  private final String description;
  private final DecimalFormat df = new DecimalFormat("$###,###.00");

  /**
   *  The constructor for transactions.
   */
  public Transaction(Date transactionDate, char type, double amount,
                     double balance, String description) {
    this.transactionDate = transactionDate;
    this.type = type;
    this.amount = amount;
    this.balance = balance;
    this.description = description;
  }

  /**
   *  This method creates a String representation of the Transaction.
   */
  @Override
  public String toString() {
    return  "\nTransaction: "
            + "transactionDate:" + transactionDate
            + ", type:" + type
            + ", amount:" + df.format(amount)
            + ", balance:" + df.format(balance)
            + ", description:" + description;
  }
}
