public class PaymentList extends ObjectList {
  public PaymentList(int maxSize) {
    super(maxSize);
  }

  public Payment getPayment(int index) {
    return (Payment) super.getObject(index);
  }

  public double calculateTotalPaid() {
    double total = 0;
    for (int i = 0; i < super.getTotal(); i++) {
      Payment payment = getPayment(i);
      total += payment.getAmount();
    }
    return total;
  }
}
