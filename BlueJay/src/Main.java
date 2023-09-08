import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		ObjectList objectList = new ObjectList(10);
		objectList.add(new Tenant("John Smith", 1));
		objectList.add(new Tenant("Jane Smith", 2));

		// save the list to a file
		FileManager.saveObjectList(objectList, "tenants.dat");

		// load the list from a file
		ObjectList loadedList = FileManager.loadObjectList("tenants.dat");
		
		//I added this to test if the tenant info was being saved correctly. 
//		for (int i = 0; i < loadedList.getTotal(); i++) {
//		    Tenant tenant = (Tenant) loadedList.getItem(i);
//		    System.out.println(tenant.getName() + " " + tenant.getRoom());
//		}

		Scanner scanner = new Scanner(System.in);
		TenantList tenants = new TenantList(10);

		while (true) {
			// Print menu
			System.out.println("1. Add a Tenant");
			System.out.println("2. List all Tenants");
			System.out.println("3. Add a payment");
			System.out.println("4. List all payments");
			System.out.println("5. Remove a Tenant");
			System.out.println("6. Get number of payments made (per Tenant)");
			System.out.println("7. Get total payments made (per Tenant)");
			System.out.println("8. Get total Payments made for the entire hostel.");
			System.out.println("9. Quit");
			System.out.print("Enter your choice: ");

			// Read user input
			int choice = scanner.nextInt();
			if (choice == 9) {
				System.out.println("Thank you and Goodbye!");
				break;
			}

			// Process user input
			switch (choice) {
			// Add a Tenant
			case 1:
				if (tenants.isFull()) {
					System.out.println("All rooms are booked!");
					break;
				}
				System.out.print("Enter tenant name: ");
				String name = scanner.next();
				System.out.print("Enter tenant room number: ");
				int room = scanner.nextInt();
				tenants.add(new Tenant(name, room));
				break;
			case 2:
				// List all Tenants
				for (int i = 0; i < tenants.getTotal(); i++) {
					Tenant t = tenants.getTenant(i);
					t.print();

				}
				if (tenants.isEmpty()) {
					System.out.println("There are currently no tenants!");
					break;
				}

				break;
			case 3:
				// Add a payment
				System.out.print("Enter tenant room number: ");
				room = scanner.nextInt();
				Tenant tenant = tenants.search(room);
				if (tenant == null) {
					System.out.println("Tenant not found!");
					break;
				}
				System.out.print("Enter payment month: ");
				String month = scanner.next();
				System.out.print("Enter payment amount: ");
				double amount = scanner.nextDouble();
				tenant.makePayment(new Payment(month, amount));
				break;

			case 4:
				// List all payments
				System.out.print("Enter tenant room number: ");
				int tenantRoomNumber = scanner.nextInt();
				Tenant paymentListTenant = tenants.search(tenantRoomNumber);
				if (paymentListTenant == null) {
					System.out.println("Error: Tenant not found.");
				} else {
					PaymentList tenantPayments = paymentListTenant.getPayments();
					if (tenantPayments.isEmpty()) {
						System.out.println("No payments found.");
					} else {
						for (int i = 0; i < tenantPayments.getTotal(); i++) {
							Payment payment = tenantPayments.getPayment(i);
							System.out.println(payment.toString());
						}
					}
				}
				break;
				
			case 5:
				// remove tenant
				//this code only removes tenants from room 2 down!
				System.out.print("Enter tenant room number: ");
                room = scanner.nextInt();
                tenants.remove(room);
                System.out.println("Tenant has been removed");
                break;
                
                //tried to use this code to remove the tenant in room 1 but i couldnt!
//				System.out.print("Enter tenant room number: ");
//				int tenantRoom = scanner.nextInt();
//				Tenant tenantToRemove = tenants.search(tenantRoom);
//				if (tenantToRemove == null) {
//					System.out.println("Error: Tenant not found.");
//				} else {
//					if (tenants.remove(tenantToRemove)) {
//						System.out.println("Tenant removed successfully.");
//						tenants.setTotal(tenants.getTotal() - 1);
//					} else {
//						System.out.println("Error: Could not remove tenant.");
//					}
//				}
//				break;
				
			case 6:
				// Get number of payments made (per tenant)
				System.out.print("Enter tenant room number: ");
				room = scanner.nextInt();
				tenant = tenants.search(room);
				if (tenant == null) {
					System.out.println("Tenant not found!");
					break;
				}
				System.out.println("Number of payments made: " + tenant.getPayments().getTotal());
				break;
			case 7:
				// Get total payments made (per tenant)
				System.out.print("Enter tenant room number: ");
				int tenantTotalPaymentsRoom = scanner.nextInt();
				Tenant tenantTotalPayments = tenants.search(tenantTotalPaymentsRoom);
				if (tenantTotalPayments == null) {
					System.out.println("Error: Tenant not found.");
				} else {
					PaymentList tenantPayments = tenantTotalPayments.getPayments();
					double totalAmount = tenantPayments.calculateTotalPaid();
					System.out.println("Total payments made: $" + totalAmount);
				}
				break;
			case 8:
				// Get total Payments made for the entire hostel
				double totalPayments = 0;
				for (int i = 0; i < tenants.getTotal(); i++) {
					Tenant t = tenants.getTenant(i);
					PaymentList allPayments = t.getPayments();
					for (int j = 0; j < allPayments.getTotal(); j++) {
						Payment p = allPayments.getPayment(j);
						totalPayments += p.getAmount();
					}
				}
				System.out.println("Total payments made for the hostel: " + totalPayments);
				break;

			}
		}
	}
}
