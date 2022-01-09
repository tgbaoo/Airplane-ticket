// package doantxt;
import java.io.*;
import java.util.*;

public class Menu {
	static String pathFlight = "..\\source\\flight.txt";
	static String pathFlightTicket = "..\\source\\flightTicket.txt";
	static String pathRoute = "..\\source\\route.txt";
	static String pathFlightRoute = "..\\source\\flightRoute.txt";
	static String pathAirport = "..\\source\\airport.txt";
	static String pathAirplane = "..\\source\\airplane.txt";
	static String pathAirplaneCompany = "..\\source\\airplaneCompany.txt";
	static String pathCustomerTicket = "..\\source\\customerTicket.txt";
	static String pathBill = "..\\source\\bill.txt";
	static String pathCustomer = "..\\source\\customer.txt";
	static String pathStaff = "..\\source\\staff.txt";


	static Person[] PerArr = new Person[0];
	static FlightList flightList = new FlightList();
	static FlightTicketList flightTicketList = new FlightTicketList();
	static RouteList routeList = new RouteList();
	static FlightRoutesList flightRoutesList = new FlightRoutesList();
	static AirportList airportList = new AirportList();
	static AirplaneList airplaneList = new AirplaneList();
	static AirplaneCompanyList airplaneCompanyList = new AirplaneCompanyList();
	static CustomerTicketList customerTicketList = new CustomerTicketList();
	static BillList billList = new BillList();
	static CustomerList customerList = new CustomerList();
	static StaffList staffList = new StaffList();	
	static RWFile rwFile = new RWFile();
	public Menu() {}
	public static void menuchinh() throws IOException 
	{
		
		// File

		rwFile.readFile(flightList, pathFlight);
		rwFile.readFile(flightTicketList, pathFlightTicket);
		rwFile.readFile(routeList, pathRoute);
		rwFile.readFile(flightRoutesList, pathFlightRoute);
		rwFile.readFile(airportList, pathAirport);
		rwFile.readFile(airplaneList, pathAirplane);
		rwFile.readFile(airplaneCompanyList, pathAirplaneCompany);
		rwFile.readFile(customerTicketList, pathCustomerTicket);
		rwFile.readFile(billList, pathBill);
		rwFile.readFile(customerList, pathCustomer);
		rwFile.readFile(staffList, pathStaff);


		Scanner in=new Scanner(System.in);
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||                                    |||||");
		System.out.println("|||||  Ung dung quan ly ban ve may bay   |||||");
		System.out.println("|||||                                    |||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("||==Menu He thong quan ly ban ve may bay===||");
		System.out.println("|| 1. Doc ghi file           	           ||");
		System.out.println("|| 2. Ban ve                        	   ||");
		System.out.println("|| 3. Quan ly Tuyen bay                    ||");
		System.out.println("|| 4. Quan ly Lo trinh                     ||");
		System.out.println("|| 5. Quan ly Hang may bay                 ||");
		System.out.println("|| 6. Quan ly May bay                      ||");
		System.out.println("|| 7. Quan ly Chuyen bay                   ||");
		System.out.println("|| 8. Quan ly Ve chuyen bay                ||");
		System.out.println("|| 9. Quan ly Ve khach hang                ||");
		System.out.println("|| 10. Quan ly Khach hang                  ||");
		System.out.println("|| 11. Quan ly Nhan vien                   ||");
		System.out.println("|| 12. Quan ly Hoa don                     ||");
		System.out.println("|| 13. Quan ly San bay                     ||");
		System.out.println("|| 14. Hien thi Nhan vien/Khach hang       ||");
		System.out.println("|| 0. Quit                                 ||");
		System.out.println("||=========================================||");
		System.out.println("");
		System.out.print("Nhap lua chon : ");
		int c=in.nextInt();
		c=kiemtranhap(c,0,13);
		switch(c)
		{
			case 1:
			{
				docghi();
				break;
			}
			case 2:
			{
				banve();
				break;
			}
			case 3:
			{
				tuyenbay();
				break;
			}
			case 4:
			{
				lotrinh();
				break;
			}
			case 5:
			{
				hangmaybay();
				break;
			}
			case 6:
			{
				maybay();
				break;
			}
			case 7:
			{
				chuyenbay();
				break;
			}
			case 8:
			{
				vechuyenbay();
				break;
			}
			case 9:
			{
				vekhachhang();
				break;
			}
			case 10:
			{
				khachhang();
				break;
			}
			case 11:
			{
				nhanvien();
				break;
			}
			case 12:
			{
				hoadon();
				break;
			}
			case 13:
			{
				sanbay(); 
				break;
			}
			case 14:{
				System.out.println("--- Danh Sach Nhan Vien Hoac Khach Hang ------");
				person();
				break;
			}
			case 0:
			{
				System.out.println("Ket thuc chuong trinh.");
				break;
			}
		}
	}

	public static void person() throws IOException {
		Scanner in = new Scanner(System.in);
		for(int i=0;i<customerList.getCustomer().length;i++) {
			int l=PerArr.length;
			PerArr=Arrays.copyOf(PerArr, l+1);
			PerArr[l]=new Customer(customerList.getCustomer()[i]);	
		}
		for(int i=0;i<staffList.getStaffList().length;i++) {
			int l=PerArr.length;
			PerArr=Arrays.copyOf(PerArr, l+1);
			PerArr[l]=new Staff(staffList.getStaffList()[i]);	
		}
		boolean flag=false;
		do {
			System.out.println("|| --------- Hien thi danh sach --------- ||");
			System.out.println("|| 1.Danh sach nhan vien                  ||");
			System.out.println("|| 2.Danh sach khach hang                 ||");
			System.out.println("|| 0.Thoat quay lai menu chinh            ||");
			System.out.println("|| Nhap su lua chon                       ||");
			int c = in.nextInt();
			switch(c) {
				case 1:{
					for(int i=0;i<PerArr.length;i++) {
						if(PerArr[i] instanceof Staff)
							PerArr[i].ShowInfo();
					}
					flag=true;
					break;
				}
				case 2:{
					for(int i=0;i<PerArr.length;i++) {
						if(PerArr[i] instanceof Customer)
							PerArr[i].ShowInfo();
					}
					flag=true;
					break;
				}
				case 0:{
					flag=false;
					break;
				}
			}
		}while(flag==true);
		menuchinh();
		
	}


	public static void docghi() throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("  ----------  Doc ghi du lieu  ---------- ");
		System.out.println("||1.Doc toan bo du lieu					||");								
		System.out.println("||2.Ghi toan bo du lieu					||");				
		System.out.println("||3.Quay lai menu chinh					||");				
		System.out.println("Nhap lua chon: ");
		int c = Integer.parseInt(sc.nextLine());
		switch(c){
			case 1: 
				rwFile.readFile(flightList, pathFlight);
				rwFile.readFile(flightTicketList, pathFlightTicket);
				rwFile.readFile(routeList, pathRoute);
				rwFile.readFile(flightRoutesList, pathFlightRoute);
				rwFile.readFile(airportList, pathAirport);
				rwFile.readFile(airplaneList, pathAirplane);
				rwFile.readFile(airplaneCompanyList, pathAirplaneCompany);
				rwFile.readFile(customerTicketList, pathCustomerTicket);
				rwFile.readFile(billList, pathBill);
				rwFile.readFile(customerList, pathCustomer);
				rwFile.readFile(staffList, pathStaff);
			case 2:
				rwFile.writeFile(flightList, pathFlight);
				rwFile.writeFile(flightTicketList, pathFlightTicket);
				rwFile.writeFile(routeList, pathRoute);
				rwFile.writeFile(flightRoutesList, pathFlightRoute);
				rwFile.writeFile(airportList, pathAirport);
				rwFile.writeFile(airplaneList, pathAirplane);
				rwFile.writeFile(airplaneCompanyList, pathAirplaneCompany);
				rwFile.writeFile(customerTicketList, pathCustomerTicket);
				rwFile.writeFile(billList, pathBill);
				rwFile.writeFile(customerList, pathCustomer);
				rwFile.writeFile(staffList, pathStaff);
			case 3:
				menuchinh();
		}

	}
	
	// public static void banve() {

	// }
	
	public static void tuyenbay () throws IOException {
		Scanner sc1=new Scanner(System.in);
		System.out.println("  ---------- Quan Ly Tuyen Bay ---------- ");
		System.out.println("||1.Them Tuyen bay						||");								
		System.out.println("||2.Xoa Tuyen bay						||");				
		System.out.println("||3.Tim kiem Tuyen bay					||");				
		System.out.println("||4.Sua thong tin Tuyen bay				||");				
		System.out.println("||5.Hien thi toan bo thong tin			||");				
		System.out.println("||0.Quay lai menu chinh 				||");				
		int c= Integer.parseInt(sc1.nextLine());
		switch(c) {
			case 1:{
				flightRoutesList.add();
				quaylai();
				tuyenbay();
				break;
			}
			case 2:{
				flightRoutesList.remove();
				quaylai();
				tuyenbay();
				break;
			}
			case 3:{
				flightRoutesList.search();
				quaylai();
				tuyenbay();
				break;
			}
			case 4:{
				flightRoutesList.edit();
				quaylai();
				tuyenbay();
				break;
			}
			case 5:{
				flightRoutesList.output();
				quaylai();
				tuyenbay();
				break;
			}
			case 0:{
				menuchinh();
				return;
			}
		}
	}
	
	public static void lotrinh() throws IOException{
		Scanner sc1= new Scanner(System.in);
		System.out.println("||------ Quan ly danh sach lo trinh -------||");
		System.out.println("||1.Them lo trinh                          ||");
		System.out.println("||2.Sua lo trinh                           ||");
		System.out.println("||3.Xoa lo trinh                           ||");
		System.out.println("||4.Hien thu toan bo                       ||");
		System.out.println("||5.Tim kiem lo trinh                      ||");
		System.out.println("||0. Quay lai menu chinh                   ||");
		System.out.println("Nhap lua chon");
		int c= Integer.parseInt(sc1.nextLine());
		switch(c) {
			case 1:{
				routeList.add();
				quaylai();
				lotrinh();
				break;
			}
			case 2:{
				routeList.edit();
				quaylai();
				lotrinh();
				break;
			}
			case 3:{
				routeList.remove();
				quaylai();
				lotrinh();
				break;
			}
			case 4:{
				routeList.output();
				quaylai();
				lotrinh();
				break;
			}
			case 5:{
				routeList.search();
				quaylai();
				lotrinh();
				break;
			}
			case 0:{
				menuchinh();
				return;
			}
			
		}
	
	}
	
	public static void hangmaybay () throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("========Quan ly hang may bay=========");
		System.out.println("|1. Xem danh sach hang may bay      |");
		System.out.println("|2. Them moi hang may bay           |");
		System.out.println("|3. Xoa hang may bay                |");
		System.out.println("|4. Tim kiem hang may bay           |");
		System.out.println("|5. Sua thong tin hang may bay      |");
		System.out.println("|0. Quay lai                        |");
		System.out.println("|===================================|");
		int choose = Integer.parseInt(sc.nextLine());
		switch(choose){
			case 1:
				airplaneCompanyList.output();
				quaylai();
				hangmaybay();
				break;
			case 2:
				airplaneCompanyList.add();
				quaylai();
				hangmaybay();
				break;
			case 3:
				airplaneCompanyList.remove();
				quaylai();
				hangmaybay();
				break;
			case 4:
				airplaneCompanyList.search();
				quaylai();
				hangmaybay();
				break;
			case 5:
				airplaneCompanyList.edit();
				quaylai();
				hangmaybay();
				break;
			case 0:
				menuchinh();
				break;
		}		 
	}
	
	public static void maybay () throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("========Quan ly may bay=========");
		System.out.println("|1. Xem danh sach may bay      |");
		System.out.println("|2. Them moi may bay           |");
		System.out.println("|3. Xoa may bay                |");
		System.out.println("|4. Tim kiem may bay           |");
		System.out.println("|5. Sua thong tin may bay      |");
		System.out.println("|0. Quay lai                   |");
		System.out.println("|==============================|");
		int choose = Integer.parseInt(sc.nextLine());
		switch(choose){
			case 1:
				airplaneList.output();
				quaylai();
				maybay();
				break;
			case 2:
				airplaneList.add();
				quaylai();
				maybay();
				break;
			case 3:
				airplaneList.remove();
				quaylai();
				maybay();
				break;
			case 4:
				airplaneList.search();
				quaylai();
				maybay();
				break;
			case 5:
				airplaneList.edit();
				quaylai();
				maybay();
				break;
			case 0:
				menuchinh();
				break;
		}	 
	}
	
	public static void chuyenbay() throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("=======Quan ly chuyen bay=======");
		System.out.println("|1. Xem danh sach chuyen bay   |");
		System.out.println("|2. Them moi chuyen bay        |");
		System.out.println("|3. Xoa chuyen bay             |");
		System.out.println("|4. Tim kiem chuyen bay        |");
		System.out.println("|5. Sua thong tin chuyen bay   |");
		System.out.println("|6. Thong ke chuyen bay        |");
		System.out.println("|0. Quay lai                   |");
		System.out.println("|==============================|");
		int choose = Integer.parseInt(sc.nextLine());
		switch(choose){
			case 1:
				flightList.output();
				quaylai();
				chuyenbay();
				break;
			case 2:
				flightList.add();
				quaylai();
				chuyenbay();
				break;
			case 3:
				flightList.remove();
				quaylai();
				chuyenbay();
				break;
			case 4:
				flightList.search();
				quaylai();
				chuyenbay();
				break;
			case 5:
				flightList.edit();
				quaylai();
				chuyenbay();
				break;
			case 6:
				flightList.statistic();
				quaylai();
				chuyenbay();
			case 0:
				menuchinh();
				break;
		}
	}

	public static void vechuyenbay() throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("========Quan ly ve chuyen bay=========");
		System.out.println("|1. Xem danh sach ve chuyen bay      |");
		System.out.println("|2. Them moi ve chuyen bay           |");
		System.out.println("|3. Xoa ve chuyen bay                |");
		System.out.println("|4. Tim kiem ve chuyen bay           |");
		System.out.println("|5. Sua thong tin ve chuyen bay      |");
		System.out.println("|0. Quay lai                 	     |");
		System.out.println("|====================================|");
		int choose = Integer.parseInt(sc.nextLine());
		switch(choose){
			case 1:
				flightTicketList.output();
				quaylai();
				vechuyenbay();
				break;
			case 2:
				flightTicketList.add();
				quaylai();
				vechuyenbay();
				break;
			case 3:
				flightTicketList.remove();
				quaylai();
				vechuyenbay();
				break;
			case 4:
				flightTicketList.search();
				quaylai();
				vechuyenbay();
				break;
			case 5:
				flightTicketList.edit();
				quaylai();
				vechuyenbay();
				break;
			case 0:
				menuchinh();
				break;
		}
	}
	
	public static void vekhachhang() throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("========Quan ly ve-khach hang=========");
		System.out.println("|1. Xem danh sach ve-khach hang      |");
		System.out.println("|2. Them moi ve-khach hang           |");
		System.out.println("|3. Xoa ve-khach hang                |");
		System.out.println("|4. Tim kiem ve-khach hang           |");
		System.out.println("|5. Sua thong tin ve-khach hang      |");
		System.out.println("|0. Quay lai                         |");
		System.out.println("|====================================|");
		int choose = Integer.parseInt(sc.nextLine());
		switch(choose){
		case 1:
			customerTicketList.output();
			quaylai();
			vekhachhang();
			break;
		case 2:
			customerTicketList.add();
			quaylai();
			vekhachhang();
			break;
		case 3:
			customerTicketList.remove();
			quaylai();
			vekhachhang();
			break;
		case 4:
			customerTicketList.search();
			quaylai();
			vekhachhang();
			break;
		case 5:
			customerTicketList.edit();
			quaylai();
			vekhachhang();
			break;
		case 0:
			menuchinh();
			break;
	}

	}
	
	public static void khachhang() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("||===============Quan ly khach hang================||");
		System.out.println("||                                                 ||");
		System.out.println("||============Chon muc ban can thao tac============||");
		System.out.println("||1. Xem toan bo danh sach khach hang              ||");
		System.out.println("||2. Xem chi tiet cua mot khach hang               ||");
		System.out.println("||3. Them khach hang                               ||");
		System.out.println("||4. Sua khach hang                                ||");
		System.out.println("||5. Xoa khach hang                                ||");
		System.out.println("||0. Quay ve menu chinh                            ||");
		System.out.println("||-------------------------------------------------||");
		System.out.println("");
		System.out.print("Nhap lua chon: ");
		int c = in.nextInt();
		switch (c) {
			case 1: {
				customerList.output();
				quaylai();
				khachhang();
				break;
			}
			case 2: {
				customerList.search();
				quaylai();
				khachhang();
				break;
			}
			case 3: {
				customerList.add();
				quaylai();
				khachhang();
				break;
			}
			case 4: {
				customerList.edit();
				quaylai();
				khachhang();
				break;
			}
			case 5: {
				customerList.remove();
				quaylai();
				khachhang();
				break;
			}
			case 0: {
				menuchinh();
				break;
			}	
		}
	}
	
	public static void nhanvien() throws IOException{
		Scanner in = new Scanner(System.in);
		System.out.println("||===============Quan ly nhan vien================||");
		System.out.println("||                                                 ||");
		System.out.println("||============Chon muc ban can thao tac============||");
		System.out.println("||1. Xem toan bo danh sach nhan vien               ||");
		System.out.println("||2. Xem chi tiet cua mot nhanh vien               ||");
		System.out.println("||3. Them nhan vien                                ||");
		System.out.println("||4. Sua nhan vien                                 ||");
		System.out.println("||5. Xoa nhan vien                                 ||");
		System.out.println("||0. Quay ve menu chinh                            ||");
		System.out.println("||-------------------------------------------------||");
		System.out.println("");
		System.out.print("Nhap lua chon: ");
		int c = in.nextInt();
		switch (c) {
			case 1: {
				staffList.output();
				quaylai();
				nhanvien();
				break;
			}
			case 2: {
				staffList.search();
				quaylai();
				nhanvien();
				break;
			}
			case 3: {
				staffList.add();
				quaylai();
				nhanvien();
				break;
			}
			case 4: {
				staffList.edit();
				quaylai();
				nhanvien();
				break;
			}
			case 5: {
				staffList.remove();
				quaylai();
				nhanvien();
				break;
			}
			case 0: {
				menuchinh();
				break;
			}
		}
	}
	
	
	
	public static void hoadon() throws IOException{
		//DSVemaybay dsve =new DSVemaybay();
		//dsve.docDSVe();
		Scanner in = new Scanner(System.in);
		System.out.println("||=================Quan ly hoa don=================||");
		System.out.println("||                                                 ||");
		System.out.println("||============Chon muc ban can thao tac============||");
		System.out.println("||1. Xem toan bo danh sach hoa don                 ||");
		System.out.println("||2. Xem chi tiet cua mot hoa don                  ||");
		System.out.println("||3. Them hoa don                                  ||");
		System.out.println("||4. Sua hoa don                                   ||");
		System.out.println("||5. Xoa hoa don                                   ||");
		System.out.println("||0. Quay ve menu chinh                            ||");
		System.out.println("||-------------------------------------------------||");
		System.out.println("");
		System.out.print("Nhap lua chon: ");
		int c = in.nextInt();
		switch (c) {
		case 1: {
			billList.output();
			quaylai();
			hoadon();
			break;
		}
		case 2: {
			staffList.search();
			quaylai();
			hoadon();
			break;
		}
		case 3: {
			staffList.add();
			quaylai();
			hoadon();
			break;
		}
		case 4: {
			staffList.edit();
			quaylai();
			hoadon();
			break;
		}
		case 5: {
			staffList.remove();
			quaylai();
			hoadon();
			break;
		}
		case 0: {
			menuchinh();
			break;
		}
		
	}
			
	}
	
	public static void sanbay() throws IOException{
		Scanner sc1= new Scanner(System.in);
		System.out.println("||-------- Quan ly danh sach san bay ---------||");
		System.out.println("||1. Them san bay                             ||");
		System.out.println("||2. Xoa san bay                              ||");
		System.out.println("||3. Sua san bay                              ||");
		System.out.println("||4. Tim kiem san bay                         ||");
		System.out.println("||5. Hien thi toan bo                         ||");
		System.out.println("||0. Quay lai menu chinh                      ||");
		System.out.println("Nhap lua chon");
		int c= Integer.parseInt(sc1.nextLine());
		switch(c) {
			case 1:{
				airportList.add();
				quaylai();
				sanbay();
				break;
			}
			case 2:{
				airportList.remove();
				quaylai();
				sanbay();
				break;
			}
			
			case 3:{
				airportList.edit();
				quaylai();
				sanbay();
				break;
			}
			
			case 4:{
				airportList.search();
				quaylai();
				sanbay();
				break;
			}

			case 5:{
				airportList.output();
				quaylai();
				sanbay();
				break;
			}

			case 0:{
				menuchinh();
				return;
			}	
		}
	}


	public  static void banve() throws IOException {
		Scanner in=new Scanner(System.in);	
		customerTicketList.add();
		
		System.out.println("Nhap ma ve may bay");
		String code=in.nextLine();
		FlightTicket a =new FlightTicket();
		
		for(int k=0;k<flightTicketList.getFlightTicketList().length;k++) {
			if(flightTicketList.getFlightTicketList()[k].getFlightTicketId().equals(code)){
				a=flightTicketList.getFlightTicketList()[k];
				break;
			}
			
		}
		
	
		for(int k=0;k<flightList.getFlightList().length;k++) {
			if(a.getFlightId().equals( flightList.getFlightList()[k].getFlightId() )   ) {
				int num=flightList.getFlightList()[k].getNumberOfTicketLeft();
				if(num>0)
					flightList.getFlightList()[k].setNumberOfTicketLeft(num-1);
				else System.out.println("Số ghế còn lại không đủ");
			}
		}
		
		
		quaylai();
		menuchinh();
	}
	
	public static void quaylai()
	{
		Scanner in =new Scanner(System.in);
		System.out.print("==== Nhan phim enter de quay ve ====");
		String a=in.nextLine();
		
		
	}
	public static int kiemtranhap(int c,int m,int n)
	{
		Scanner in=new Scanner(System.in);
		if(c<m||c>n)
		while(c<m||c>n)
		{
			System.out.println("Ban nhap sai ! ");
			System.out.print("Nhap lai lua chon : ");
			c=in.nextInt();
		}
		return c;
	}
}
