// package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class Airplane {
    private String airplaneID; //mã máy bay
    private String airplaneName; // tên máy bay
    private int numberOfSeats;// số lượng ghế
    private String description;//miêu tả
    private String airplaneCompanyID;//mã hãng máy bay
    Scanner sc = new Scanner(System.in);

    public Airplane() {

    }

    public Airplane(String airplaneID, String airplaneName, int numberOfSeats, String description, String airplaneCompanyID) {
        this.airplaneID = airplaneID;
        this.airplaneName=airplaneName;
        this.numberOfSeats = numberOfSeats;
        this.description = description;
        this.airplaneCompanyID = airplaneCompanyID;
    }

    public Airplane(Airplane airplane) {
        airplane.airplaneID = this.airplaneID;
        airplane.airplaneName=this.airplaneName;
        airplane.numberOfSeats = this.numberOfSeats;
        airplane.description = this.description;
        airplane.airplaneCompanyID = this.airplaneCompanyID;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneID) {
        this.airplaneID = airplaneID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAirplaneCompanyID() {
        return airplaneCompanyID;
    }

    public void setAirplaneCompanyID(String airplaneCompanyID) {
        this.airplaneCompanyID = airplaneCompanyID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public void input() {
        System.out.println("Enter airplane ID: ");
        airplaneID = sc.nextLine();
        System.out.println("Enter airplane name: ");
        airplaneName=sc.nextLine();
        System.out.println("Enter number of seats: ");
        numberOfSeats = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter description: ");
        description = sc.nextLine();
        System.out.println("Enter airplane company ID: ");
        airplaneCompanyID = sc.nextLine();
    }

    public void output() {
        System.out.println("|"+airplaneID+tableOutput(airplaneID, 16)+
                airplaneName+tableOutput(airplaneName,26)+
                numberOfSeats+tableOutput(String.valueOf(numberOfSeats), 15)+
                description+tableOutput(description, 26)+
                airplaneCompanyID+tableOutput(airplaneID, 19));
        System.out.println("|----------------|--------------------------|---------------|--------------------------|--------------------|");
    }

    public void writeFile(){
        try {
            DataOutputStream outStream = new DataOutputStream(new FileOutputStream("airplane.txt", Boolean.TRUE));
            outStream.writeUTF(airplaneID);
            outStream.writeUTF(airplaneName);
            outStream.writeInt(numberOfSeats);
            outStream.writeUTF(description);
            outStream.writeUTF(airplaneCompanyID);
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
