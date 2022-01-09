// package doantxt;
// package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Bill { // HOA DON
	// Attribute
	private String billId; // ma hoa don
	private String billDate; // ngay hoa don
	private String staffId; // ma nhanh vien
	private String clientId; // ma khach hang
	private float billTax; // thue hoa don
	private float billSum; // thanh tien
	
	public Bill() {
		
	}

	public Bill(String billId, String billDate, String staffId, String clientId, float billTax, float billSum) {
		this.billId = billId;
		this.billDate = billDate;
		this.staffId = staffId;
		this.clientId = clientId;
		this.billTax = billTax;
		this.billSum = billSum;
	}
	
	
	public Bill(Bill b) {
		billId = b.billId;
		billDate = b.billDate;
		staffId = b.staffId;
		clientId = b.clientId;
		billTax = b.billTax;
		billSum = b.billSum;
		
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public float getBillTax() {
		return billTax;
	}

	public void setBillTax(float billTax) {
		this.billTax = billTax;
	}

	public float getBillSum() {
		return billSum;
	}

	public void setBillSum(float billSum) {
		this.billSum = billSum;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bill ID: ");
		billId = sc.nextLine();
		System.out.println("Enter Staff ID: ");
		staffId = sc.nextLine();
		System.out.println("Enter Client ID: ");
		clientId = sc.nextLine();
		System.out.println("Enter Bill Date: ");
		billDate = sc.nextLine();
		System.out.println("Enter Bill Tax: ");
		billTax = sc.nextFloat();
		System.out.println("Enter Bill Sum: ");
		billSum = sc.nextFloat();
		
	}

		 public void output() {
		        System.out.print("|"+billId+tableOutput(billId, 13)+
		        		billDate+tableOutput(billDate , 13)+
		        		staffId+tableOutput(staffId, 14)+
		        		clientId+tableOutput(clientId, 14));

		        System.out.println(billTax +tableOutput(Float.toString(billTax), 13)+
		        		billSum+tableOutput(Float.toString(billSum), 12));
		        
		        System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|");
		                    
	}
	
	
	public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("Bill.txt", Boolean.TRUE));
        outStream.writeUTF(staffId);
        outStream.writeUTF(billId);
        outStream.writeUTF(clientId);
        outStream.writeUTF(billDate);
        outStream.writeFloat(billTax);
        outStream.writeFloat(billSum);
        outStream.close();
    }
 
	 public String tableOutput(String m, int n) {
	        String s = "";
	        for(int i = 0; i < n-m.length(); i++) {
	            s = s + " ";
	        }
	        s = s + "|";
	        return s;
	    }


}
