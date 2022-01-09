// package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class AirplaneList implements ListInterface{
    int n;
    Airplane[] airplaneList = new Airplane[1];
    Scanner sc = new Scanner(System.in);

    public AirplaneList() {

    }

    public AirplaneList(Airplane[] airplaneList, int n) {
        this.airplaneList = airplaneList;
        this.n = n;
    }

    public AirplaneList(AirplaneList al) {
        airplaneList = al.airplaneList;
        n = al.n;
    }

    public Airplane[] getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(Airplane[] airplaneList) {
        this.airplaneList = airplaneList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }


    public void input() {
        System.out.println("How many airplane you want to add? ");
        n = sc.nextInt();
        airplaneList = new Airplane[n];
        for (int i = 0; i < n; i++) {
            airplaneList[i] = new Airplane();
            System.out.println("Airplane " + (i + 1) + ": ");
            airplaneList[i].input();
        }
    }

    public void output() {
        System.out.println("============================================Danh sach may bay================================================");
        System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
        System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
        System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
        for (int i = 0; i < airplaneList.length; i++) {
            airplaneList[i].output();
        }
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Them may bay-----");
        System.out.print("Nhap so luong muon them: ");
        int k = Integer.parseInt(sc.nextLine());
        int t = 0;

        //Xin cap phat them
        n = airplaneList.length;
        airplaneList = Arrays.copyOf(airplaneList, n + k);
        // System.out.println("Check!");
        for (int i = n; i < n + k; i++) {
            sc = new Scanner(System.in);
            System.out.print("Nhap ma may bay: ");
            String a_id = sc.nextLine();
            do {
                t = 0;
                for (int j = 0; j < n; j++) {
                    if (a_id.equals(airplaneList[j].getAirplaneID())) {
                        System.out.println("Ma may bay da bi trung!");
                        t = 1;
                    }
                }
                if (t == 1) {
                    System.out.print("Nhap lai ma may bay: ");
                    a_id = sc.nextLine();
                }
            } while (t == 1);
            if (t == 0) {
                sc = new Scanner(System.in);
                System.out.print("Nhap ten may bay: ");
                String a_name = sc.nextLine();
                System.out.print("Nhap so luong ghe: ");
                int a_nos = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap mo ta: ");
                String a_de = sc.nextLine();
                System.out.println("Nhap ma hang may bay: ");
                String ac_id = sc.nextLine();
                airplaneList[i] = new Airplane(a_id, a_name, a_nos, a_de, ac_id);
            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them may bay thanh cong");
        System.out.println("-----------***-----------");
    }

    // ---------------------------------DELETE--------------------------------------------
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa may bay theo ma may bay                    ||");
        System.out.println("||2. Xoa may bay theo ten may bay                   ||");
        System.out.println("||3. Xoa may bay theo so ghe                        ||");
        System.out.println("||4. Xoa may bay theo mo ta                         ||");
        System.out.println("||4. Xoa may bay theo ma hang may bay               ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa may bay theo ma may bay?[y/n]: ");
                String k = sc.nextLine();
                switch (k) {
                    case "y": {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma may bay can xoa: ");
                        String a_id = sc.nextLine();
                        removeAirplaneByID(a_id);
                        break;

                    }
                    case "n": {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 2: {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa may bay theo ten may bay?[y/n]: ");
                String k = sc.nextLine();
                switch (k) {
                    case "y": {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ten may bay can xoa: ");
                        String a_name = sc.nextLine();
                        removeAirplaneByName(a_name);
                        break;

                    }
                    case "n": {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 3: {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa chuyen bay theo so ghe?[y/n]: ");
                String k = sc.nextLine();
                switch (k) {
                    case "y": {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap so ghe cua may bay can xoa: ");
                        int a_nos = Integer.parseInt(sc.nextLine());
                        removeAirplaneByNumberOfSeats(a_nos);
                        break;

                    }
                    case "n": {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 4: {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa may bay theo mo ta?[y/n]: ");
                String k = sc.nextLine();
                switch (k) {
                    case "y": {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap mo ta cua may bay can xoa: ");
                        String a_des = sc.nextLine();
                        removeAirplaneByDescription(a_des);
                        break;

                    }
                    case "n": {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
            case 5: {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa may bay theo hang may bay?[y/n]: ");
                String k = sc.nextLine();
                switch (k) {
                    case "y": {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap hang may bay cua may bay can xoa: ");
                        String ac_id = sc.nextLine();
                        removeAirplaneByAirplaneCompanyID(ac_id);
                        break;

                    }
                    case "n": {
                        System.out.println("Thoat xoa may bay!");
                        break;
                    }
                }
                break;
            }
        }
    }
    // -----------------------------------END DELETE-----------------------------------


    public void removeAirplaneByID(String airplaneID) {
        boolean flag=false;
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getAirplaneID().indexOf(airplaneID) != -1) {
                flag=true;
                for (int j = i; j < airplaneList.length - 1; j++) {
                    airplaneList[j] = airplaneList[j + 1];
                }
            }
            airplaneList = Arrays.copyOf(airplaneList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa may bay!");
        System.out.println("Khong xoa may bay!");
    }

    public void removeAirplaneByName(String airplaneName) {
        boolean flag=false;
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getAirplaneName().indexOf(airplaneName) != -1) {
                flag=true;
                for (int j = i; j < airplaneList.length - 1; j++) {
                    airplaneList[j] = airplaneList[j + 1];
                }
            }
            airplaneList = Arrays.copyOf(airplaneList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa may bay!");
        System.out.println("Khong xoa may bay!");
    }

    public void removeAirplaneByNumberOfSeats(int nos) {
        boolean flag=false;
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getNumberOfSeats() == nos) {
                flag=true;
                for (int j = i; j < airplaneList.length - 1; j++) {
                    airplaneList[j] = airplaneList[j + 1];
                }
            }
            airplaneList = Arrays.copyOf(airplaneList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa may bay!");
        System.out.println("Khong xoa may bay!");
    }

    public void removeAirplaneByDescription(String description) {
        boolean flag=false;
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getDescription().indexOf(description) != -1) {
                flag=true;
                for (int j = i; j < airplaneList.length - 1; j++) {
                    airplaneList[j] = airplaneList[j + 1];
                }
            }
            airplaneList = Arrays.copyOf(airplaneList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa may bay!");
        System.out.println("Khong xoa may bay!");
    }

    public void removeAirplaneByAirplaneCompanyID(String airplaneCompanyID) {
        boolean flag=false;
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getAirplaneID().indexOf(airplaneCompanyID) != -1) {
                flag=true;
                for (int j = i; j < airplaneList.length - 1; j++) {
                    airplaneList[j] = airplaneList[j + 1];
                }
            }
            airplaneList = Arrays.copyOf(airplaneList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa may bay!");
        System.out.println("Khong xoa may bay!");
    }


    // ------------------------------SEARCH-------------------------------------
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||--------Chon thao tac tim kiem--------||");
        System.out.println("||1. Tim kiem theo ma may bay           ||");
        System.out.println("||2. Tim kiem theo ten may bay          ||");
        System.out.println("||3. Tim kiem theo so ghe               ||");
        System.out.println("||4. Tim kiem theo mo ta                ||");
        System.out.println("||5. Tim kiem theo ma hang may bay      ||");
        System.out.println("||------------------***-----------------||");
        System.out.print("Nhap lua chon cua ban: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: {
                //ma may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma may bay can tim: ");
                String a_id = sc.nextLine();
                System.out.println("============================================Danh sach may bay================================================");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneList[i].getAirplaneID().equals(a_id))
                        airplaneList[i].output();
                    }
                    break;
            }
            case 2: {
                //ten may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ten may bay can tim: ");
                String a_name = sc.nextLine();
                System.out.println("============================================Danh sach may bay================================================");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneList[i].getAirplaneName().equals(a_name))
                        airplaneList[i].output();
                }
                break;
            }
            case 3: {
                //So ghe
                sc = new Scanner(System.in);
                System.out.print("Nhap so ghe cua may bay ban can tim: ");
                int a_nos = Integer.parseInt(sc.nextLine());
                System.out.println("============================================Danh sach may bay================================================");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneList[i].getNumberOfSeats() == a_nos)
                        airplaneList[i].output();
                }
                break;
            }
            case 4: {
                //mo ta
                sc = new Scanner(System.in);
                System.out.print("Nhap mo ta cua may bay can tim: ");
                String a_des = sc.nextLine();
                System.out.println("============================================Danh sach may bay================================================");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneList[i].getDescription().equals(a_des))
                        airplaneList[i].output();
                }
                break;
            }
            case 5: {
                //ma hang may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma hang may bay cua may bay can tim: ");
                String ac_id = sc.nextLine();
                System.out.println("============================================Danh sach may bay================================================");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                System.out.println("|   Ma may bay   |        Ten may bay       |  So luong ghe |          Mo ta           |   Ma hang may bay  |");
                System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneList[i].getDescription().equals(ac_id))
                        airplaneList[i].output();
                }
                break;
            }
        }
    }    // -----------------------------------END SEARCH-----------------------------------------

    // -----------------------------EDIT------------------------------

    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma may bay can sua: ");
        String k = sc.nextLine();
        int t = 0;
        for (int i = 0; i < airplaneList.length; i++) {
            t = 0;
            do {
                if (k.equals(airplaneList[i].getAirplaneID())) {
                    t = 1;
                    System.out.println("||---------Chon thao tac sua--------||");
                    System.out.println("||1. Sua ma may bay                 ||");
                    System.out.println("||2. Sua ten may bay                ||");
                    System.out.println("||3. Sua so ghe                     ||");
                    System.out.println("||4. Sua mo ta                      ||");
                    System.out.println("||5. Sua hang may bay               ||");
                    System.out.println("||----------------***---------------||");
                    System.out.print("Nhap lua chon: ");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1: {
                            System.out.println("Nhap ma may bay moi: ");
                            String na_id = sc.nextLine();
                            airplaneList[i].setAirplaneID(na_id);
                            System.out.println("Da sua ma may bay!");
                            break;


                        }
                        case 2: {
                            System.out.println("Nhap ten may bay moi: ");
                            String na_name = sc.nextLine();
                            airplaneList[i].setAirplaneName(na_name);
                            System.out.println("Da sua ten may bay!");
                            break;


                        }
                        case 3: {
                            System.out.println("Nhap so ghe moi: ");
                            int na_nos = Integer.parseInt(sc.nextLine());
                            airplaneList[i].setNumberOfSeats(na_nos);
                            System.out.println("Da sua so ghe!");
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap mo ta may bay moi: ");
                            String na_des = sc.nextLine();
                            airplaneList[i].setDescription(na_des);
                            System.out.println("Da sua mo ta may bay!");
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap ma hang may bay moi: ");
                            String nac_id = sc.nextLine();
                            airplaneList[i].setAirplaneCompanyID(nac_id);
                            System.out.println("Da sua ma hang may bay!");
                            break;
                        }
                    }
                } else {
                    System.out.println("Ban da nhap sai ma may bay, vui long nhap lai!");
                }
            } while (t == 0);
        }
    }


    // -----------------------------END EDIT------------------------------
    public Airplane searchAirplaneById(String airplaneID) {
        for (int i = 0; i < airplaneList.length; i++) {
            if (airplaneList[i].getAirplaneID().equals(airplaneID)) {
                return airplaneList[i];
            }
        }
        return null;
    }

    public void addElement(Airplane al) {
        n = airplaneList.length;
        airplaneList = Arrays.copyOf(airplaneList, n + 1);
        airplaneList[n] = new Airplane(al);
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for (int i = 0; i < n - m.length(); i++) {
            s = s + " ";
        }
        return s;
    }
}
