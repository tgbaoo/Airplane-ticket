// package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerTicketList {
    int n;
    CustomerTicket[] customerTicketList= new CustomerTicket[0];
    Scanner sc= new Scanner(System.in);
    public CustomerTicketList(){

    }
    public CustomerTicketList(int n, CustomerTicket[] customerTicketList){
        this.n=n;
        this.customerTicketList=customerTicketList;
    }
    public CustomerTicketList(CustomerTicketList ctl){
        n=ctl.n;
        customerTicketList=ctl.customerTicketList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public CustomerTicket[] getCustomerTicketList() {
        return customerTicketList;
    }

    public void setCustomerTicketList(CustomerTicket[] customerTicketList) {
        this.customerTicketList = customerTicketList;
    }


    public void input() {
        System.out.println("How many customer ticket you want to add? ");
        n = sc.nextInt();
        customerTicketList = new CustomerTicket[n];
        for (int i = 0; i < n; i++) {
            customerTicketList[i] = new CustomerTicket();
            System.out.println("Customer ticket " + (i + 1) + ": ");
            customerTicketList[i].input();
        }
    }
    public void output(){
        System.out.println("==============================Danh sach ve khach hang=====================================");
        System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
        System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
        System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
        for (int i = 0; i < customerTicketList.length; i++) {
            customerTicketList[i].output();
        }
    }
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Them ve - khach hang-----");
        System.out.print("Nhap so luong ve-khach hang muon them: ");
        int k = Integer.parseInt(sc.nextLine());
        int t = 0;

        //Xin cap phat them
        n = customerTicketList.length;
        customerTicketList = Arrays.copyOf(customerTicketList, n + k);
        // System.out.println("Check!");
        for(int i = n; i < n + k; i++) {
            sc = new Scanner(System.in);
            System.out.print("Nhap ma ve-khach hang: ");
            String ct_id = sc.nextLine();
            do {
                t = 0;
                for(int j = 0; j < n; j++) {
                    if(ct_id.equals(customerTicketList[j].getCustomerTicketID())) {
                        System.out.println("Ma ve-khach hang bi trung!");
                        t = 1;
                    }
                }
                if(t == 1) {
                    System.out.print("Nhap lai ma ve-khach hang: ");
                    ct_id = sc.nextLine();
                }
            } while(t == 1);
            if(t == 0) {
                sc = new Scanner(System.in);
                System.out.print("Nhap ma khach hang: ");
                String c_id = sc.nextLine();
                System.out.print("Nhap ma ve: ");
                String t_id = sc.nextLine();
                System.out.print("Nhap gio len may bay: ");
                String bt = sc.nextLine();
                System.out.println("Nhap so ghe: ");
                int sn=Integer.parseInt(sc.nextLine());
                customerTicketList[i] = new CustomerTicket(ct_id, c_id, t_id, bt, sn);
            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them ve-khach hang thanh cong");
        System.out.println("-----------***-----------");
    }

    // ---------------------------------DELETE--------------------------------------------
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa ve-khach hang theo ma ve-khach hang        ||");
        System.out.println("||2. Xoa ve-khach hang theo ma khach hang           ||");
        System.out.println("||3. Xoa ve-khach hang theo ma ve                   ||");
        System.out.println("||4. Xoa ve-khach hang theo gio len may bay         ||");
        System.out.println("||4. Xoa ve-khach hang theo so ghe                  ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve-khach hang theo ma ve-khach hang?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma ve-khach hang can xoa: ");
                        String ct_id = sc.nextLine();
                        removeCustomerTicketByID(ct_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve-khach hang!");
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon ve-khach hang theo ma khach hang?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma khach hang thuoc ve-khach hang can xoa: ");
                        String c_id = sc.nextLine();
                        removeCustomerTicketByCustomerID(c_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve-khach hang theo ma ve?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap so ghe cua may bay can xoa: ");
                        String t_id = sc.nextLine();
                        removeCustomerTicketByTicketID(t_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve-khach hang!");
                        break;
                    }
                }
                break;
            }
            case 4:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve-khach hang theo gio len may bay?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap gio len may bay cua ve-khach hang: ");
                        String bt = sc.nextLine();
                        removeCustomerTicketByBoardingTime(bt);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 5:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa ve-khach hang theo so ghe?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap so ghe cua ve-khach hang ban muon xoa: ");
                        int sn = Integer.parseInt(sc.nextLine());
                        removeCustomerTicketBySeatNumber(sn);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa ve-khach hang!");
                        break;
                    }
                }
                break;
            }
        }
    }
    // -----------------------------------END DELETE-----------------------------------
    public void removeCustomerTicketByID(String customerTicketID) {
        boolean flag=false;
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getCustomerTicketID().indexOf(customerTicketID) != -1) {
                flag=true;
                for (int j = i; j < customerTicketList.length - 1; j++) {
                    customerTicketList[j] = customerTicketList[j + 1];
                }
            }
            customerTicketList = Arrays.copyOf(customerTicketList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa ve-khach hang!");
        System.out.println("Khong xoa ve-khach hang!");
    }
    public void removeCustomerTicketByCustomerID(String customerID) {
        boolean flag=false;
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getCustomerID().indexOf(customerID) != -1) {
                flag=true;
                for (int j = i; j < customerTicketList.length - 1; j++) {
                    customerTicketList[j] = customerTicketList[j + 1];
                }
            }
            customerTicketList = Arrays.copyOf(customerTicketList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa ve-khach hang!");
        System.out.println("Khong xoa ve-khach hang!");
    }
    public void removeCustomerTicketByTicketID(String ticketID) {
        boolean flag=false;
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getTicketID().indexOf(ticketID) != -1) {
                flag=true;
                for (int j = i; j < customerTicketList.length - 1; j++) {
                    customerTicketList[j] = customerTicketList[j + 1];
                }
            }
            customerTicketList = Arrays.copyOf(customerTicketList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa ve-khach hang!");
        System.out.println("Khong xoa ve-khach hang!");
    }
    public void removeCustomerTicketBySeatNumber(int sn) {
        boolean flag=false;
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getSeatNumber()==sn) {
                flag=true;
                for (int j = i; j < customerTicketList.length - 1; j++) {
                    customerTicketList[j] = customerTicketList[j + 1];
                }
            }
            customerTicketList = Arrays.copyOf(customerTicketList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa ve-khach hang!");
        System.out.println("Khong xoa ve-khach hang!");
    }
    public void removeCustomerTicketByBoardingTime(String bt) {
        boolean flag=false;
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getBoardingTime().indexOf(bt) != -1) {
                flag=true;
                for (int j = i; j < customerTicketList.length - 1; j++) {
                    customerTicketList[j] = customerTicketList[j + 1];
                }
            }
            customerTicketList = Arrays.copyOf(customerTicketList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa ve-khach hang!");
        System.out.println("Khong xoa ve-khach hang!");
    }

    // ------------------------------SEARCH-------------------------------------
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||--------Chon thao tac tim kiem--------||");
        System.out.println("||1. Tim kiem theo ma ve-khach hang     ||");
        System.out.println("||2. Tim kiem theo ma khach hang        ||");
        System.out.println("||3. Tim kiem theo ma ve                ||");
        System.out.println("||4. Tim kiem theo gio len may bay      ||");
        System.out.println("||5. Tim kiem theo so ghe               ||");
        System.out.println("||------------------***-----------------||");
        System.out.print("Nhap lua chon cua ban: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1:
            {
                //ma may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma ve-khach hang can tim: ");
                String ct_id = sc.nextLine();
                System.out.println("==============================Danh sach ve khach hang=====================================");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                for(int i = 0; i < n; i++) {
                    if(customerTicketList[i].getCustomerTicketID().equals(ct_id))
                        customerTicketList[i].output();
                }
                break;
            }
            case 2:
            {
                //ten may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma khach hang cua ve-khach hang can tim: ");
                String a_name = sc.nextLine();
                System.out.println("==============================Danh sach ve khach hang=====================================");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                for(int i = 0; i < n; i++) {
                    if(customerTicketList[i].getCustomerID().equals(a_name))
                        customerTicketList[i].output();
                }
                break;
            }
            case 3:
            {
                //So ghe
                sc = new Scanner(System.in);
                System.out.print("Nhap ma ve cua ve-khach hang can tim: ");
                String t_id=sc.nextLine();
                System.out.println("==============================Danh sach ve khach hang=====================================");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                for(int i = 0; i < n; i++) {
                    if(customerTicketList[i].getTicketID().equals(t_id))
                        customerTicketList[i].output();
                }
                break;
            }
            case 4:
            {
                //mo ta
                sc = new Scanner(System.in);
                System.out.print("Nhap gio len may bay cua ve-khach hang can tim: ");
                String bt = sc.nextLine();
                System.out.println("==============================Danh sach ve khach hang=====================================");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                for(int i = 0; i < n; i++) {
                    if(customerTicketList[i].getBoardingTime().equals(bt))
                        customerTicketList[i].output();
                }
                break;
            }
            case 5:
            {
                //ma hang may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap so ghe cua ve-khach hang can tim: ");
                int sn = Integer.parseInt(sc.nextLine());
                System.out.println("==============================Danh sach ve khach hang=====================================");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                System.out.println("|   Ma ve-khach hang   |  Ma khach hang |      Ma ve     |   Gio len may bay  |  So ghe  |");
                System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
                for(int i = 0; i < n; i++) {
                    if(customerTicketList[i].getSeatNumber()==sn)
                        customerTicketList[i].output();
                }
                break;
            }
        }
    }    // -----------------------------------END SEARCH-----------------------------------------

    // -----------------------------EDIT------------------------------
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma ve-khach hang can sua: ");
        String k = sc.nextLine();
        int t = 0;
        for (int i = 0; i < customerTicketList.length; i++) {
            t = 0;
            do {
                if (k.equals(customerTicketList[i].getCustomerTicketID())) {
                    t = 1;
                    System.out.println("||---------Chon thao tac sua--------||");
                    System.out.println("||1. Sua ma ve-khach hang           ||");
                    System.out.println("||2. Sua ma khach hang              ||");
                    System.out.println("||3. Sua ma ve                      ||");
                    System.out.println("||4. Sua gio len may bay            ||");
                    System.out.println("||5. Sua so ghe                     ||");
                    System.out.println("||----------------***---------------||");
                    System.out.print("Nhap lua chon: ");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1: {
                            System.out.println("Nhap ma ve-khach hang moi: ");
                            String nct_id = sc.nextLine();
                            customerTicketList[i].setCustomerTicketID(nct_id);
                            System.out.println("Da sua ma ve-khach hang!");
                            break;
                        }
                        case 2: {
                            System.out.println("Nhap ma khach hang moi: ");
                            String nc_id = sc.nextLine();
                            customerTicketList[i].setCustomerID(nc_id);
                            System.out.println("Da sua ma khach hang!");
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap ma ve moi: ");
                            String nt_id = sc.nextLine();
                            customerTicketList[i].setTicketID(nt_id);
                            System.out.println("Da sua ma ve!");
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap gio len may bay moi: ");
                            String nbt = sc.nextLine();
                            customerTicketList[i].setBoardingTime(nbt);
                            System.out.println("Da sua mo ta may bay!");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap so ghe moi: ");
                            int nsn = Integer.parseInt(sc.nextLine());
                            customerTicketList[i].setSeatNumber(nsn);
                            System.out.println("Da sua so ghe!");
                            break;
                        }
                    }

                } else {
                    System.out.println("Ban da nhap sai ma ve-khach hang, vui long nhap lai!");
                }

                }while (t == 0) ;
        }
    }

    // -----------------------------END EDIT------------------------------
    public CustomerTicket searchCustomerTicketById(String customerTicketID) {
        for (int i = 0; i < customerTicketList.length; i++) {
            if (customerTicketList[i].getCustomerTicketID().equals(customerTicketID)) {
                return customerTicketList[i];
            }
        }
        return null;
    }
    public void addElement(CustomerTicket ct) {
        n = customerTicketList.length;
        customerTicketList = Arrays.copyOf(customerTicketList, n + 1);
        customerTicketList[n] = new CustomerTicket(ct);
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        return s;
    }

}
