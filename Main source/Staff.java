// package ThiHK1;
// package doan;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Staff extends Person { // NHAN VIEN
	// Attribute
	private String staffId; // ma nhan vien
	private String staffsurName; // hp nhan vien
	private String staffName; // ten nhan vien
	private String phoneNumber; // so dien thoai nhan vien
	private String identityCart ; // can cuoc cong dan

	public Staff() {

	}

	public Staff(String staffId, String staffsurName , String staffName, String phoneNumber, String identityCart) {
		this.staffId = staffId;
		this.staffsurName = staffsurName ;
		this.staffName = staffName;
		this.phoneNumber = phoneNumber;
		this.identityCart = identityCart;
	}

	public Staff(Staff s) {
		staffId = s.staffId;
		staffsurName = s.staffsurName;
		staffName = s.staffName;
		phoneNumber = s.phoneNumber;
		identityCart = s.identityCart;
	}

	public String getIdentityCart() {
		return identityCart;
	}

	public void setIdentityCart(String identityCart) {
		this.identityCart = identityCart;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffSurName() {
		return staffsurName;
	}
	
	public void setStaffSurName(String StaffSurName) {
		this.staffsurName = StaffSurName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	public String getStaffName() {
		return staffName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public  void ShowInfo() {
		
		output();
		System.out.println("\n");
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff ID: ");
		staffId = sc.nextLine();
		System.out.println("Enter Staff SurName: ");
		staffsurName = sc.nextLine();
		System.out.println("Enter Staff Name: ");
		staffName = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		phoneNumber = sc.nextLine();
		System.out.println("Enter Identity Cart: ");
		identityCart = sc.nextLine();
		
	}

	public void output() {
		System.out.println(
				"|" + staffId + tableOutput(staffId, 13) + staffsurName  + tableOutput(staffsurName , 13)
						+ staffName + tableOutput(staffName, 14)
                        + phoneNumber + tableOutput(phoneNumber, 14)
                    	+ identityCart + tableOutput(identityCart, 18));
		
//		System.out.println("|-------------|-------------|--------------|--------------|------------------|");

	}

	
	
	 public void writeFile() throws IOException {
	        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("Staff.txt", Boolean.TRUE));
	        outStream.writeUTF(staffId);
	        outStream.writeUTF(staffName);
	        outStream.writeUTF(staffsurName);
	        outStream.writeUTF(phoneNumber);
	        outStream.writeUTF(identityCart);
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

