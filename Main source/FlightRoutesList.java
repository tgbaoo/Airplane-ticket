// package AirplaneTicket;
// package fina;
// package AirplaneTicketFinal;
import java.util.Scanner;



import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class FlightRoutesList implements ListInterface{
	FlightRoutes[] fl =new FlightRoutes[1];
	int n;
	Scanner sc= new Scanner(System.in);
	
	public FlightRoutesList() {
		
	}
	
	public FlightRoutesList(FlightRoutes[] a,int n) {
		this.fl=a;
		this.n=n;
	}
	
	public FlightRoutesList(FlightRoutesList f1) {
		this.fl=f1.fl;
		n=f1.n;
	}
	
	public FlightRoutes[] getFlightRoutes() {
		return this.fl;
	}
	
	public void setFlightList(FlightRoutes[] a) {
		this.fl=a;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public void input() {
		System.out.println("How many flightroutes you want to have ?");
		n = Integer.parseInt(sc.nextLine());
		fl =new FlightRoutes[n];
		for(int i=0;i<n;i++) {
			fl[i]=new FlightRoutes();
			System.out.println("FlightRoute " + (i + 1) + ": ");
			fl[i].input();
			
		}
	}
	public void MockOutput() {
		System.out.println("==========================Danh sach tuyen bay ===============================");
		System.out.println("|-------------|----------------|----------------|-------------|-------------|");
		System.out.println("|flightRouteId| takeOffAirport | landingAirport | takeOffTime | landingTime |");
		System.out.println("|-------------|----------------|----------------|-------------|-------------|");
	}
	public void output() {
		MockOutput();
		for(int i=0;i<fl.length;i++) {
			fl[i].output();
			System.out.println();
		}
	}
	
    	
    
    public FlightRoutes addFlightRoutes(FlightRoutes fl1) {
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getFlightRouteId().equalsIgnoreCase(fl1.getFlightRouteId())) {
    			System.out.println("Already used");
    			return null;
    		}
    	}
    	n=fl.length;
    	fl=Arrays.copyOf(fl, n+1);
    	fl[n]=new FlightRoutes(fl1);
    	n++;
    	return fl1;
    }
    
    public void addElement(FlightRoutes fl1) {
        n = fl.length;
        fl = Arrays.copyOf(fl, n + 1);
        fl[n] = new FlightRoutes(fl1);
    }
    
    public void remove() {
    	System.out.println("|| -------- Chon thao tac xoa tuyen bay -------- ");
    	System.out.println("||1. Xoa ca chuyen bay                 ");
    	System.out.println("||2. Xoa theo san bay cat canh         ");
    	System.out.println("||2. Xoa theo san bay ha canh         ");
    	System.out.println("-----------------***-------------------");
    	System.out.println("Nhap lua chon ");
    	int c = Integer.parseInt(sc.nextLine());
    	switch(c) {
    		case 1:{
    			FlightRoutes tmp= new FlightRoutes();
    			tmp.input();
    			RemoveFligtRoute(tmp);
    		}
    		case 2:{
    			System.out.println("Nhap san bay cat canh ");
    			sc= new Scanner(System.in);
    			String k=sc.nextLine();
    			RemoveFlightRouteTakeOffLandingAirport(k);
    		}
    		case 3:{
    			System.out.println("Nhap san bay ha canh ");
    			sc= new Scanner(System.in);
    			String k=sc.nextLine();
    			RemoveFlightRouteTakeOffLandingAirport(k);	
    		}
    		default:{
    			System.out.println("Thoat khoi xoa chuyen bay");
    		}
    	}
    }
    
    public void search() {
    	Scanner sc1= new Scanner(System.in);
    	System.out.println("||------ Chon thao tac tim kiem -------");
    	System.out.println("|| 1. Tim kiem theo ma tuyen bay       ");
    	System.out.println("|| 2. Tim kiem theo san bay cat canh   ");
    	System.out.println("|| 3. Tim kiem theo san bay ha canh    ");
    	System.out.println("||------------------***-----------------||");
    	System.out.print("Nhap lua chon cua ban: ");
    	String find;
        int c = Integer.parseInt(sc1.nextLine());
        switch(c) {
        	case 1:{
        		sc1=new Scanner(System.in);
        		System.out.println("Nhap ma tuyen bay can tim");
        		find=sc1.nextLine();
        		MockOutput();
        		for(int i=0;i<fl.length;i++) {
        			if(fl[i].getFlightRouteId().equals(find)) {
        				fl[i].output();
        			}
        		}
        		
        		break;
        	}
        	case 2:{
        		boolean flag=false;
        		sc1=new Scanner(System.in);
        		System.out.println("Nhap ma tuyen bay can tim");
        		find=sc1.nextLine();
        		MockOutput();
        		for(int i=0;i<fl.length;i++) {
        			if(fl[i].getTakeOffAirport().equals(find)) {
        				flag=true;
        				fl[i].output();
        			}
        		}
        		if(!flag) System.out.println("Khong Tim thay");
        		break;
        	}
        	case 3:{
        		boolean flag=false;
        		sc1=new Scanner(System.in);
        		System.out.println("Nhap ma tuyen bay can tim");
        		find=sc1.nextLine();
        		MockOutput();
        		for(int i=0;i<fl.length;i++) {
        			if(fl[i].getTakeOffAirport().equals(find)) {
        				flag=true;
        				fl[i].output();
        			}
        		}
        		if(!flag) System.out.println("Khong Tim thay");
        		break;
        	}
        	
        	default :{
        		System.out.println("thoat khoi tim kiem");
        		return ;
        	}
        }
    	
    }
    
    public void add() {
        Scanner sc1 = new Scanner(System.in);
		System.out.println("-----Them tuyen bay-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc1.nextLine());
		int t = 0;

        //Xin cap phat them
        n = fl.length;
        fl = Arrays.copyOf(fl, n + k);
        // System.out.println("Check!");
        for(int i = 0; i < n + k; i++) {
        	sc1 = new Scanner(System.in);
            System.out.print("Nhap ma chuyen bay: ");
            String f_id = sc1.nextLine();
            do {
                t = 0;
                for(int j = 0; j < n; j++) {
                    if(f_id.equals(fl[j].getFlightRouteId())) {
                        System.out.println("Ma tuyen bay da bi trung!");
                        t = 1;
                    }
                }
                if(t == 1) {
                    System.out.print("Nhap lai ma tuyen bay: ");
                    f_id = sc1.nextLine();
                }
            } while(t == 1);
            if(t == 0) {
            	sc1 = new Scanner(System.in);
            	System.out.println("Enter Flight Route ID: ");
            	String	flightRouteId = sc1.nextLine();
        		System.out.println("Enter Take Off Airport: ");
        		String	takeOffAirport = sc1.nextLine();
        		System.out.println("Enter Landing Airport: ");
        		String	landingAirport = sc1.nextLine();
        		System.out.println("Enter Take Off Time:");
        		String	takeOffTime = sc1.nextLine();
        		System.out.println("Enter Landing Time: ");
        		String	landingTime = sc1.nextLine();
                fl[i]= new FlightRoutes(flightRouteId, takeOffAirport, landingAirport, takeOffTime, landingTime);

            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them tuyen bay thanh cong");
        System.out.println("-----------***-----------");
    }
    
    
    public void edit() {
    	Scanner sc1= new Scanner(System.in);
    	System.out.println("Nhap ma tuyen bay can sua");
    	String fix=sc1.nextLine();
    	int t;
    	for(int k=0;k<fl.length;k++) {
    		t=0;
    		do {
    			if(fl[k].getFlightRouteId().equals(fix)) {
    				t=1;
    				System.out.println("||---- Chon thao tac chinh sua------||");
    		    	System.out.println("|| 1. Sua ma tuyen bay");
    		    	System.out.println("|| 2. Sua san bay cat canh");
    		    	System.out.println("|| 3. Sua san bay ha canh");
    		    	System.out.println("|| 4. Sua gio bay bat dau");
    		    	System.out.println("|| 5. Sua gio bay ha canh");
    		    	System.out.println("||----------------***---------------||");
    		    	System.out.print("Nhap lua chon: ");
    		        int c = Integer.parseInt(sc.nextLine());
    		        switch(c) {
    		        	case 1:{
    		        		sc1=new Scanner(System.in);
    		        		System.out.println("Nhap ma tuyen bay");
    		        		String find=sc.nextLine();
    		        		for(int i=0;i<fl.length;i++) {
    		        			if(fl[i].getFlightRouteId().equals(find)) {
    		        				fl[i].setFlightRouteId(find);
    		        				break;
    		        			}
    		        		}
    		        		break;
    		        	}
    		        	case 2:{
    		        		sc1=new Scanner(System.in);
    		        		System.out.println("Nhap san bay  muon sua lai ");
    		        		String find=sc.nextLine();
    		        		for(int i=0;i<fl.length;i++) {
    		        			if(fl[i].getTakeOffAirport().equals(find)) {
    		        				fl[i].setTakeOffAirport(find);
    		        			}
    		        		}
    		        		break;
    		        	}
    		        	case 3:{
    		        		sc1=new Scanner(System.in);
    		        		System.out.println("Nhap san bay muon sua lai ");
    		        		String find=sc.nextLine();
    		        		for(int i=0;i<fl.length;i++) {
    		        			if(fl[i].getLandingAirport().equals(find)) {
    		        				fl[i].setLandingAirport(find);
    		        			}
    		        		}
    		        		break;
    		        	}
    		        	case 4:{
    		        		sc1=new Scanner(System.in);
    		        		System.out.println("Nhap gio bay muon sua lai ");
    		        		String find=sc.nextLine();
    		        		for(int i=0;i<fl.length;i++) {
    		        			if(fl[i].getTakeOffTime().equals(find)) {
    		        				fl[i].setTakeOffTime(find);
    		        			}
    		        		}
    		        		break;
    		        	}
    		        	case 5:{
    		        		sc1=new Scanner(System.in);
    		        		System.out.println("Nhap gio bay muon sua lai ");
    		        		String find=sc.nextLine();
    		        		for(int i=0;i<fl.length;i++) {
    		        			if(fl[i].getLandingTime().equals(find)) {
    		        				fl[i].setLandingTime(find);
    		        			}
    		        		}
    		        		break;
    		        	}
    		        	default :{
    		        		System.out.println("Thoat khoi muon sua");
    		        		return ;
    		        	}
    		        	
    		        }
    			}else System.out.println("Nhap sai ma !!!!");
    		}while(t==0);
    	}
    	
    }
    
    
    public void RemoveFlightRouteTakeOffLandingAirport(String ap) {
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getTakeOffAirport().equals(ap)) {
    			for(int j=i;j<fl.length-1;j++)
    				fl[j]=fl[j+1];
    		}
    	}
    	fl=Arrays.copyOf(fl, n-1);
    	n--;
    }
    
    public void RemoveFligtRoute(FlightRoutes fl1) {
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getFlightRouteId().equals(fl1.getFlightRouteId())) {
    			for(int j=i;j<fl.length-1;j++)
    				fl[j]=fl[j+1];
    		}
    	}
    	fl=Arrays.copyOf(fl, n-1);
    	n--;
    }
    
    public FlightRoutes searchFlightRoutesByID(String ID) {
    	boolean flag=false;
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getFlightRouteId().equals(ID)) {
    			flag=true;
    			return fl[i];
    		}
    	}
    	if(flag==false) System.out.println("Not Found");
    	return null;
    }
    
    public FlightRoutes[] SeachFlightRouteBylandingAirport(String ap) {
    	FlightRoutes[] f=new FlightRoutes[0];
    	boolean flag=false;
    	int count=0;
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getLandingAirport().equalsIgnoreCase(ap)) {
    			flag=true;
    			f=Arrays.copyOf(f, count+1);
    			f[count]=new FlightRoutes(fl[i]);
    			count++;
    		}
    	}
    	if(flag) return f; 
    	System.out.println("not Fount");
    	return null;
    }
    
    public FlightRoutes[] SeachFlightRouteByTakeOffAirport(String ap) {
    	FlightRoutes[] f=new FlightRoutes[0];
    	boolean flag=false;
    	int count=0;
    	for(int i=0;i<fl.length;i++) {
    		if(fl[i].getTakeOffAirport().equalsIgnoreCase(ap)) {
    			flag=true;
    			f=Arrays.copyOf(f, count+1);
    			f[count]=new FlightRoutes(fl[i]);
    			count++;
    		}
    	}
    	if(flag) return f; 
    	System.out.println("not Fount");
    	return null;
    }
    
}
