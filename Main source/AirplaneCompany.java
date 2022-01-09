// package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class AirplaneCompany {
    private String airplaneCompanyID;// mã hãng máy bay
    private String airplaneCompanyName;// tên hãng máy bay
    Scanner sc = new Scanner(System.in);

    public AirplaneCompany() {

    }
    
    public AirplaneCompany(String airplaneCompanyID, String airplaneCompanyName) {
        this.airplaneCompanyID = airplaneCompanyID;
        this.airplaneCompanyName = airplaneCompanyName;
    }

    public AirplaneCompany(AirplaneCompany airplaneCompany) {
        airplaneCompany.airplaneCompanyID = this.airplaneCompanyID;
        airplaneCompany.airplaneCompanyName = this.airplaneCompanyName;
    }

    public String getAirplaneCompanyID() {
        return airplaneCompanyID;
    }

    public void setAirplaneCompanyID(String airplaneCompanyID) {
        this.airplaneCompanyID = airplaneCompanyID;
    }

    public String getAirplaneCompanyName() {
        return airplaneCompanyName;
    }

    public void setAirplaneCompanyName(String airplaneCompanyName) {
        this.airplaneCompanyName = airplaneCompanyName;
    }

    public void input() {
        System.out.println("Enter airplane company ID: ");
        airplaneCompanyID = sc.nextLine();
        System.out.println("Enter airplane company name: ");
        airplaneCompanyName = sc.nextLine();
    }

    public void output() {
        System.out.println("|"+airplaneCompanyID+tableOutput(airplaneCompanyID, 21)+
                airplaneCompanyName+tableOutput(airplaneCompanyName, +39));
        System.out.println("|---------------------|---------------------------------------|");
    }
    public void writeFile() {
        try {
            DataOutputStream outStream = new DataOutputStream(new FileOutputStream("airplanecompany.txt", Boolean.TRUE));
            outStream.writeUTF(airplaneCompanyID);
            outStream.writeUTF(airplaneCompanyName);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}
