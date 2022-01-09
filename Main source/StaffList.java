
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StaffList implements ListInterface {

	public Staff[] staff = new Staff[1];
	private int n;
	Scanner sc = new Scanner(System.in);

	public StaffList() {
	}

	public StaffList(Staff[] staff, int n) {
		this.staff = staff;
		this.n = n;
	}

	public StaffList(StaffList st) {
		staff = st.staff;
		n = st.n;
	}

	public Staff[] getStaffList() {
		return staff;
	}

	public void setStaffList(Staff[] staff) {
		this.staff = staff;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

//	public void input() {
//		System.out.println("How many Staff you want to have ?");
//		n = sc.nextInt();
//		staff = new Staff[n];
//		for (int i = 0; i < n; i++) {
//			staff[i] = new Staff();
//			staff[i].input();
//		}
//	}

	public void output() {
		System.out.println("=============================Danh sach nhan vien============================= ");
		System.out.println("|-------------|-------------|--------------|--------------|------------------|");
		System.out.println("|Ma nhan vien |Ho nhan vien |Ten nhan vien |So dien thoai |Can cuoc cong dan |");
		System.out.println("|-------------|-------------|--------------|--------------|------------------|");
		for (int i = 0; i < staff.length; i++) {
			staff[i].output();
		}
	}

	public void add() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Them chuyen bay-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc.nextLine());
		int t = 0;
		n = staff.length;
		staff = Arrays.copyOf(staff, n + k);
		for (int i = n; i < n + k; i++) {
			sc = new Scanner(System.in);
			System.out.println("Nhap ma nhan vien muon them");
			String ma_nv = sc.nextLine();
			do {
				t = 0;
				for (int j = 0; j < n; j++) {
					if (staff[i].getStaffId().equals(ma_nv)) {
						System.out.println("Ma nhan vien da bi trung: ");
						t = 1;
					}
				}
				if (t == 1) {
					System.out.println("Nhap lai ma nhan vien: ");
				}
			} while (t == 1);

			if (t == 0) {
				sc = new Scanner(System.in);
				System.out.print("Nhap ho nhan vien: ");
				String surname = sc.nextLine();
				System.out.print("Nhap ten nhan vien: ");
				String name = sc.nextLine();
				System.out.print("Nhap so dien thoai nhan vien: ");
				String phone = sc.nextLine();
				System.out.print("Nhap can cuoc cong dan nhan vien: ");
				String identy = sc.nextLine();
				staff[i] = new Staff(ma_nv, surname, name, phone, identy);
			}
		}

		n = n + k;
		System.out.println("Them nhan vien thanh cong");
		System.out.println("-----------***-----------");
	}

	public Staff addStaff(Staff f) {
		for (int i = 0; i < staff.length; i++) {
			if (f.getStaffId().equals(staff[i].getStaffId())) {
				System.out.println("Your Staff Id is already used !");
				return null;
			}
		}
		n = staff.length;
		staff = Arrays.copyOf(staff, n + 1);
		staff[n] = new Staff(f);
		n++;
		return f;
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("||--------Chon thao tac tim kiem--------||");
		System.out.println("||1. Tim kiem theo ma nhan vien         ||");
		System.out.println("||2. Tim kiem theo ho nhan vien         ||");
		System.out.println("||3. Tim kiem theo ten nhan vien        ||");
		System.out.println("||4. Tim kiem theo so dien thoai        ||");
		System.out.println("||5. Tim kiem theo can cuoc cong dan    ||");
		System.out.println("||------------------***-----------------||");
		System.out.print("Nhap lua chon cua ban: ");
		int c = Integer.parseInt(sc.nextLine());
		switch (c) {
			case 1: {
				// chuyen bay
				sc = new Scanner(System.in);
				System.out.print("Nhap ma nhan vien can tim: ");
				String f_id = sc.nextLine();
				System.out.println(
						"===================================================Danh sach nhan vien===============================================");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				System.out.println("|Ma nhan vien | Ho nhan vien| Ten nhan vien| So dien thoai|Can cuoc cong dan|");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				for (int i = 0; i < n; i++) {
					if (staff[i].getStaffId().equals(f_id))
						staff[i].output();
					break;
				}
				break;
			}

			case 2: {
				// chuyen bay
				sc = new Scanner(System.in);
				System.out.print("Nhap ho nhan vien can tim: ");
				String f_id = sc.nextLine();
				System.out.println(
						"===================================================Danh sach nhan vien===============================================");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				System.out.println("|Ma nhan vien | Ho nhan vien| Ten nhan vien| So dien thoai|Can cuoc cong dan|");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				for (int i = 0; i < n; i++) {
					if (staff[i].getStaffSurName().equals(f_id))
						staff[i].output();

				}
				break;
			}

			case 3: {
				// chuyen bay
				sc = new Scanner(System.in);
				System.out.print("Nhap ten nhan vien can tim: ");
				String f_id = sc.nextLine();
				System.out.println(
						"===================================================Danh sach nhan vien===============================================");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				System.out.println("|Ma nhan vien | Ho nhan vien| Ten nhan vien| So dien thoai|Can cuoc cong dan|");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				for (int i = 0; i < n; i++) {
					if (staff[i].getStaffName().equals(f_id))
						staff[i].output();

				}
				break;
			}

			case 4: {
				// chuyen bay
				sc = new Scanner(System.in);
				System.out.print("Nhap so dien thoai nhan vien can tim: ");
				String f_id = sc.nextLine();
				System.out.println(
						"===================================================Danh sach nhan vien===============================================");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				System.out.println("|Ma nhan vien | Ho nhan vien| Ten nhan vien| So dien thoai|Can cuoc cong dan|");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				for (int i = 0; i < n; i++) {
					if (staff[i].getPhoneNumber().equals(f_id))
						staff[i].output();
				}
				break;
			}

			case 5: {
				// chuyen bay
				sc = new Scanner(System.in);
				System.out.print("Nhap can cuoc nhan vien can tim: ");
				String f_id = sc.nextLine();
				System.out.println(
						"===================================================Danh sach nhan vien===============================================");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				System.out.println("|Ma nhan vien | Ho nhan vien| Ten nhan vien| So dien thoai|Can cuoc cong dan|");
				System.out.println("|-------------|-------------|--------------|--------------|-----------------|");
				for (int i = 0; i < n; i++) {
					if (staff[i].getIdentityCart().equals(f_id))
						staff[i].output();
				}
				break;
			}
		}
	}

	public Staff searchStaffById(String StaffId) {
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffId().indexOf(StaffId) != -1) {
				return staff[i];
			}
		}
		return null;
	}

	public Staff[] searchStaffBystaffSurName(String staffName) {
		Staff[] f = new Staff[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffSurName().indexOf(staffName) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Staff(staff[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Staff[] searchStaffBystaffName(String staffName) {
		Staff[] f = new Staff[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffName().indexOf(staffName) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Staff(staff[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Staff[] searchStaffByphoneNumber(String phoneNumber) {
		Staff[] f = new Staff[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getPhoneNumber().indexOf(phoneNumber) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Staff(staff[i]);
				count++;
			}
		}
		if (flag)
			return f;
		return null;
	}

	public Staff[] searchStaffByidentityCart(String identityCart) {
		Staff[] f = new Staff[0];
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getIdentityCart().indexOf(identityCart) != -1) {
				flag = true;
				f = Arrays.copyOf(f, count + 1);
				f[count] = new Staff(staff[i]);
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
		System.out.println("||1. Xoa nhan vien theo ma nhan vien                ||");
		System.out.println("||2. Xoa nhan vien theo ho                          ||");
		System.out.println("||3. Xoa nhan vien theo ten                         ||");
		System.out.println("||4. Xoa nhan vien theo so dien thoai               ||");
		System.out.println("||5. Xoa nhan vien theo can cuoc cong dan           ||");
		System.out.println("||------------------------***-----------------------||");
		System.out.print("Nhap lua chon: ");
		int c = Integer.parseInt(sc.nextLine());
		switch (c) {
		case 1: {
			sc = new Scanner(System.in);
			System.out.print("Ban chac muon xoa chuyen bay khong?[y/n]: ");
			String k = sc.nextLine();
			switch (k) {
				case "y": {
					sc = new Scanner(System.in);
					System.out.println("Nhap ma nhan vien can xoa: ");
					String f_id = sc.nextLine();
					removeStaffById(f_id);
					break;

				}
				case "n": {
					System.out.println("Thoat xoa nhan vien!");
					break;
				}
			}
			break;
		}

		case 2: {
			sc = new Scanner(System.in);
			System.out.print("Ban chac muon xoa nhan vien theo ho?[y/n]: ");
			String k = sc.nextLine();
			switch (k) {
				case "y": {
					sc = new Scanner(System.in);
					System.out.println("Nhap ho nhan vien can xoa: ");
					String f_id = sc.nextLine();
					removeStaffBySurname(f_id);
					break;

				}
				case "n": {
					System.out.println("Thoat xoa nhan vien!");
					break;
				}
			}
			break;
		}

		case 3: {
			sc = new Scanner(System.in);
			System.out.print("Ban chac muon xoa nhan vien theo ho khong?[y/n]: ");
			String k = sc.nextLine();
			switch (k) {
				case "y": {
					sc = new Scanner(System.in);
					System.out.println("Nhap ho nhan vien can xoa: ");
					String f_id = sc.nextLine();
					removeStaffByName(f_id);
					break;

				}
				case "n": {
					System.out.println("Thoat xoa nhan vien!");
					break;
				}
			}
			break;
		}

		case 4: {
			sc = new Scanner(System.in);
			System.out.print("Ban chac muon xoa nhan vien theo so dien thoai khong?[y/n]: ");
			String k = sc.nextLine();
			switch (k) {
				case "y": {
					sc = new Scanner(System.in);
					System.out.println("Nhap so dien thoai nhan vien can xoa: ");
					String f_id = sc.nextLine();
					removeStaffByPhone(f_id);
					break;

				}
				case "n": {
					System.out.println("Thoat xoa nhan vien!");
					break;
				}
			}
			break;
		}

		case 5: {
			sc = new Scanner(System.in);
			System.out.print("Ban chac muon xoa nhan vien theo can cuoc cong dan khong?[y/n]: ");
			String k = sc.nextLine();
			switch (k) {
				case "y": {
					sc = new Scanner(System.in);
					System.out.println("Nhap can cuoc cong dan nhan can xoa: ");
					String f_id = sc.nextLine();
					removeStaffByIdenty(f_id);
					break;

				}
				case "n": {
					System.out.println("Thoat xoa nhan vien!");
					break;
				}
			}
			break;
		}
		}
	}

	public void removeStaffById(String StaffId) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffId().indexOf(StaffId) != -1) {
				flag = true;
				for (int j = i; j < staff.length - 1; j++) {
					staff[j] = staff[j + 1];
				}
				staff = Arrays.copyOf(staff, n - 1);
				n--;
			}
		}
		if (flag)
			System.out.println("Da xoa nhan vien!");
		System.out.print("Khong xoa nhan vien!");
	}

	public void removeStaffBySurname(String StaffId) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffSurName().equals(StaffId)) {
				flag = true;
				for (int j = i; j < staff.length - 1; j++) {
					staff[j] = staff[j + 1];
				}
				staff = Arrays.copyOf(staff, n - 1);
				n--;
			}
		}
		if (flag)
			System.out.println("Da xoa nhan vien!");
		System.out.print("Khong xoa nhan vien!");
	}

	public void removeStaffByName(String StaffId) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffName().equals(StaffId)) {
				flag = true;
				for (int j = i; j < staff.length - 1; j++) {
					staff[j] = staff[j + 1];
				}
				staff = Arrays.copyOf(staff, n - 1);
				n--;
			}
		}
		if (flag)
			System.out.println("Da xoa nhan vien!");
		System.out.print("Khong xoa nhan vien!");
	}

	public void removeStaffByPhone(String StaffId) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getPhoneNumber().equals(StaffId)) {
				flag = true;
				for (int j = i; j < staff.length - 1; j++) {
					staff[j] = staff[j + 1];
				}
				staff = Arrays.copyOf(staff, n - 1);
				n--;
			}
		}
		if (flag)
			System.out.println("Da xoa nhan vien!");
		System.out.print("Khong xoa nhan vien!");
	}

	public void removeStaffByIdenty(String StaffId) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getIdentityCart().equals(StaffId)) {
				flag = true;
				for (int j = i; j < staff.length - 1; j++) {
					staff[j] = staff[j + 1];
				}
				staff = Arrays.copyOf(staff, n - 1);
				n--;
			}
		}
		if (flag)
			System.out.println("Da xoa nhan vien!");
		System.out.print("Khong xoa nhan vien!");
	}

	public void removeStaff(Staff f) {
		boolean flag = false;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getStaffId().indexOf(f.getStaffId()) != -1) {
				flag = true;
				for (int j = i; j < staff.length; j++) {
					staff[j] = staff[j + 1];
				}
			}
		}
		staff = Arrays.copyOf(staff, n - 1);
		n--;
	}

	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma nhan vien can sua: ");
		String f_id = sc.nextLine();
		int t;
		for (int i = 0; i < staff.length; i++) {
			t = 0;
			do {
				if (f_id.equals(staff[i].getStaffId())) {
					t = 1;
					System.out.println("||---------Chon thao tac sua--------||");
					System.out.println("||1. Sua ma nhan vien               ||");
					System.out.println("||2. Sua ho nhan vien               ||");
					System.out.println("||3. Sua ten nhan vien              ||");
					System.out.println("||4. Sua so dien thoai              ||");
					System.out.println("||5. Sua can cuoc cong dan          ||");
					System.out.println("||----------------***---------------||");
					System.out.print("Nhap lua chon: ");
					int c = Integer.parseInt(sc.nextLine());
					switch (c) {
					case 1: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ma nhan vien moi: ");
						String nf_id = sc.nextLine();

						staff[i].setStaffId(nf_id);

						System.out.println("Da sua ma nhan vien!");
						break;
					}
					case 2: {
						sc = new Scanner(System.in);

						System.out.println("Nhap ho nhan vien moi: ");
						String nr_id = sc.nextLine();

						staff[i].setStaffSurName(nr_id);

						System.out.println("Da sua ho nhan vien!");
						break;

					}
					case 3: {
						sc = new Scanner(System.in);
						System.out.println("Nhap ten nhan vien moi: ");
						String nfr_id = sc.nextLine();

						staff[i].setStaffName(nfr_id);

						System.out.println("Da sua ten nhan vien!");
						break;
					}
					case 4: {
						sc = new Scanner(System.in);
						System.out.println("Nhap so dien thoai moi nhan vien: ");
						String np_id = sc.nextLine();

						staff[i].setPhoneNumber(np_id);

						System.out.println("Da sua so dien thoai nhan vien!");
						break;
					}
					case 5: {
						sc = new Scanner(System.in);
						System.out.println("Nhap can cuoc cong dan moi: ");
						String ntod = sc.nextLine();

						staff[i].setIdentityCart(ntod);

						System.out.println("Da sua can cuoc cong dan!");
						break;
					}

					}
				} else {
					System.out.println("Ban da nhap sai ma nhan vien, vui long nhap lai!");
				}
			} while (t == 0);
		}
	}

	public void addElement(Staff fl) {
		n = staff.length;
		staff = Arrays.copyOf(staff, n + 1);
		staff[n] = new Staff(fl);
	}

	public String tableOutput(String m, int n) {
		String s = "";
		for (int i = 0; i < n - m.length(); i++) {
			s = s + " ";
		}
		return s;
	}

}
