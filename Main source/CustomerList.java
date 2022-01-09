

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerList implements ListInterface{
	public Customer[] customer = new Customer[0];
	private int n;
	Scanner sc = new Scanner(System.in);
	public CustomerList() {
	}

	public CustomerList(Customer[] customer, int n) {
		this.customer = customer;
		this.n = n;
	}

	public CustomerList(CustomerList st) {
		customer = st.customer;
		n = st.n;
	}

	public Customer[] getCustomer() {
		return customer;
	}

	public void setCustomer(Customer[] customer) {
		this.customer = customer;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

//	public void input() {
//		System.out.println("How many Customer you want to have ?");
//		n = sc.nextInt();
//		customer = new Customer[n];
//		for (int i = 0; i < n; i++) {
//			customer[i] = new Customer();
//			System.out.println("Customer " + (i + 1) + ": ");
//			customer[i].input();
//		}
//	}

	public void output() {
        System.out.println("===================================Danh sach khach hang====================================");
		System.out.println("|-------------|-------------|--------------|--------------|------------------|------------|");
		System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan | Gioi tinh  |");
		System.out.println("|-------------|-------------|--------------|--------------|------------------|------------|");
        for (int i = 0; i < customer.length; i++) {
        	customer[i].output();
        }
    }


	
	 public void add() {
	        Scanner sc = new Scanner(System.in);
			System.out.println("-----Them khach hang-----");
			System.out.print("Nhap so luong muon them: ");
			int k = Integer.parseInt(sc.nextLine());
			int t = 0;

	        //Xin cap phat them
	        n = customer.length;
	        customer = Arrays.copyOf(customer, n + k);
	        // System.out.println("Check!");
	        for(int i = n; i < n + k; i++) {
	            sc = new Scanner(System.in);
	            System.out.print("Nhap ma khach hang: ");
	            String kh_id = sc.nextLine();
	            do {
	                t = 0;
	                for(int j = 0; j < n; j++) {
	                    if(kh_id.equals(customer[j].getCustomerId())) {
	                        System.out.println("Ma khach hang da bi trung!");
	                        t = 1;
	                    }
	                } 
	                if(t == 1) {
	                    System.out.print("Nhap lai ma khach hang: ");
	                    kh_id = sc.nextLine();
	                }
	            } while(t == 1);
	            
	            System.out.print("Nhap can cuoc cong dan: ");
                String identy = sc.nextLine();
	            do {
	                t = 0;
	                for(int j = 0; j < n; j++) {
	                    if(identy.equals(customer[j].getIdentityCart() )) {
	                        System.out.println("Can cuoc cong dan bi trung!");
	                        t = 1;
	                    }
	                } 
	                if(t == 1) {
	                    System.out.print("Nhap lai can cuoc cong dan: ");
	                    identy = sc.nextLine();
	                }
	            } while(t == 1);
	            if(t == 0) {
	                sc = new Scanner(System.in);
	                System.out.print("Nhap ho khach hang : ");
	                String surname = sc.nextLine();
	                System.out.print("Nhap ten khach hang: ");
	                String name = sc.nextLine();
	                System.out.print("Nhap so dien thoai khach hang: ");
	                String phone = sc.nextLine();
	                
	                int s;
	                do {
	                    System.out.println("Nhap gioi tinh : \n 0: Boy \n 1: Girl \n");
	                    s = Integer.parseInt(sc.nextLine());
	                    if(s <= 0 || s >= 1) {
	                        System.out.println("Ban da nhap sai trang thai! (gia tri phai nam trong khoang [0, 1])");
	                    }
	                } while(s >= 0 && s <= 1);
	               
	                customer[i] = new Customer(kh_id, surname, name,phone, identy, s);

	            }
	        }
	        n = n + k;
	        // writeFile();
	        System.out.println("Them khach hang thanh cong");
	        System.out.println("-----------***-----------");
	    }



	public Customer addCustomer(Customer f) {
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerId().equals(f.getCustomerId())) {
				System.out.println("Your Customer Id is already used!");
				return null;
			}
		}
		n = customer.length;
		customer = Arrays.copyOf(customer, n + 1);
		customer[n] = new Customer(f);
		n++;
		return f;
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		 System.out.println("||--------Chon thao tac tim kiem--------||");
	        System.out.println("||1. Tim kiem theo ma khach hang        ||");
	        System.out.println("||2. Tim kiem theo ho khach hang        ||");
	        System.out.println("||3. Tim kiem theo ten khach hang       ||");
	        System.out.println("||4. Tim kiem theo so dien thoai        ||");
	        System.out.println("||5. Tim kiem theo can cuoc cong dan    ||");
	        System.out.println("||6. Tim kiem theo gioi tinh            ||");
	        System.out.println("||------------------***-----------------||");
	        System.out.print("Nhap lua chon cua ban: ");
	        int c = Integer.parseInt(sc.nextLine());
	        switch(c) {
	        case 1:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap ma khach hang can tim: ");
	        	String kh_id = sc.nextLine();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh      |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getCustomerId().equals(kh_id)) {
                		customer[i].output();
                	}
                }
				break;
	        }
	        
	        case 2:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap ho khach hang can tim: ");
	        	String surname = sc.nextLine();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh      |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getCustomersurName().equals(surname)) {
                		customer[i].output();
                		
                	}
                }
				break;	
	        }
	        
	        
	        case 3:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap ten khach hang can tim: ");
	        	String name = sc.nextLine();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh      |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getCustomerName().equals(name)) {
                		customer[i].output();
                		
                	}
                }
				break;	
	        }
	        
	        
	        case 4:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap so dien thoai khach hang can tim: ");
	        	String phone = sc.nextLine();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh------|");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getPhoneNumber().equals(phone)) {
                		customer[i].output();
                	}
                }
				break;
	        }
	        
	        
	        case 5:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap can cuoc cong dan khach hang can tim: ");
	        	String identy = sc.nextLine();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh      |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getIdentityCart().equals(identy)) {
                		customer[i].output();
                	}
                }
				break;
	        }
	        
	        
	        case 6:
	        {
	        	sc = new Scanner(System.in);
	        	System.out.println("Nhap gioi tinh khach hang can tim: ");
	        	int sex = sc.nextInt();
	        	System.out.println("===================================================Danh sach khach hang===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-----------------|---------------|");
                System.out.println("|Ma khach hang|Ho khach hang|Ten khach hang|So dien thoai |Can cuoc cong dan|Gioi tinh      |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------- --|---------------|");
                for(int i = 0 ; i < n ; i++) {
                	if(customer[i].getSex() == sex) {
                		customer[i].output();
                	}
                }
				break;
	        }
	     }
	}
	
	public Customer[] searchCustomerByCustomerSurName(String CustomerName) {
		Customer[] f = new Customer[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomersurName().indexOf(CustomerName) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Customer(customer[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Customer[] searchCustomerByCustomerName(String CustomerName) {
		Customer[] f = new Customer[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerName().indexOf(CustomerName) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Customer(customer[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Customer[] searchCustomerByphoneNumber(String phoneNumber) {
		Customer[] f = new Customer[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getPhoneNumber().indexOf(phoneNumber) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Customer(customer[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Customer[] searchCustomerByidentityCart(String identityCart) {
		Customer[] f = new Customer[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getIdentityCart().indexOf(identityCart) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Customer(customer[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public void remove() {
		Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa khach hang theo ma khach hang              ||");
        System.out.println("||2. Xoa khach hang theo so dien thoai              ||");
        System.out.println("||3. Xoa khach hang theo can cuoc cong dan          ||");
        System.out.println("||4. Xoa khach hang theo ten                        ||");
        System.out.println("||5. Xoa khach hang theo ho                         ||");
        System.out.println("||6. Xoa khach hang theo gioi tinh                  ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
			case 1:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang khong?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap ma khach hang can xoa: ");
						String f_id = sc.nextLine();
						removeCustomerById(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
			
			case 2:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang theo so dien thoai?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap so dien thoai khach hang can xoa: ");
						String f_id = sc.nextLine();
						removeCustomerByPhone(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
			
			case 3:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang theo can cuoc cong dan?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap can cuoc khach hang can xoa: ");
						String f_id = sc.nextLine();
						removeCustomerIdenty(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
			
			case 4:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang theo ten?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap ten khach hang can xoa: ");
						String f_id = sc.nextLine();
						removeCustomerName(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
			

			case 5:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang theo ho?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap ho khach hang can xoa: ");
						String f_id = sc.nextLine();
						removeCustomerSurname(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
			

			case 6:
			{
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa khach hang theo gioi tinh?[y/n]: ");
				String k = sc.nextLine();
				switch(k){
					case "y":
					{
						sc = new Scanner(System.in);
						System.out.println("Nhap gioi tinh khach hang can xoa: ");
						int f_id = sc.nextInt();
						removeCustomerSex(f_id);
						break;

					}
					case "n":
					{
						System.out.println("Thoat xoa khach hang!");
						break;
					}
				}
				break;
			}
        }
	}

	public void removeCustomerById(String CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerId().equals(CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
     			break;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}
	
	
	public void removeCustomerByPhone(String CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getPhoneNumber().equals(CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}
	
	
	public void removeCustomerIdenty(String CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getIdentityCart().equals(CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}
	
	public void removeCustomerSex(int CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getSex() == (CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}
	
	
	public void removeCustomerSurname(String CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomersurName().equals(CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}
	
	public void removeCustomerName(String CustomerId) {
		boolean flag = false;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerName().equals(CustomerId)) {
				flag = true;
				for (int j = i; j < customer.length - 1; j++) {
					customer[j] = customer[j + 1];
				}
				customer = Arrays.copyOf(customer, n - 1);
				n--;
			}	
		}
		if(flag) System.out.println("Da xoa khach hang!");
        System.out.print("Khong xoa khach hang!");
	}

	public void removeCustomer(Customer f) {
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerId().indexOf(f.getCustomerId()) != -1) {
				for (int j = i; j < customer.length; j++) {
					customer[j] = customer[j + 1];
				}
			}
		}
		customer = Arrays.copyOf(customer, n - 1);
		n--;
	}

	public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can sua: ");
        String f_id= sc.nextLine();
        int t;
        for(int i = 0; i < customer.length; i++){
            t = 0;
            do {
                if(f_id.equals(customer[i].getCustomerId()))
                {
                    t = 1;
                    System.out.println("||---------Chon thao tac sua-------- ||");
                    System.out.println("||1. Sua ma khach hang               ||");
                    System.out.println("||2. Sua ho khach hang               ||");
                    System.out.println("||3. Sua ten khach hang              ||");
                    System.out.println("||4. Sua so dien thoai               ||");
                    System.out.println("||5. Sua can cuoc cong dan           ||");
                    System.out.println("||6. Sua gioi tinh                   ||");
                    System.out.println("||----------------***--------------- ||");
                    System.out.print("Nhap lua chon: ");
                    int c = Integer.parseInt(sc.nextLine());
                    switch(c) {
                        case 1:
                        {
                            sc = new Scanner(System.in);
                            System.out.println("Nhap ma khach hang moi: ");
                            String  nf_id= sc.nextLine();
                            customer[i].setCustomerId(nf_id);
                            System.out.println("Da sua ma khach hang!");
                            break;
                        }
                        case 2:
                        {
                            sc = new Scanner(System.in);
                           
                            System.out.println("Nhap ho khach hang moi: ");
                            String nr_id= sc.nextLine();
                            customer[i].setCustomersurName(nr_id);
                            System.out.println("Da sua ho khach hang!");
                            break;
                           
                           
                        }
                        case 3:
                        {
                            sc = new Scanner(System.in);
                            System.out.println("Nhap ten khach hang moi: ");
                            String  nfr_id = sc.nextLine();
                            customer[i].setCustomerName(nfr_id);
                            System.out.println("Da sua ten khach hang!");
                            break;
                        }
                        case 4:
                        {
                            sc = new Scanner(System.in);
                            System.out.println("Nhap so dien thoai moi khach hang: ");
                            String np_id = sc.nextLine();
                            customer[i].setPhoneNumber(np_id);
                            System.out.println("Da sua so dien thoai khach hang!");
                            break;
                        }
                        case 5:
                        {
                            sc = new Scanner(System.in);
                            System.out.println("Nhap can cuoc cong dan moi: ");
                            String ntod = sc.nextLine();
                            customer[i].setIdentityCart(ntod);
                            System.out.println("Da sua can cuoc cong dan!");
                            break;
                        }
                        
                        case 6:
                        {
                            sc = new Scanner(System.in);
                            System.out.println("Nhap gioi tinh khach hang moi: ");
                            int ntod = sc.nextInt();
                            customer[i].setSex(ntod);
                            System.out.println("Da sua gioi tinh khach hang!");
                            break;
                        }
                        
                    }
                } else {
                    System.out.println("Ban da nhap sai ma khach hang, vui long nhap lai!");
                }
            }while(t == 0);
        }
    }

	public Customer searchCustomerById(String CustomerId) {
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].getCustomerId().indexOf(CustomerId) != -1) {
				return customer[i];
			}
		}
		return null;
	}

	
	public void addElement(Customer fl) {
        n = customer.length;  
        customer = Arrays.copyOf(customer, n + 1);
        customer[n] = new Customer(fl);   
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        return s;
    }
    
   
}
