import java.io.Serializable;

public class Tenant implements Serializable {
  private String name;
  private int room;
  private PaymentList payments;
  private static final int maxNoOfPayments = 12;

  public Tenant(String name, int room) {
    this.name = name;
    this.room = room;
    payments = new PaymentList(maxNoOfPayments);
  }

  public String getName() {
    return name;
  }

  public int getRoom() {
    return room;
  }

  public void makePayment(Payment payment) {
    payments.add(payment);
  }

  public PaymentList getPayments() {
    return payments;
  }

  public String toString() {
    return "Tenant: " + name + " (room " + room + ")";
  }

  public void print() {
    System.out.println(toString());
    System.out.println("Payments:");
    for (int i = 0; i < payments.getTotal(); i++) {
      Payment payment = payments.getPayment(i);
      System.out.println("  " + payment.toString());
    }
  }
}

