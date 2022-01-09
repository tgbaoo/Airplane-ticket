import java.io.*;
import java.util.*;

public class FlightTicketList implements ListInterface{
    // public static String VKH = "VKH";
    // public static int ID = 100;
    FlightTicket[] flightTicket = new FlightTicket[0];
    int n;
    Scanner sc = new Scanner(System.in);

    public FlightTicketList() {
    }

    public FlightTicketList(FlightTicket[] flightTicket, int n) {
        this.flightTicket = flightTicket;
        this.n = n;
    }

    public FlightTicketList(FlightTicketList ftl) {
        flightTicket = ftl.flightTicket;
        n = ftl.n;
    }

    public FlightTicket[] getFlightTicketList() {
        return flightTicket;
    }

    public void setFlightTicketList(FlightTicket[] flightTicket) {
        this.flightTicket = flightTicket;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void input() {
        System.out.println("How many flight you want to have ?");
        n = sc.nextInt();
        flightTicket = new FlightTicket[n];
        for (int i = 0; i < n; i++) {
            System.out.println("What type of flight you want to enter ?");
            System.out.println("0: Economy Class");
            System.out.println("1: Business Class");
            int k = sc.nextInt();
            if (k == 0) {
                flightTicket[i] = new EconomyClassTicket();
                flightTicket[i].input();
            } else if(k == 1){
                flightTicket[i] = new BusinessClassTicket();
                flightTicket[i].input();
            }
        }
    }

    public void output() {
        System.out.println("|=================Danh sach ve chuyen bay=================|");
        for (int i = 0; i < flightTicket.length; i++) {
            flightTicket[i].output();
        }
    }

    

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Them Ve Chuyen Bay-----------");
        System.out.print("Nhap so luong muon them: ");
        int k = Integer.parseInt(sc.nextLine());
        int t;
        //xin cap phat them
        n = flightTicket.length;
        flightTicket = Arrays.copyOf(flightTicket, n + k);
        for(int i = n; i < n + k; i++) {
            int c;
            do {
                sc = new Scanner(System.in);
                System.out.println("Ban muon them loai ve nao: \n" + "0: ve pho thong \n" + "1: ve hang thuong gia \n");
                c = Integer.parseInt(sc.nextLine());
                if(c == 0) { //eco
                    sc = new Scanner(System.in);
                    System.out.println("Nhap ma ve: ");
                    String ft_id = sc.nextLine();
                    do {
                        t = 0;
                        for(int j = 0; j < n; j++) {
                            if(ft_id.equals(flightTicket[j].getFlightTicketId())) {
                                System.out.println("Ma ve da bi trung, vui long nhap lai!");
                                t = 1;
                            }
                        }
                        if(t == 1) {
                            System.out.println("Nhap lai ma ve: ");
                            ft_id = sc.nextLine();
                        }
                    } while(t == 1);
                    if(t == 0) {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma chuyen bay!");
                        String f_id = sc.nextLine();
                        int s;
                        do {
                            System.out.println("Nhap loai ve chuyen bay: \n" + "0: ve khu hoi \n" + "1: ve mot chieu \n");
                            s = Integer.parseInt(sc.nextLine());
                            if(s != 0 & s != 1) {
                                System.out.println("Ban nhap sai trang thai, vui long nhap lai!");
                            }
                        } while(s != 0 && s != 1);
                        System.out.println("Nhap gia ve: ");
                        int tp = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhap so ghe: ");
                        String cn = sc.nextLine();
                        flightTicket[i] = new EconomyClassTicket(ft_id, f_id, s, tp, cn);
                    }
                } else if(c == 1) { //bus
                    sc = new Scanner(System.in);
                    System.out.println("Nhap ma ve: ");
                    String ft_id = sc.nextLine();
                    do {
                        t = 0;
                        for(int j = 0; j < n; j++) {
                            if(ft_id.equals(flightTicket[i].getFlightTicketId())) {
                                System.out.println("Ma ve da bi trung, vui long nhap lai!");
                                t = 1;
                            }
                        }
                        if(t == 1) {
                            System.out.println("Nhap lai ma ve: ");
                            ft_id = sc.nextLine();
                        }
                    } while(t == 1);
                    if(t == 0) {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma chuyen bay!");
                        String f_id = sc.nextLine();
                        int s;
                        do {
                            System.out.println("Nhap loai ve chuyen bay: \n" + "0: ve khu hoi \n" + "1: ve mot chieu");
                            s = Integer.parseInt(sc.nextLine());
                            if(s != 0 & s != 1) {
                                System.out.println("Ban nhap sai trang thai, vui long nhap lai!");
                            }
                        } while(s != 0 && s != 1);
                        System.out.println("Nhap gia ve: ");
                        int tp = Integer.parseInt(sc.nextLine());
                        // System.out.print("Nhap so ghe: ");
                        // int cn = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhap ma phong cho: ");    
                        String wr_id = sc.nextLine();
                        System.out.println("Nhap ma khoang: "); 
                        String bc_id = sc.nextLine();
                        flightTicket[i] = new BusinessClassTicket(ft_id, f_id, s, tp, wr_id, bc_id);
                    }
                    if(c != 0 && c != 1)
                    System.out.println("Ban nhap sai loai ve, vui long nhap lai!");
                    // break;
                } 
                // break;
            } while(c != 0 && c != 1);
        }
        n = n + k;
        System.out.println("Them ve may bay thanh cong");
        System.out.println("------------***-----------");
    }

        // ------------------------------SEARCH-------------------------------------
        public void search() {
            Scanner sc = new Scanner(System.in);
            System.out.println("||--------Chon thao tac tim kiem--------||");
            System.out.println("||1. Tim kiem theo ma ve chuyen bay     ||");
            System.out.println("||2. Tim kiem theo ma chuyen bay        ||");
            System.out.println("||3. Tim kiem theo loai ve              ||");
            System.out.println("||4. Tim kiem theo so ghe               ||");
            System.out.println("||5. Tim kiem theo ma phong cho         ||");
            System.out.println("||6. Tim kiem theo ma khoang            ||");
            System.out.println("||------------------***-----------------||");
            System.out.print("Nhap lua chon cua ban: ");
            int c = Integer.parseInt(sc.nextLine());
            switch(c) {
                case 1: 
                {
                    //chuyen bay
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.print("Nhap ma ve chuyen bay can tim: ");
                    String ft_id = sc.nextLine();
                    System.out.println("======================Danh sach ve chuyen bay=======================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i].getFlightTicketId().equals(ft_id)) {
                            flightTicket[i].output();
                            flag = true;
                        }
                    }
                    if(!flag) System.out.println("Khong tim thay ve!");
                    break;
                }
                case 2: 
                {
                    //chuyen bay
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.print("Nhap ma chuyen bay can tim: ");
                    String f_id = sc.nextLine();
                    System.out.println("======================Danh sach ve chuyen bay=======================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i].getFlightId().equals(f_id)) {
                            flightTicket[i].output();
                            flag = true;
                        }
                    }
                    if(!flag) System.out.println("Khong tim thay ve");
                    break;
                }
                case 3: 
                {
                    //loai ve
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.print("Nhap loai ve can tim: \n 0: Khu hoi \n 1: Mot chieu \n");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.println("===========================Danh sach ve chuyen bay===========================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i].getTicketType() == type) {
                            flightTicket[i].output();
                            flag = true;
                        }

                    }
                    if(!flag) System.out.println("Khong tim thay ve");
                    break;
                }
                case 4: 
                {
                    //may bay
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.print("Nhap so ghe can tim: ");
                    String cn = sc.nextLine();
                    System.out.println("======================Danh sach ve chuyen bay=======================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i] instanceof EconomyClassTicket){
                            if(((EconomyClassTicket)flightTicket[i]).getChairNumber().equals(cn)) {
                                ((EconomyClassTicket)flightTicket[i]).output();
                                flag = true;
                            }
                        }
                        
                    }
                    if(!flag) System.out.println("Khong tim thay ve");
                    break;
                }
                case 5: 
                {
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.println("Nhap ma phong cho: ");
                    String wr_id = sc.nextLine();
                    System.out.println("======================Danh sach ve chuyen bay=======================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i] instanceof BusinessClassTicket){
                            BusinessClassTicket bct = new BusinessClassTicket();
                            bct = (BusinessClassTicket)flightTicket[i];
                            if(bct.getWaitingRoomId().equals(wr_id)) {
                                flag = true;
                                bct.output();
                            }
                        }
                    }
                    if(!flag) System.out.println("Khong tim thay ve");
                    break;
                }
                case 6: 
                {
                    boolean flag = false;
                    sc = new Scanner(System.in);
                    System.out.println("Nhap ma khoang can tim: ");
                    String bc_id = sc.nextLine();
                    System.out.println("======================Danh sach ve chuyen bay=======================");
                    for(int i = 0; i < flightTicket.length; i++) {
                        if(flightTicket[i] instanceof BusinessClassTicket) {
                            BusinessClassTicket bct = new BusinessClassTicket();
                            bct = (BusinessClassTicket)flightTicket[i];
                            if(bct.getBusinessClassId().equals(bc_id)){
                                flag = true;
                                bct.output();
                            }

                        }
                    }
                    if(!flag) System.out.println("Khong tim thay ve");
                    break;
                }         
            }
        }
        // -----------------------------------END SEARCH-----------------------------------------
    
    // ---------------------------------DELETE--------------------------------------------

    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa ve chuyen bay theo ma ve                   ||");
        System.out.println("||2. Xoa ve chuyen bay theo ma chuyen bay           ||");
        System.out.println("||3. Xoa ve chuyen bay theo ma phong cho            ||");
        System.out.println("||4. Xoa ve chuyen bay theo ma khoang               ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve chuyen bay khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma ve can xoa: ");
                        String ft_id = sc.nextLine();
                        removeFlightTicketById(ft_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve chuyen bay theo ma chuyen bay khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma chuyen bay can xoa: ");
                        String f_id = sc.nextLine();
                        removeFlightTicketByFlightId(f_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve chuyen bay theo ma phong cho khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma phong cho can xoa: ");
                        String wr_id = sc.nextLine();
                        removeFlightTicketByWaitingRoomId(wr_id);
                        break;
                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve chuyen bay!");
                        break;
                    }
                }
                break;
            }
            case 4: 
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay theo gia ve khong?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap gia ve can xoa: ");
                        String bc_id = sc.nextLine();
                        removeFlightTicketByBusinessClassId(bc_id);
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
            do {
                t = -1;
                System.out.println("Nhap ma ve chuyen bay can sua: ");
                String ft_id = sc.nextLine();
                flag = false;
                for(int k = 0; k < flightTicket.length; k++){
                    if(flightTicket[k].getFlightTicketId().equals(ft_id))
                    {
                        flag = true;
                        t = k;
                        break; 
                    }
                }
                if(flag == true){
                    System.out.println("||---------Chon thao tac sua--------||");
                        System.out.println("||1. Sua ma ve chuyen bay           ||");
                        System.out.println("||2. Sua ma chuyen bay              ||");
                        System.out.println("||3. Sua gia ve                     ||");
                        System.out.println("||4. Sua ma ghe                     ||");
                        System.out.println("||5. Sua ma phong cho               ||");
                        System.out.println("||6. Sua ma khoang                  ||");
                        System.out.println("||----------------***---------------||");
                        System.out.print("Nhap lua chon: ");
                        int c = Integer.parseInt(sc.nextLine());
                        switch(c) {
                            case 1:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap ma ve chuyen bay moi: ");
                                ft_id= sc.nextLine();
                                flightTicket[t].setFlightTicketId(ft_id);
                                System.out.println("Da sua ma ve chuyen bay!");
                                break;
                            }
                            case 2:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap ma chuyen bay moi: ");
                                String f_id = sc.nextLine();
                                flightTicket[t].setFlightId(f_id);
                                System.out.println("Da sua ma chuyen bay!");
                                break;   
                            }
                            case 3:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap gia ve moi: ");
                                int price = Integer.parseInt(sc.nextLine());
                                flightTicket[t].setTicketPrice(price);
                                System.out.println("Da sua gia ve!");
                                break;
                            }
                            case 4:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap ma ghe moi: ");
                                String cn = sc.nextLine(); 
                                EconomyClassTicket ect = new EconomyClassTicket();
                                ect = (EconomyClassTicket)flightTicket[t];
                                ect.setChairNumber(cn);
                                System.out.println("Da sua ngay ha canh!");
                                break;
                            }
                            case 5:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap ma phong cho moi: ");
                                String wr_id = sc.nextLine();
                                BusinessClassTicket bct = new BusinessClassTicket();
                                bct = (BusinessClassTicket)flightTicket[t];
                                bct.setWaitingRoomId(wr_id);
                                flightTicket[t] = bct;
                                System.out.println("Da sua ma phong cho!");
                                break;
                            }
                            case 6:
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Nhap ma khoang moi: ");
                                String bc_id = sc.nextLine();
                                BusinessClassTicket bct = new BusinessClassTicket();
                                bct = (BusinessClassTicket)flightTicket[t];
                                bct.setBusinessClassId(bc_id);
                                flightTicket[t] = bct;
                                System.out.println("Da sua ma khoang!");
                                break;
                            }
                        }
                } 
                else {
                    System.out.println("Ban da nhap sai ma ve chuyen bay, vui long nhap lai!");
                }
            }while(flag == false);
        }
        // -----------------------------END EDIT------------------------------
    
 
        public void statistic() {
            // thong ke loai ve
            int count = 0;
            for (int i = 0; i < flightTicket.length; i++) {
                if (flightTicket[i].getTicketType() == 0) {
                    count++;
                }
            }
            System.out.println("|-----------------------------------|------------|");
            System.out.println("|So luong ve chuyen bay khu hoi     |" + count + tableOutput(Integer.toString(count), 12) + "|");
            System.out.println("|So luong ve chuyen bay mot chieu:  |" + (flightTicket.length - count) + tableOutput(Integer.toString(flightTicket.length - count), 12) + "|");
            System.out.println("|-----------------------------------|------------|");
            
            //thong ke tong gia ve
            int sum = 0;
            for(int i = 0; i < flightTicket.length; i++) {
                sum+=flightTicket[i].getTicketPrice();
            }
            System.out.println("|Tong doanh thu gia ve              |" + sum + tableOutput(Integer.toString(count), 12) + "|");
            System.out.println("|-----------------------------------|------------|");
            
        }

    // public void addEconomyClassTicket(EconomyClassTicket e) {
    //     for(int i = 0; i < flightTicket.length; i++) {
    //         if(e.getFlightTicketId().indexOf(flightTicketList[i].getFlightTicketId()) != -1) {
    //             System.out.println("Your Flight Ticket has already been added!");
    //             return;
    //         }
    //     }
    //     n = flightTicketList.length;
    //     flightTicketList = Arrays.copyOf(flightTicketList, n + 1);
    //     flightTicketList[n] = new EconomyClassTicket(e);
    //     n++;
    // }

    // public void addBusinessClassTicket(BusinessClassTicket b) {
    //     for(int i = 0; i < flightTicketList.length; i++) {
    //         if(b.getFlightTicketId().equals(flightTicketList[i].getFlightTicketId())) {
    //             System.out.println("Your Flight Ticket has already been added!");
    //             return;
    //         }
    //     }
    //     n = flightTicketList.length;
    //     flightTicketList = Arrays.copyOf(flightTicketList, n + 1);
    //     flightTicketList[n] = new BusinessClassTicket(b);
    //     n++;
    // }

    public FlightTicket searchFlightTicketById(String flightTicketId) {
        for(int i = 0; i < flightTicket.length; i++) {
            if(flightTicket[i].getFlightTicketId().indexOf(flightTicketId) != -1) {
                return flightTicket[i];
            }
        }
        return null;
    }

    // public FlightTicket[] searchFlightTicketByType(int type) {
    //     FlightTicket[] f = new FlightTicket[0];
    //     boolean flag = false;
    //     int count = 0;
    //     for(int i = 0; i < flightTicketList.length; i++) {
    //         if(flightTicketList[i].getTicketType() == type) {
    //             flag = true;
    //             f = Arrays.copyOf(f, count + 1);
    //             f[count] = new FlightTicket(flightTicketList[i]);
    //             count++;
                
    //         }
    //     }
    //     if(flag) return f;
    //     return null;
    // }

    // public FlightTicket[] searchFlightTicketByBoardingTime(String boardingTime) {
    //     FlightTicket[] f = new FlightTicket[0];
    //     boolean flag = false;
    //     int count = 0;
    //     for(int i = 0; i < flightTicketList.length; i++) {
    //         if(flightTicketList[i].getBoardingTime().indexOf(boardingTime) != -1) {
    //             flag = true;
    //             f = Arrays.copyOf(f, count + 1);
    //             f[count] = new FlightTicket(flightTicketList[i]);
    //             count++;
    //         }
    //     }
    //     if(flag) return f;
    //     return null;  
    // }

    // public FlightTicket[] searchFlightTicketByTicketPrice(int ticketPrice) {
    //     FlightTicket[] f = new FlightTicket[0];
    //     boolean flag = false;
    //     int count = 0;
    //     for(int i = 0; i < flightTicketList.length; i++) {
    //         if(flightTicketList[i].getTicketPrice() == ticketPrice) {
    //             flag = true;
    //             f = Arrays.copyOf(f, count + 1);
    //             f[count] = new FlightTicket(flightTicketList[i]);
    //             count++;
    //         }
    //     }
    //     return f;  
    // }

    // public void removeFlightTicketById(String flightTicketId) {
    //     for (int i = 0; i < flightTicketList.length; i++) {
    //         if (flightTicketList[i].getFlightTicketId().indexOf(flightTicketId) != -1) {
    //             for (int j = i; j < flightTicketList.length - 1; j++) {
    //                 flightTicketList[j] = flightTicketList[j + 1];
    //             }
    //         }
    //     }
    //     flightTicketList = Arrays.copyOf(flightTicketList, n - 1);
    //     n--;
    // }

    public void removeFlightTicketById(String flightTicketId) {
        boolean flag = false;
        n = flightTicket.length;
        for (int i = 0; i < flightTicket.length; i++) {
            if (flightTicket[i].getFlightTicketId().equals(flightTicketId)) {
                flag = true;
                for (int j = i; j < flightTicket.length - 1; j++) {
                    flightTicket[j] = flightTicket[j + 1];
                }
                flightTicket = Arrays.copyOf(flightTicket, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.println("Khong xoa chuyen bay!");
    }           

    public void removeFlightTicketByFlightId(String flightId) {
        boolean flag = false;
        n = flightTicket.length;
        for (int i = 0; i < flightTicket.length; i++) {
            if (flightTicket[i].getFlightId().equals(flightId)) {
                flag = true;
                for (int j = i; j < flightTicket.length - 1; j++) {
                    flightTicket[j] = flightTicket[j + 1];
                }
                flightTicket = Arrays.copyOf(flightTicket, n - 1);
                n--;
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else    
            System.out.println("Khong xoa chuyen bay!");
    }

    public void removeFlightTicketByWaitingRoomId(String waitingRoomId) {
        boolean flag = false;
        n = flightTicket.length;
        for (int i = 0; i < flightTicket.length; i++) {
            if(flightTicket[i] instanceof BusinessClassTicket) {
                BusinessClassTicket bct = new BusinessClassTicket();
                bct = (BusinessClassTicket)flightTicket[i];
                if (bct.getWaitingRoomId().equals(waitingRoomId)) {
                    flag = true;
                    for (int j = i; j < flightTicket.length - 1; j++) {
                        flightTicket[j] = flightTicket[j + 1];
                    }
                    flightTicket = Arrays.copyOf(flightTicket, n - 1);
                    n--;
                }
            }
        }
        if(flag)
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.println("Khong xoa chuyen bay!");
    }

    public void removeFlightTicketByBusinessClassId(String BusinessClassId) {
        boolean flag = false;
        n = flightTicket.length;
        for (int i = 0; i < flightTicket.length; i++) {
            if(flightTicket[i] instanceof BusinessClassTicket) {
                BusinessClassTicket bct = new BusinessClassTicket();
                bct = (BusinessClassTicket)flightTicket[i];
                if (bct.getBusinessClassId().equals(BusinessClassId)) {
                    flag = true;
                    for (int j = i; j < flightTicket.length - 1; j++) {
                        flightTicket[j] = flightTicket[j + 1];
                    }
                    flightTicket = Arrays.copyOf(flightTicket, n - 1);
                    n--;
                }
            }
        }
        if(flag) 
            System.out.println("Da xoa chuyen bay!");
        else
            System.out.println("Khong xoa chuyen bay!");
    }




    public void addElement(EconomyClassTicket ect) {
        n = flightTicket.length;  
        flightTicket = Arrays.copyOf(flightTicket, n + 1);
        flightTicket[n] = new EconomyClassTicket(ect);   
    }

    public void addElement(BusinessClassTicket bct) {
        n = flightTicket.length;  
        flightTicket = Arrays.copyOf(flightTicket, n + 1);
        flightTicket[n] = new BusinessClassTicket(bct);   
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        return s;
    }
}
