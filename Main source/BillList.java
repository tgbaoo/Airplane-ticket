// package doantxt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BillList implements ListInterface {
	public Bill[] bill = new Bill[0];
	private int n;
	Scanner sc = new Scanner(System.in);

	public BillList() {
	}

	public BillList(Bill[] bill, int n) {
		this.bill = bill;
		this.n = n;
	}

	public BillList(BillList st) {
		bill = st.bill;
		n = st.n;
	}

	public Bill[] getBillList() {
		return bill;
	}

	public void setBillList(Bill[] bill) {
		this.bill = bill;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

//	public void input() {
//		System.out.println("How many Bill you want to have ?");
//		n = sc.nextInt();
//		bill = new Bill[n];
//		for (int i = 0; i < n; i++) {
//			bill[i] = new Bill();
//			bill[i].input();
//		}
//	}

	public void output() {
		System.out.println("=============================Danh sach hoa don========================================");
		System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|");
		System.out.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
		System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|");
		for (int i = 0; i < bill.length; i++) {
			bill[i].output();
		}
	}

	public void add() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Them hoa don-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc.nextLine());
		int t = 0;

		// Xin cap phat them
		n = bill.length;
		bill = Arrays.copyOf(bill, n + k);
		// System.out.println("Check!");
		for (int i = n; i < n + k; i++) {
			sc = new Scanner(System.in);
			System.out.print("Nhap ma hoa don: ");
			String f_id = sc.nextLine();
			do {
				t = 0;
				for (int j = 0; j < n; j++) {
					if (f_id.equals(bill[j].getBillId())) {
						System.out.println("Ma hoa don da bi trung!");
						t = 1;
					}
				}
				if (t == 1) {
					System.out.print("Nhap lai ma hoa don: ");
					f_id = sc.nextLine();
				}
			} while (t == 1);
			if (t == 0) {
				sc = new Scanner(System.in);
				System.out.print("Nhap ngay hoa don ");
				String fr_id = sc.nextLine();
				System.out.print("Nhap ma nhan vien: ");
				String ap_id = sc.nextLine();
				System.out.print("Nhap ma khach hang: ");
				String tod = sc.nextLine();
				System.out.print("Nhap thue hoa don: ");
				float ld = sc.nextFloat();
				System.out.print("Nhap thanh tien hoa don: ");
				float ld2 = sc.nextFloat();
				bill[i] = new Bill(f_id, fr_id, ap_id, tod, ld, ld2);

			}
		}
		n = n + k;
		// writeFile();
		System.out.println("Them hoa don thanh cong");
		System.out.println("-----------***-----------");
	}

	public Bill addBill(Bill f) {
		for (int i = 0; i < bill.length; i++) {
			if (f.getBillId().equals(bill[i].getBillId())) {
				System.out.println("Your bill Id is already used !");
				return null;
			}
		}
		n = bill.length;
		bill = Arrays.copyOf(bill, n + 1);
		bill[n] = new Bill();
		bill[n].input();
		n++;
		return f;
	}

	// ------------------------------SEARCH-------------------------------------
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("||--------Chon thao tac tim kiem--------||");
		System.out.println("||1. Tim kiem theo ma hoa don           ||");
		System.out.println("||2. Tim kiem theo ngay hoa don         ||");
		System.out.println("||3. Tim kiem theo ma nhan vien         ||");
		System.out.println("||4. Tim kiem theo ma khach hang        ||");
		System.out.println("||5. Tim kiem theo thue hoa don         ||");
		System.out.println("||6. Tim kiem theo thanh tien           ||");
		System.out.println("||------------------***-----------------||");
		System.out.print("Nhap lua chon cua ban: ");
		int c = Integer.parseInt(sc.nextLine());
		switch (c) {
		case 1: {
			// id
			sc = new Scanner(System.in);
			System.out.print("Nhap ma hoa don can tim: ");
			String f_id = sc.nextLine();
			System.out.println("==================================Danh sach hoa don===================================");
			System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getBillId().equals(f_id))
					bill[i].output();
			}
			break;
		}
		case 2: {
			// ngay
			sc = new Scanner(System.in);
			System.out.print("Nhap ngay hoa don can tim: ");
			String fr_id = sc.nextLine();
			System.out
					.println("=============================Danh sach hoa don========================================");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out
					.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getBillDate().equals(fr_id))
					bill[i].output();
			}
			break;
		}
		case 3: {
			// ma nhan vien
			sc = new Scanner(System.in);
			System.out.print("Nhap ma nhan vien can tim: ");
			String ap_id = sc.nextLine();
			System.out
					.println("=============================Danh sach hoa don========================================");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out
					.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getClientId().equals(ap_id))
					bill[i].output();
			}
			break;
		}
		case 4: {
			// may khach hang
			sc = new Scanner(System.in);
			System.out.print("Nhap ma khach hang can tim: ");
			String tod = sc.nextLine();
			System.out
					.println("=============================Danh sach hoa don========================================");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out
					.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getStaffId().equals(tod))
					bill[i].output();
			}
			break;
		}
		case 5: {

			sc = new Scanner(System.in);
			System.out.print("Nhap thue hoa don can tim: ");
			float ld = sc.nextFloat();
			System.out
					.println("=============================Danh sach hoa don========================================");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out
					.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getBillTax() == (ld))
					bill[i].output();
			}
			break;
		}

		case 6: {

			sc = new Scanner(System.in);
			System.out.print("Nhap thanh tien hoa don can tim: ");
			float ld2 = sc.nextFloat();
			System.out
					.println("=============================Danh sach hoa don========================================");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			System.out
					.println("| Ma hoa don  | Ngay Hoa Don| Ma nhan vien | Ma khach hang|Thue hoa don | Thanh tien |");
			System.out
					.println("|-------------|-------------|--------------|--------------|-------------|------------|");
			for (int i = 0; i < n; i++) {
				if (bill[i].getBillSum() == (ld2))
					bill[i].output();
			}
			break;
		}
		}
	}
	// -----------------------------------END
	// SEARCH-----------------------------------------

	public Bill searchBillById(String BillId) {
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillId().equals(BillId)) {
				return bill[i];
			}
		}
		return null;
	}

	public Bill[] searchBillByBillDate(String BillDate) {
		Bill[] f = new Bill[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillDate().indexOf(BillDate) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Bill(bill[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Bill[] searchBillByStaffId(String StaffId) {
		Bill[] f = new Bill[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getStaffId().indexOf(StaffId) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Bill(bill[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Bill[] searchBillByClientId(String ClientId) {
		Bill[] f = new Bill[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getClientId().indexOf(ClientId) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Bill(bill[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	// ---------------------------------DELETE--------------------------------------------

	public void remove() {
		Scanner sc = new Scanner(System.in);
		System.out.println("||-----------------Chon thao tac xoa----------------||");
		System.out.println("||1. Xoa hoa don theo ma hoa don                    ||");
		System.out.println("||2. Xoa hoa don theo ngay hoa don                  ||");
		System.out.println("||3. Xoa chuyen bay theo ma nhan vien               ||");
		System.out.println("||4. Xoa chuyen bay theo ma khach hang              ||");
		System.out.println("||5. Xoa chuyen bay theo thue                       ||");
		System.out.println("||6. Xoa chuyen bay theo thanh tien                 ||");
		System.out.println("||------------------------***-----------------------||");
		System.out.print("Nhap lua chon: ");
		int c = Integer.parseInt(sc.nextLine());
		switch (c) {
			case 1: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don nay khong?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don can xoa: ");
						String f_id = sc.nextLine();
						removeBillById(f_id);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don!");
						break;
					}
				}
				break;
			}
			case 2: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don theo ngay hoa don nay khong?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ngay hoa don can xoa: ");
						String fr_id = sc.nextLine();
						removeBillByDate(fr_id);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don!");
						break;
					}
					
				}
				break;
			}
			case 3: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don theo ma nhan vien khong?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don can xoa theo ma nhan vien : ");
						String ap_id = sc.nextLine();
						removeBillByStaff(ap_id);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don !");
						break;
					}
				}
				break;
			}
			case 4: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don theo ma khach hang khong?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don can xoa theo khach hang: ");
						String tod = sc.nextLine();
						removeBillByClient(tod);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don!");
						break;
					}
				}
				break;
			}

			case 5: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don theo thue?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don can xoa theo thue: ");
						float ld = sc.nextFloat();
						removeBillByTax(ld);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don!");
						break;
					}
				}
				break;
			}

			case 6: {
				sc = new Scanner(System.in);
				System.out.print("Ban chac muon xoa hoa don theo thanh tien?[y/n]: ");
				String k = sc.nextLine();
				switch (k) {
					case "y": {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don can xoa theo thanh tien: ");
						float ld = sc.nextFloat();
						removeBillBySum(ld);
						break;

					}
					case "n": {
						System.out.println("Thoat xoa hoa don!");
						break;
					}
				}
				break;
			}
		}
	}

	public void removeBillById(String BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillId().equals(BillId)) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}
				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}

		}
		if (flag) {
			System.out.println("Da xoa hoa don!");
		} else {
			System.out.print("Khong xoa hoa don!");
		}
	}

	public void removeBillByDate(String BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillDate().equals(BillId)) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}

				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}

		}
		if (flag) System.out.println("Da xoa hoa don!");
			System.out.print("Khong xoa hoa don!");
	}

	public void removeBillByStaff(String BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getStaffId().equals(BillId)) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}

				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}

		}
		if (flag)
			System.out.println("Da xoa hoa don!");
		System.out.print("Khong xoa hoa don!");
	}

	public void removeBillByClient(String BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getClientId().equals(BillId)) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}
				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}

		}
		if (flag)
			System.out.println("Da xoa hoa don!");
		System.out.print("Khong xoa hoa don!");
	}

	public void removeBillByTax(float BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillTax() == BillId) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}

				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}

		}

		if (flag)
			System.out.println("Da xoa hoa don!");
		System.out.print("Khong xoa hoa don!");

	}

	public void removeBillBySum(float BillId) {
		boolean flag = false;
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillSum() == BillId) {
				flag = true;
				for (int j = i; j < bill.length - 1; j++) {
					bill[j] = bill[j + 1];
				}

				bill = Arrays.copyOf(bill, n - 1);
				n--;
			}
		}

		if (flag)
			System.out.println("Da xoa hoa don!");
		System.out.print("Khong xoa hoa don!");

	}

	public void removeBill(Bill f) {
		for (int i = 0; i < bill.length; i++) {
			if (bill[i].getBillId().indexOf(f.getBillId()) != -1) {
				for (int j = i; j < bill.length; j++) {
					bill[j] = bill[j + 1];
				}
			}
		}
		bill = Arrays.copyOf(bill, n - 1);
		n--;
	}

	// -----------------------------------END
	// DELETE-----------------------------------

	// -----------------------------EDIT------------------------------

	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma hoa don can sua: ");
		String f_id = sc.nextLine();
		int t;
		for (int i = 0; i < bill.length; i++) {
			t = 0;
			do {
				if (f_id.equals(bill[i].getBillId())) {
					t = 1;
					System.out.println("||---------Chon thao tac sua-------- ||");
					System.out.println("||1. Sua ma hoa don                  ||");
					System.out.println("||2. Sua ngay hoa don                ||");
					System.out.println("||3. Sua ma nhan vien                ||");
					System.out.println("||4. Sua ma khach hang               ||");
					System.out.println("||5. Sua thue hoa don                ||");
					System.out.println("||6. Sua thanh tien hoa don          ||");
					System.out.println("||----------------***--------------- ||");
					System.out.print("Nhap lua chon: ");
					int c = Integer.parseInt(sc.nextLine());
					switch (c) {
					case 1: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma hoa don moi: ");
						String nf_id = sc.nextLine();
						bill[i].setBillId(nf_id);
						System.out.println("Da sua ma hoa don!");
						break;
					}
					case 2: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ngay hoa don moi: ");
						String nr_id = sc.nextLine();
					    bill[i].setBillDate(nr_id);
						System.out.println("Da sua ngay hoa don!");
						break;

					}
					case 3: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma nhan vien moi: ");
						String nfr_id = sc.nextLine();
						bill[i].setStaffId(nfr_id);
						System.out.println("Da sua ma nhan vien!");
						break;
					}
					case 4: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma khach hang moi: ");
						String np_id = sc.nextLine();
						bill[i].setClientId(np_id);
						System.out.println("Da sua ma khach hang!");
						break;
					}
					case 5: {
						sc = new Scanner(System.in);
						System.out.println("Nhap thue hoa don moi: ");
						float ntod = sc.nextFloat();
						bill[i].setBillTax(ntod);
						System.out.println("Da sua thue hoa don!");
						break;
					}

					case 6: {
						sc = new Scanner(System.in);
						System.out.println("Nhap gioi tinh khach hang moi: ");
						float ntod = sc.nextFloat();
						bill[i].setBillSum(ntod);
						System.out.println("Da sua thanh tien hoa don!");
						break;
					}

					}
				} else {
					System.out.println("Ban da nhap sai ma hoa don , vui long nhap lai!");
				}
			} while (t == 0);
		}
	}

	public void addElement(Bill fl) {
		n = bill.length;
		bill = Arrays.copyOf(bill, n + 1);
		bill[n] = new Bill(fl);
	}

	public String tableOutput(String m, int n) {
		String s = "";
		for (int i = 0; i < n - m.length(); i++) {
			s = s + " ";
		}
		return s;
	}

// 	public void BillManager() {
// //        DSVemaybay dsve =new DSVemaybay();
// //        dsve.docDSVe();
// 		Scanner in = new Scanner(System.in);
// 		System.out.println("||===============Quan ly hoa don================||");
// 		System.out.println("||                                                 ||");
// 		System.out.println("||============Chon muc ban can thao tac============||");
// 		System.out.println("||1. Xem toan bo danh sach hoa don                 ||");
// 		System.out.println("||2. Xem chi tiet cua mot hoa don                  ||");
// 		System.out.println("||3. Them hoa don                                  ||");
// 		System.out.println("||4. Sua hoa don                                   ||");
// 		System.out.println("||5. Xoa hoa don                                   ||");
// 		System.out.println("||0. Quay ve menu chinh                            ||");
// 		System.out.println("||-------------------------------------------------||");
// 		System.out.println("");
// 		System.out.print("Nhap lua chon: ");
// 		int c = in.nextInt();
// 		switch (c) {
// 		case 1: {
// 			a.output();
// 			quaylai();
// 			BillManager();
// 			break;
// 		}
// 		case 2: {
// 			a.search();
// 			quaylai();
// 			BillManager();
// 			break;
// 		}
// 		case 3: {
// 			a.add();
// 			quaylai();
// 			BillManager();
// 			break;
// 		}
// 		case 4: {
// 			a.edit();
// 			quaylai();
// 			BillManager();
// 			break;
// 		}
// 		case 5: {
// 			a.remove();
// 			quaylai();
// 			BillManager();
// 			break;
// 		}
// 		case 0: {
// 			quayvemenuchinh();
// 			break;
// 		}
// 		}
// 	}

}

// -----------------------------END EDIT------------------------------
