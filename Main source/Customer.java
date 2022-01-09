// package doantxt;
// package doan;
// package ThiHK1;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Customer extends Person{ // KHACH HANG
	// Attribute
	private String customerId; // ma khach hang
	private String customersurName; // ho khach hang
	private String customerName; // ten khach hang
	private String phoneNumber; // so dien thoai khach hang
	private String identityCart; // can cuoc cong dan
	private int sex; // gioi tinh khach hang
    private int n ;
    
	public Customer() {

	}

	public Customer(String customerId, String customersurName, String customerName, String phoneNumber,
			String identityCart, int sex) {
		this.customerId = customerId;
		this.customersurName = customersurName;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.identityCart = identityCart;
		this.sex = sex;
	}

	public Customer(Customer c) {
		customerId = c.customerId;
		customersurName = c.customersurName;
		customerName = c.customerName;
		phoneNumber = c.phoneNumber;
		identityCart = c.identityCart;
		sex = c.sex;
	}
	public  void ShowInfo() {
		
		output();
		System.out.println("\n");
	}
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomersurName() {
		return customersurName;
	}

	public void setCustomersurName(String customersurName) {
		this.customersurName = customersurName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdentityCart() {
		return identityCart;
	}

	public void setIdentityCart(String identityCart) {
		this.identityCart = identityCart;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer ID: ");
		customerId = sc.nextLine();
		System.out.println("Enter Customer Surname: ");
		customersurName = sc.nextLine();
		System.out.println("Enter Customer Name: ");
		customerName = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		phoneNumber = sc.nextLine();
		System.out.println("Enter Identity Cart: ");
		identityCart = sc.nextLine();
		System.out.println("Enter Sex: \n 0: Boy \n 1: Girl\n");
		sex = sc.nextInt();

	}

	public void output() {
		System.out.print("|" + customerId + tableOutput(customerId, 13) + customersurName + tableOutput(customersurName, 13)
						+ customerName + tableOutput(customerName, 14) + phoneNumber + tableOutput(phoneNumber, 14)
                        + identityCart + tableOutput(identityCart, 18));     
		
		if (sex == 0) {
			System.out.println("Boy" + tableOutput("Boy", 12));
		} else if (sex == 1) {
			System.out.println("" + "Girl" + tableOutput("Girl", 12));
		}
		
		System.out.println("|-------------|-------------|--------------|--------------|------------------|------------|");

	}

	public void writeFile() throws IOException {
		DataOutputStream outStream = new DataOutputStream(new FileOutputStream(
				"CustomerBin.txt", Boolean.TRUE));
		outStream.writeUTF(customerId);
		outStream.writeUTF(customersurName);
		outStream.writeUTF(customerName);
		outStream.writeUTF(phoneNumber);
		outStream.writeUTF(identityCart);
		outStream.writeInt(sex);
		outStream.close();
	}

	public String tableOutput(String m, int n) {
		String s = "";
		for (int i = 0; i < n - m.length(); i++) {
			s = s + " ";
		}
		s = s + "|";
		return s;
	}

}
