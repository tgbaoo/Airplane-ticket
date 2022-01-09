// package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AirplaneCompanyList {
    int n;
    AirplaneCompany[] airplaneCompanyList = new AirplaneCompany[1];
    Scanner sc = new Scanner(System.in);

    public AirplaneCompanyList(){

    }
    public AirplaneCompanyList(int n, AirplaneCompany[] airplaneCompanyList){
        this.n=n;
        this.airplaneCompanyList=airplaneCompanyList;
    }
    public AirplaneCompanyList(AirplaneCompanyList acl){
        this.n=acl.n;
        this.airplaneCompanyList=acl.airplaneCompanyList;

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public AirplaneCompany[] getAirplaneCompanyList() {
        return airplaneCompanyList;
    }

    public void setAirplaneCompanyList(AirplaneCompany[] airplaneCompanyList) {
        this.airplaneCompanyList = airplaneCompanyList;
    }

    public void input() {
        System.out.println("How many airplane company you want to add? ");
        n = sc.nextInt();
        airplaneCompanyList = new AirplaneCompany[n];
        for (int i = 0; i < n; i++) {
            airplaneCompanyList[i] = new AirplaneCompany();
            System.out.println("Airplane " + (i + 1) + ": ");
            airplaneCompanyList[i].input();
        }
    }
    public void output(){
        System.out.println("====================Danh sach hang may bay=====================");
        System.out.println("|---------------------|---------------------------------------|");
        System.out.println("|   Ma hang may bay   |              Ten hang may bay         |");
        System.out.println("|---------------------|---------------------------------------|");
        for (int i = 0; i < airplaneCompanyList.length; i++) {
            airplaneCompanyList[i].output();
        }
    }
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Them hang may bay-----");
        System.out.print("Nhap so hang may bay muon them: ");
        int k = Integer.parseInt(sc.nextLine());
        int t = 0;

        //Xin cap phat them
        n = airplaneCompanyList.length;
        airplaneCompanyList = Arrays.copyOf(airplaneCompanyList, n + k);
        // System.out.println("Check!");
        for(int i = n; i < n + k; i++) {
            sc = new Scanner(System.in);
            System.out.print("Nhap ma hang may bay: ");
            String ac_id = sc.nextLine();
            do {
                t = 0;
                for(int j = 0; j < n; j++) {
                    if(ac_id.equals(airplaneCompanyList[j].getAirplaneCompanyID())) {
                        System.out.println("Ma hang may bay da bi trung!");
                        t = 1;
                    }
                }
                if(t == 1) {
                    System.out.print("Nhap lai ma hang may bay: ");
                    ac_id = sc.nextLine();
                }
            } while(t == 1);
            if(t == 0) {
                sc = new Scanner(System.in);
                System.out.print("Nhap ten hang may bay: ");
                String ac_name=sc.nextLine();
                airplaneCompanyList[i] = new AirplaneCompany(ac_id,ac_name);
            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them hang may bay thanh cong");
        System.out.println("-----------***-----------");
    }

    // ---------------------------------DELETE--------------------------------------------
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||-----------------Chon thao tac xoa----------------||");
        System.out.println("||1. Xoa hang may bay theo ma hang                  ||");
        System.out.println("||2. Xoa hang may bay theo ten hang                 ||");
        System.out.println("||------------------------***-----------------------||");
        System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
            case 1:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa hang may bay theo ma hang?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma hang may bay can xoa: ");
                        String ac_id = sc.nextLine();
                        removeAirplaneCompanyByID(ac_id);
                        break;

                    }
                    case "n":
                    {
                        System.out.println("Thoat xoa hang may bay!");
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                sc = new Scanner(System.in);
                System.out.print("Ban chac muon xoa hang may bay theo ten hang?[y/n]: ");
                String k = sc.nextLine();
                switch(k){
                    case "y":
                    {
                        sc = new Scanner(System.in);
                        System.out.println("Nhap ma hang may bay can xoa: ");
                        String ac_name = sc.nextLine();
                        removeAirplaneCompanyByName(ac_name);
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

        }
    }
    // -----------------------------------END DELETE-----------------------------------
    public void removeAirplaneCompanyByID(String airplaneCompanyID) {
        boolean flag=false;
        for (int i = 0; i < airplaneCompanyList.length; i++) {
            if (airplaneCompanyList[i].getAirplaneCompanyID().indexOf(airplaneCompanyID) != -1) {
                flag=true;
                for (int j = i; j < airplaneCompanyList.length - 1; j++) {
                    airplaneCompanyList[j] = airplaneCompanyList[j + 1];
                }
            }
            airplaneCompanyList = Arrays.copyOf(airplaneCompanyList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa hang may bay!");
        System.out.println("Khong xoa vhang may bay!");
    }
    public void removeAirplaneCompanyByName(String airplaneCompanyName) {
        boolean flag=false;
        for (int i = 0; i <airplaneCompanyList.length; i++) {
            flag=true;
            if (airplaneCompanyList[i].getAirplaneCompanyName().indexOf(airplaneCompanyName) != -1) {
                for (int j = i; j < airplaneCompanyList.length - 1; j++) {
                    airplaneCompanyList[j] = airplaneCompanyList[j + 1];
                }
            }
            airplaneCompanyList = Arrays.copyOf(airplaneCompanyList, n - 1);
            n--;
        }
        if(flag)
            System.out.println("Da xoa hang may bay!");
        System.out.println("Khong xoa vhang may bay!");
    }
    // ------------------------------SEARCH-------------------------------------
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("||--------Chon thao tac tim kiem--------||");
        System.out.println("||1. Tim kiem theo ma hang may bay      ||");
        System.out.println("||2. Tim kiem theo ten hang may bay     ||");
        System.out.println("||------------------***-----------------||");
        System.out.print("Nhap lua chon cua ban: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: {
                //ma may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ma may bay can tim: ");
                String ac_id = sc.nextLine();
                System.out.println("====================Danh sach hang may bay=====================");
                System.out.println("|---------------------|---------------------------------------|");
                System.out.println("|   Ma hang may bay   |              Ten hang may bay         |");
                System.out.println("|---------------------|---------------------------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneCompanyList[i].getAirplaneCompanyID().equals(ac_id))
                    airplaneCompanyList[i].output();
                }
                break;
            }
            case 2: {
                //ten may bay
                sc = new Scanner(System.in);
                System.out.print("Nhap ten may bay can tim: ");
                String ac_name = sc.nextLine();
                System.out.println("====================Danh sach hang may bay=====================");
                System.out.println("|---------------------|---------------------------------------|");
                System.out.println("|   Ma hang may bay   |              Ten hang may bay         |");
                System.out.println("|---------------------|---------------------------------------|");
                for (int i = 0; i < n; i++) {
                    if (airplaneCompanyList[i].getAirplaneCompanyName().equals(ac_name))
                        airplaneCompanyList[i].output();
                }
                break;
            }
        }
    }    // -----------------------------------END SEARCH-----------------------------------------
    //--------------------------------EDIT--------------------------------------------
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma may bay can sua: ");
        String k = sc.nextLine();
        int t = 0;
        for (int i = 0; i < airplaneCompanyList.length; i++) {
            t = 0;
            do {
                if (k.equals(airplaneCompanyList[i].getAirplaneCompanyID())) {
                    t = 1;
                    System.out.println("||---------Chon thao tac sua--------||");
                    System.out.println("||1. Sua ma hang may bay            ||");
                    System.out.println("||2. Sua ten hang may bay           ||");
                    System.out.println("||----------------***---------------||");
                    System.out.print("Nhap lua chon: ");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c) {
                        case 1: {
                            System.out.println("Nhap ma may bay moi: ");
                            String nac_id = sc.nextLine();
                            airplaneCompanyList[i].setAirplaneCompanyID(nac_id);
                            System.out.println("Da sua ma hang may bay!");
                            break;


                        }
                        case 2: {
                            System.out.println("Nhap ten hang may bay moi: ");
                            String nac_name = sc.nextLine();
                            airplaneCompanyList[i].setAirplaneCompanyName(nac_name);
                            System.out.println("Da sua ten hang may bay!");
                            break;


                        }

                    }
                } else {
                    System.out.println("Ban da nhap sai ma hang may bay, vui long nhap lai!");
                }
            } while (t == 0);
        }
    }


    // -----------------------------END EDIT------------------------------

    public AirplaneCompany searchAirplaneCompanyById(String airplaneCompanyID) {
        for (int i = 0; i < airplaneCompanyList.length; i++) {
            if (airplaneCompanyList[i].getAirplaneCompanyID().equals(airplaneCompanyID)) {
                return airplaneCompanyList[i];
            }
        }
        return null;
    }
    public void addElement(AirplaneCompany ac) {
        n = airplaneCompanyList.length;
        airplaneCompanyList = Arrays.copyOf(airplaneCompanyList, n + 1);
        airplaneCompanyList[n] = new AirplaneCompany(ac);
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        return s;
    }
}
