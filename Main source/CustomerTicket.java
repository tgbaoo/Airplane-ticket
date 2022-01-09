// package com.company;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CustomerTicket {
    private String customerTicketID;//mã vé-kh
    private String customerID;//mã khách hàng
    private String ticketID;// mã vé
    private String boardingTime; // gio len may bay
    private int seatNumber;// số ghế
    Scanner sc = new Scanner(System.in);

    public CustomerTicket() {

    }

    public CustomerTicket(String customerTicketID, String customerID, String ticketID, String boardingTime, int seatNumber) {
        this.customerTicketID = customerTicketID;
        this.customerID = customerID;
        this.ticketID = ticketID;
        this.boardingTime = boardingTime;
        this.seatNumber = seatNumber;
    }

    public CustomerTicket(CustomerTicket customerTicket) {
        customerTicket.customerTicketID = this.customerTicketID;
        customerTicket.customerID = this.customerID;
        customerTicket.ticketID = this.ticketID;
        customerTicket.boardingTime = this.boardingTime;
        customerTicket.seatNumber = this.seatNumber;
    }

    public void input() {
        System.out.println("Enter customer ticket ID: ");
        customerTicketID = sc.nextLine();
        System.out.println("Enter customer ID: ");
        customerID = sc.nextLine();
        System.out.println("Enter ticket ID: ");
        ticketID = sc.nextLine();
        System.out.println("Enter boarding time: ");
        boardingTime = sc.nextLine();
        System.out.println("Enter seat number: ");
        seatNumber = sc.nextInt();
    }

    public void output() {
        System.out.println("|"+customerTicketID+tableOutput(customerTicketID, 22)+
                customerID+tableOutput(customerID, 16)+
                ticketID+tableOutput(ticketID, 16)+
                boardingTime+tableOutput(boardingTime, 20)+
                seatNumber+tableOutput(String.valueOf(seatNumber), 10));
        System.out.println("|----------------------|----------------|----------------|--------------------|----------|");
    }

    public void writeFile(){
        try {
            DataOutputStream outStream = new DataOutputStream(new FileOutputStream("customerticket.txt", Boolean.TRUE));
            outStream.writeUTF(customerTicketID);
            outStream.writeUTF(customerID);
            outStream.writeUTF(ticketID);
            outStream.writeUTF(boardingTime);
            outStream.writeInt(seatNumber);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCustomerTicketID() {
        return customerTicketID;
    }

    public void setCustomerTicketID(String customerTicketID) {
        this.customerTicketID = customerTicketID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
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

