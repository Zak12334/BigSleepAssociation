public class Payment {
  // The month of the payment
  private String month;

  // The amount of the payment
  private double amount;

  // Constructor that initializes the month and amount of the payment
  public Payment(String month, double amount) {
    this.month = month;
    this.amount = amount;
  }

  // Returns the month of the payment
  public String getMonth() {
    return month;
  }

  // Returns the amount of the payment
  public double getAmount() {
    return amount;
  }

  // Returns a string representation of the payment
  public String toString() {
    return month + ": $" + amount;
  }

  // Prints the payment
  public void print() {
    System.out.println(toString());
  }
}