import java.util.*;
import java.io.*;

public class FlightList implements ListInterface {
    // public static String CB = "CB";
    // public static int ID = 100;
    public Flight[] flight = new Flight[0];
    private int n;
    // Scanner sc = new Scanner(System.in);

    public FlightList() {
    }

    public FlightList(Flight[] flight, int n) {
        this.flight = flight;
        this.n = n;
    }

    public FlightList(FlightList fl) {
        flight = fl.flight;
        n = fl.n;
    }

    public Flight[] getFlightList() {
        return flight;
    }

    public void setFlightList(Flight[] flight) {
        this.flight = flight;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many flight you want to have ?");
        n = Integer.parseInt(sc.nextLine());
        flight = new Flight[n];
        for (int i = 0; i < n; i++) {
            flight[i] = new Flight();
            System.out.println("Flight " + (i + 1) + ": ");
            flight[i].input();
        }
    }

    public void output() {
        System.out.println("|==================================================Danh sach chuyen bay==============================================|");
		System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
		System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
		System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
        for (int i = 0; i < flight.length; i++) {
            flight[i].output();
        }
    }

    RWFile rwFile = new RWFile();

    public void countTicketLeft() {
        FlightTicketList ftl = new FlightTicketList();
        rwFile.readFile(ftl, "C:\\Thepi\\Code\\Java\\OOP\\OOP Project\\Airplane-ticket\\Source code\\source\\flightTicket.txt");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < ftl.getN(); j++) {
                if(ftl.flightTicket[j].getFlightId().equals(flight[i].getFlightId())) {
                    flight[i].setNumberOfTicketLeft(flight[i].getNumberOfTicketLeft() - 1);
                }
            }
        }   
    }


    public void add() {
        Scanner sc = new Scanner(System.in);
		System.out.println("-----Them chuyen bay-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc.nextLine());
		int t;

        //Xin cap phat them
        n = flight.length;
        flight = Arrays.copyOf(flight, n + k);
        for(int i = n; i < n + k; i++) {
            sc = new Scanner(System.in);
            System.out.print("Nhap ma chuyen bay: ");
            String f_id = sc.nextLine();
            do {
                t = 0;
                for(int j = 0; j < n; j++) {
                    if(f_id.equalsIgnoreCase(flight[j].getFlightId())) {
                        System.out.println("Ma chuyen bay da bi trung!");
                        t = 1;
                    }
                } 
                if(t == 1) {
                    System.out.print("Nhap lai ma chuyen bay: ");
                    f_id = sc.nextLine();
                }
            } while(t == 1);
            if(t == 0) {
                sc = new Scanner(System.in);
                System.out.print("Nhap ma lo trinh co trong danh sach: ");
                String r_id = sc.nextLine();
                System.out.print("Nhap ma tuyen bay: ");
                String fr_id = sc.nextLine();
                System.out.print("Nhap ma may bay: ");
                String ap_id = sc.nextLine();
                int s;
                do {
                    System.out.println("Nhap trang thai chuyen bay: \n 0: San sang \n 1: Chua san sang \n");
                    s = Integer.parseInt(sc.nextLine());
                    if(s < 0 || s > 1) {
                        System.out.println("Ban da nhap sai trang thai! (gia tri phai nam trong khoang [0, 1])");
                    }
                } while(s > 0 && s < 1);
                System.out.print("Nhap so ve con lai: ");
                int ntl = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap ngay cat canh: ");
                String tod = sc.nextLine();
                System.out.print("Nhap ngay ha canh: ");
                String ld = sc.nextLine();
                flight[i] = new Flight(f_id, r_id, fr_id, ap_id, s, ntl, tod, ld);
            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them chuyen bay thanh cong");
        System.out.println("-----------***-----------");
    }




    // ------------------------------SEARCH-------------------------------------
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||--------Chon thao tac tim kiem--------||");
        System.out.println("||1. Tim kiem theo ma chuyen bay        ||");
        System.out.println("||2. Tim kiem theo lo trinh             ||");
        System.out.println("||3. Tim kiem theo tuyen bay            ||");
        System.out.println("||4. Tim kiem theo ma may bay           ||");
        System.out.println("||5. Tim kiem theo trang thai           ||");
        System.out.println("||------------------***-----------------||");
        System.out.print("Nhap lua chon cua ban: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1: 
            {
                //chuyen bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma chuyen bay can tim: ");
                String f_id = sc.nextLine();
                System.out.println("===================================================Danh sach chuyen bay===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                for(int i = 0; i < flight.length; i++) {
                    if(flight[i].getFlightId().equals(f_id))
                        flight[i].output();
                }
                break;
            }
            case 2: 
            {
                //lo trinh
                sc = new Scanner(System.in);
                System.out.print("Nhap ma lo trinh can tim: ");
                String r_id = sc.nextLine();
                System.out.println("===================================================Danh sach chuyen bay===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                for(int i = 0; i < flight.length; i++) {
                    if(flight[i].getRouteId().equals(r_id))
                        flight[i].output();
                }
                break;
            }
            case 3: 
            {
                //tuyen bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma tuyen bay can tim: ");
                String fr_id = sc.nextLine();
                System.out.println("===================================================Danh sach chuyen bay===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                for(int i = 0; i < flight.length; i++) {
                    if(flight[i].getFlightRouteId().equals(fr_id))
                        flight[i].output();
                }
                break;
            }
            case 4: 
            {
                //may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma may bay can tim: ");
                String ap_id = sc.nextLine();
                System.out.println("===================================================Danh sach chuyen bay===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                for(int i = 0; i < flight.length; i++) {
                    if(flight[i].getAirplaneId().equals(ap_id))
                        flight[i].output();
                }
                break;
            }
            case 5: 
            {
                sc = new Scanner(System.in);
                System.out.println("Nhap trang thai can tim: \n" + "0: San sang \n" + "1: Chua san sang");
                int s = Integer.parseInt(sc.nextLine());
                System.out.println("===================================================Danh sach chuyen bay===============================================");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                System.out.println("|Ma chuyen bay| Ma lo trinh | Ma tuyen bay |  Ma may bay  |  Trang thai | So ve con lai |  Ngay bay   | Ngay ha canh |");
                System.out.println("|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");
                for(int i = 0; i < flight.length; i++) {
                    if(flight[i].getStatus() == s)
                        flight[i].output();
                }
            }       
        }
    }
    // -----------------------------------END SEARCH-----------------------------------------




    // ---------------------------------DELETE--------------------------------------------

    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa chuyen bay theo ma chuyen Bay              ||");
        System.out.println("||2. Xoa chuyen bay theo ma lo trinh                ||");
        System.out.println("||3. Xoa chuyen bay theo ma tuyen bay               ||");
        System.out.println("||4. Xoa chuyen bay theo ma may bay                 ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma may bay can xoa: ");
                        String f_id = sc.nextLine();
                        removeFlightByFlightId(f_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay theo ma lo trinh khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma lo trinh can xoa: ");
                        String r_id = sc.nextLine();
                        removeFlightByRouteId(r_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay theo ma tuyen bay khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma tuyen bay can xoa: ");
                        String fr_id = sc.nextLine();
                        removeFlightByFlightRouteId(fr_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 4: 
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay theo ma may bay khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma may bay can xoa: ");
                        String ap_id = sc.nextLine();
                        removeFlightByAirplaneId(ap_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa chuyen bay!");
                        break;
                    }
                }
                break;
            }
        }
    }
    // -----------------------------------END DELETE-----------------------------------
    




    // -----------------------------EDIT------------------------------

    public void edit() {
        Scanner sc = new Scanner(System.in);
        boolean flag; 
        int t; 
        do{
            t = -1;
            System.out.print("Nhap ma chuyen bay can sua: ");
            String f_id= sc.nextLine();
            flag = false;
            for(int k = 0; k < flight.length; k++){
                if(flight[k].getFlightId().equals(f_id)){
                    flag = true;
                    t = k;
                    break;
                }
            }
            
            if(flag == true){
                System.out.println("||---------Chon thao tac sua--------||");
                System.out.println("||1. Sua ma chuyen Bay              ||");
                System.out.println("||2. Sua ma lo trinh                ||");
                System.out.println("||3. Sua ma tuyen bay               ||");
                System.out.println("||4. Sua ma may bay                 ||");
                System.out.println("||5. Sua ngay cat canh              ||");
                System.out.println("||6. Sua ngay ha canh               ||");
                System.out.println("||----------------***---------------||");
                System.out.print("Nhap lua chon: ");
                int c = Integer.parseInt(sc.nextLine());
                switch(c) {
                    case 1:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma chuyen bay moi: ");
                        String  nf_id= sc.nextLine();
                        flight[t].setFlightId(nf_id);
                        System.out.println("Da sua ma chuyen bay!");
                        break;
                    }
                    case 2:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma lo trinh moi: ");
                        String nr_id= sc.nextLine();
                        flight[t].setRouteId(nr_id);
                        System.out.println("Da sua ma lo trinh!");
                        break;
                        
                        
                    }
                    case 3:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma tuyen bay moi: ");
                        String  nfr_id = sc.nextLine();
                        flight[t].setFlightRouteId(nfr_id);
                        System.out.println("Da sua ma tuyen bay!");
                        break;
                    }
                    case 4:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma may bay moi: ");
                        String np_id = sc.nextLine();
                        flight[t].setAirplaneId(np_id);
                        System.out.println("Da sua ma may bay!");
                        break;
                    }
                    case 5:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap cat canh moi: ");
                        String ntod = sc.nextLine();
                        flight[t].setTakeOffDay(ntod);
                        System.out.println("Da sua ngay cat canh!");
                        break;
                    }
                    case 6:
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ngay ha canh moi: ");
                        String nld= sc.nextLine();
                        flight[t].setLandingDay(nld);
                        System.out.println("Da sua ngay ha canh!");
                        break;
                    }
                }
            } else {
                System.out.println("Ban da nhap sai ma chuyen bay, vui long nhap lai!");
            }
        }while(flag == false);
    }    
        
    
    
    
    // -----------------------------END EDIT------------------------------
    
    
    
    
    // -------------------------------------STATISTIC-------------------------------
    public void statistic() {
        // thong ke trang thai
        int count = 0;
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getStatus() == 0) {
                count++;
            }
        }
		System.out.println("|-----------------------------------|------------|");
        System.out.println("|So luong chuyen bay san sang       |" + count + tableOutput(Integer.toString(count), 12) + "|");
        System.out.println("|So luong chuyen bay chua san sang: |" + (flight.length - count) + tableOutput(Integer.toString(flight.length - count), 12) + "|");
		System.out.println("|-----------------------------------|------------|");
        count = 0;
        for(int i = 0; i < flight.length; i++) {
            count++;
        }
        System.out.println("|So luong chuyen bay                |" + count + tableOutput(Integer.toString(count), 12) + "|");
		System.out.println("|-----------------------------------|------------|");
        
    }

    // -----------------------------------END STATISTIC------------------------------
    public Flight searchFlightById(String flightId) {
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getFlightId().equals(flightId)) {
                return flight[i];
            }
        }
        return null;
    }


    public void removeFlightByFlightId(String flightId) {
        boolean flag = false;
        n = flight.length;
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getFlightId().equals(flightId)) {
                flag = true;
                for (int j = i; j < flight.length - 1; j++) {
                    flight[j] = flight[j + 1];
                }
                flight = Arrays.copyOf(flight, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.print("Khong xoa chuyen bay!");
    }          

    public void removeFlightByRouteId(String routeId) {
        boolean flag = false;
        n = flight.length;
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getRouteId().equals(routeId)) {
                flag = true;
                for (int j = i; j < flight.length - 1; j++) {
                    flight[j] = flight[j + 1];
                }
                flight = Arrays.copyOf(flight, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.print("Khong xoa chuyen bay!");
    }

    public void removeFlightByFlightRouteId(String flightRouteId) {
        boolean flag = false;
        n = flight.length;
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getFlightRouteId().equals(flightRouteId)) {
                flag = true;
                for (int j = i; j < flight.length - 1; j++) {
                    flight[j] = flight[j + 1];
                }
                flight = Arrays.copyOf(flight, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.print("Khong xoa chuyen bay!");
    }

    public void removeFlightByAirplaneId(String airplaneId) {
        boolean flag = false;
        n = flight.length;
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getAirplaneId().equals(airplaneId)) {
                flag = true;
                for (int j = i; j < flight.length - 1; j++) {
                    flight[j] = flight[j + 1];
                }
                flight = Arrays.copyOf(flight, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.print("Khong xoa chuyen bay!");
    }


    public void addElement(Flight fl) {
        n = flight.length;  
        flight = Arrays.copyOf(flight, n + 1);
        flight[n] = new Flight(fl);   
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        return s;
    }

}