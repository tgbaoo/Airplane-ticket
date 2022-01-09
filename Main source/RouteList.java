
// package AirplaneTicketFinal;
// package fina;
import java.util.Scanner;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Scanner;

public class RouteList implements ListInterface {
	public Route[] routeList = new Route[0];
	int n;
	Scanner sc = new Scanner(System.in);

	public RouteList() {

	}

	public RouteList(Route[] routeList, int n) {
		this.routeList = routeList;
		this.n = n;
	}

	public RouteList(RouteList rl) {
		routeList = rl.routeList;
		n = rl.n;
	}

	public Route[] getRouteList() {
		return routeList;
	}

	public void setRouteList(Route[] rl) {
		this.routeList = rl;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void input() {
		System.out.println("How many route you want to have ");
		n = Integer.parseInt(sc.nextLine());
		routeList = new Route[n];
		for (int i = 0; i < n; i++) {
			routeList[i] = new Route();
			System.out.println("Route" + (i + 1) + " ");
			routeList[i].input();
		}
	}

	public void MockOutput() {
		System.out.println("============Danh sach tuyen bay============");
		System.out.println("|---------|-----------|");
		System.out.println("| RouteID | RouteName |");
		System.out.println("|---------|-----------|");
	}

	public void output() {
		MockOutput();
		for (int i = 0; i < routeList.length; i++) {
			routeList[i].output();
			System.out.println("");
		}
	}

	public void addElement(Route fl) {
		n = routeList.length;
		routeList = Arrays.copyOf(routeList, n + 1);
		routeList[n] = new Route(fl);
	}

	public void add() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("-----Them chuyen bay-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc1.nextLine());
		int t = 0;

		// Xin cap phat them
		n = routeList.length;
		routeList = Arrays.copyOf(routeList, n + k);
		// System.out.println("Check!");
		for (int i = 0; i < n + k; i++) {
			sc1 = new Scanner(System.in);
			System.out.print("Nhap ma lo trinh: ");
			String f_id = sc1.nextLine();
			do {
				t = 0;
				for (int j = 0; j < n; j++) {
					if (f_id.equals(routeList[j].getRouteID())) {
						System.out.println("Ma lo trinh da bi trung!");
						t = 1;
					}
				}
				if (t == 1) {
					System.out.print("Nhap lai ma chuyen bay: ");
					f_id = sc1.nextLine();
				}
			} while (t == 1);
			if (t == 0) {
				sc1 = new Scanner(System.in);
				System.out.println("Enter Route ID: ");
				String routeID = sc1.nextLine();
				System.out.println("Enter Route Name: ");
				String routeName = sc1.nextLine();
				routeList[i] = new Route(routeID, routeName);
			}
		}
		n = n + k;
		// writeFile();
		System.out.println("Them chuyen bay thanh cong");
		System.out.println("-----------***-----------");
	}

	public void addRoute(Route r) {
		for (int i = 0; i < routeList.length; i++) {
			if (routeList[i].getRouteID().equalsIgnoreCase(r.getRouteID())) {
				System.out.println("Route id is already use");
				return;
			}

		}
		n = routeList.length;
		routeList = Arrays.copyOf(routeList, n + 1);
		routeList[n] = new Route(r);
		n++;

	}

	public void remove() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("|| ------- Chon thao tac xoa lo trinh --------- ||");
		System.out.println("|| 1. Xoa theo ma lo trinh          ||");
		System.out.println("|| 1. Xoa theo ten lo trinh         ||");
		System.out.println("||----------------***---------------||");
		System.out.print("Nhap lua chon: ");
		int c = Integer.parseInt(sc1.nextLine());
		switch (c) {
			case 1: {
				sc1 = new Scanner(System.in);
				System.out.println("Nhap ma lo trinh can xoa: ");
				String r_id = sc1.nextLine();
				removeRouteByID(r_id);
				break;
			}
			case 2: {
				sc1 = new Scanner(System.in);
				System.out.println("Nhap ten lo trinh can xoa: ");
				String r_id = sc1.nextLine();
				removeRouteByName(r_id);
				break;
			}
			default: {
				System.out.println("thoat khoi xoa lo trinh ");
				return;
			}
		}
	}

	public void search() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("|| --------  Chon thao tac tim kiem lo trinh --------");
		System.out.println("|| 1. Tim kiem theo ma lo trinh ");
		System.out.println("|| 2. Tim kiem theo ten lo trinh ");
		System.out.println("||------------------------***-----------------------||");
		System.out.print("Nhap lua chon: ");
		int c = Integer.parseInt(sc1.nextLine());
		switch (c) {
			case 1: {
				System.out.println("Nhap ma lo trinh can Tim kiem ");
				sc1 = new Scanner(System.in);
				String find = sc1.nextLine();
				MockOutput();
				for (int i = 0; i < routeList.length; i++) {
					if (routeList[i].getRouteID().equals(find)) {
						routeList[i].output();
					}
				}
				break;
			}
			case 2: {
				System.out.println("Nhap Ten lo trinh can tim kiem ");
				sc1 = new Scanner(System.in);
				String find = sc1.nextLine();
				MockOutput();
				for (int i = 0; i < routeList.length; i++) {
					if (routeList[i].getRouteName().equals(find)) {
						routeList[i].output();
					}
				}
				break;
			}
			default: {
				System.out.println("thoat khoi xoa lo trinh");
				return;
			}
		}
	}

	public void edit() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Nhap ma tuyen bay can sua");
		String fix = sc1.nextLine();
		int t;
		for (int k = 0; k < routeList.length; k++) {
			t = 0;
			do {
				if (routeList[k].getRouteID().equals(fix)) {
					t = 1;
					System.out.println("|| ------ Chon thao tac chinh sua --------");
					System.out.println("|| 1. Sua ma lo trinh                     ");
					System.out.println("|| 2. Sua ten lo trinh                    ");
					System.out.println("||---------------------***-----------------||");
					System.out.print("Nhap lua chon: ");
					int c = Integer.parseInt(sc1.nextLine());
					switch (c) {
						case 1: {
							sc1 = new Scanner(System.in);
							System.out.println("Nhao ma lo trinh");
							String find = sc1.nextLine();
							for (int i = 0; i < routeList.length; i++) {
								if (routeList[i].getRouteID().equals(find)) {
									routeList[i].setRouteID(find);
									break;
								}
							}
							break;
						}
						case 2: {
							sc1 = new Scanner(System.in);
							System.out.println("Nhao ten lo trinh");
							String find = sc1.nextLine();
							for (int i = 0; i < routeList.length; i++) {
								if (routeList[i].getRouteName().equals(find)) {
									routeList[i].setRouteName(find);
								}
							}
							break;
						}
						default: {
							System.out.println("Thoat khoi chinh sua lo trinh");
							return;
						}
					}
				} else
					System.out.println("Nhap sai ma !!!!");

			} while (t == 0);
		}

	}

	public void SearchRoute() {
		String k;
		boolean flag = false;
		System.out.println("Enter route id you want to find");
		k = sc.nextLine();
		System.out.println("Result is");
		for (int i = 0; i < routeList.length; i++) {
			if (routeList[i].getRouteID().indexOf(k) != -1) {
				System.out.println("Route " + (i + 1) + " ");
				routeList[i].output();
				System.out.println();
			}
		}
		if (flag == false)
			System.out.println("Not Found");
	}

	public Route searchRouteID(String RouteId) {
		for (int i = 0; i < routeList.length; i++) {
			if (routeList[i].getRouteID().equals(RouteId))
				return routeList[i];
		}
		return null;
	}

	public void removeRouteByName(String name) {
		for (int i = 0; i < routeList.length; i++) {
			if (routeList[i].getRouteName().equals(name)) {
				for (int j = i; j < routeList.length - 1; j++) {
					routeList[j] = routeList[j + 1];
				}
			}
		}
		routeList = Arrays.copyOf(routeList, n - 1);
		n--;
	}

	public void removeRouteByID(String ID) {
		for (int i = 0; i < routeList.length; i++) {
			if (routeList[i].getRouteID().equalsIgnoreCase(ID)) {
				for (int j = i; j < routeList.length - 1; j++) {
					routeList[j] = routeList[j + 1];
				}
			}
		}
		routeList = Arrays.copyOf(routeList, n - 1);
		n--;
	}

}
