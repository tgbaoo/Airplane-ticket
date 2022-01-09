import java.util.Scanner;
import java.io.*;

public class BusinessClassTicket extends FlightTicket { // VE PHO THONG
    // Attribute
    // private int chairNumber; // so ghe
    private String waitingRoomId; // ma phong cho
    private String businessClassId; // ma khoang

    public BusinessClassTicket() {
    }

    public BusinessClassTicket(String flightTicketId, String flightId, int ticketType, /*String boardingTime,*/
            int ticketPrice, String waitingRoomId, String businessClassId) {
        super(flightTicketId, flightId, ticketType, ticketPrice);
        this.waitingRoomId = waitingRoomId;
        this.businessClassId = businessClassId;
    }

    public BusinessClassTicket(BusinessClassTicket bct) {
        super((BusinessClassTicket) bct);
        waitingRoomId = bct.waitingRoomId;
        businessClassId = bct.businessClassId;
    }

    // public int getChairNumber() {
    //     return chairNumber;
    // }

    // public void setChairNumber(int chairNumber) {
    //     this.chairNumber = chairNumber;
    // }

    public String getWaitingRoomId() {
        return waitingRoomId;
    }

    public void setWaitingRoomId(String waitingRoomId) {
        this.waitingRoomId = waitingRoomId;
    }

    public String getBusinessClassId() {
        return businessClassId;
    }

    public void setBusinessClassId(String businessClassId) {
        this.businessClassId = businessClassId;
    }


    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        // System.out.println("Enter Chair Number: ");
        // chairNumber = sc.nextInt();
        System.out.println("Enter Waiting Room ID: ");
        waitingRoomId = sc.nextLine();
        System.out.println("Enter Business Class ID: ");
        businessClassId = sc.nextLine();
    }

    
    @Override
    public void output() {
        System.out.println("|---------|---------------|---------|----------|----------------|-----------|");
		System.out.println("|  Ma ve  | Ma chuyen bay | Loai ve |  Gia ve  |  Ma phong cho  | Ma khoang |");
		System.out.println("|---------|---------------|---------|----------|----------------|-----------|");
        super.output();
        System.out.println(/*chairNumber + tableOutput(Integer.toString(chairNumber), 12)*/
                            waitingRoomId + tableOutput(waitingRoomId, 16)
                            +businessClassId + tableOutput(businessClassId, 11));
        System.out.println("|---------|---------------|---------|----------|----------------|-----------|");
    }

    @Override
    public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("..\\Source\\flightTicket.txt", Boolean.TRUE));
        outStream.writeInt(1);
        super.writeFile();
        outStream.writeUTF(waitingRoomId);
        outStream.writeUTF(businessClassId);
        outStream.close();
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for (int i = 0; i < n - m.length(); i++) {
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}
