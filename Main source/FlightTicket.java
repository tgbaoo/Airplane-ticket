import java.util.Scanner;
import java.io.*;

public class FlightTicket { // VE CHUYEN BAY
    // Attribute
    private String flightTicketId; // Ma ve
    private String flightId; // ma chuyen bay
    private int ticketType; // loai ve (0 - Khu hoi, 1 - mot chieu)
    private int ticketPrice; // gia ve

    public FlightTicket() {
    }

    public FlightTicket(String flightTicketId, String flightId, int ticketType, int ticketPrice) {
        this.flightTicketId = flightTicketId;
        this.flightId = flightId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public FlightTicket(FlightTicket ft) {
        flightTicketId = ft.flightTicketId;
        flightId = ft.flightId;
        ticketType = ft.ticketType;
        ticketPrice = ft.ticketPrice;
    }

    public String getFlightTicketId() {
        return flightTicketId;
    }

    public void setFlightTicketId(String flightTicketId) {
        this.flightTicketId = flightTicketId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Flight Ticket ID: ");
        flightTicketId = sc.nextLine();
        System.out.println("Enter Flight ID: ");
        flightId = sc.nextLine();
        System.out.println("Enter Ticket Type: \n 0: Round Tip \n 1: One Way");
        ticketType = sc.nextInt();
        System.out.println("Enter Ticket Price: ");
        ticketPrice = sc.nextInt();
    }

    public void output() {
        System.out.print("|" + flightTicketId + tableOutput(flightTicketId, 9) +
                flightId + tableOutput(flightId, 15));
        if (ticketType == 0) {
            System.out.print("Khu hoi" + tableOutput("Khu hoi", 9));
        } else if (ticketType == 1) {
            System.out.print("Mot chieu" + tableOutput("Mot chieu", 9));
        }

        System.out.print(ticketPrice + tableOutput(Integer.toString(ticketPrice), 10));
    }

    public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("..\\Source\\flightTicket.txt", Boolean.TRUE));
        outStream.writeUTF(flightTicketId);
        outStream.writeUTF(flightId);
        outStream.writeInt(ticketType);
        outStream.writeInt(ticketPrice);
        outStream.close();
    }

    public String tableOutput(String m, int n) {
        String s = "";
        for(int i = 0; i < n - m.length(); i++) {
            s = s + " ";
        }
        s = s + "|";
        return s;
    }
}