import java.util.Scanner;
import java.io.*;

public class EconomyClassTicket extends FlightTicket { // VE PHO THONG
    // Attribute
    private String chairNumber; // so ghe

    public EconomyClassTicket() {
    }

    public EconomyClassTicket(String flightTicketId, String flightId, int ticketType, int ticketPrice, String chairNumber) {
        super(flightTicketId, flightId, ticketType, ticketPrice);
        this.chairNumber = chairNumber;
    }

    public EconomyClassTicket(EconomyClassTicket ect) {
        super((EconomyClassTicket) ect);
        chairNumber = ect.chairNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }


    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Chair Number: ");
        chairNumber = sc.nextLine();
    }

    @Override
    public void output() {
        System.out.println("|---------|---------------|---------|----------|----------|");
		System.out.println("|  Ma ve  | Ma chuyen bay | Loai ve |  Gia ve  |  Ma Ghe  |");
		System.out.println("|---------|---------------|---------|----------|----------|");
        super.output();
        System.out.println(chairNumber + tableOutput(chairNumber, 10));
        System.out.println("|---------|---------------|---------|----------|----------|");

    }

    

    @Override
    public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("..\\Source\\flightTicket.txt", Boolean.TRUE));
        outStream.writeInt(0);
        super.writeFile();
        outStream.writeUTF(chairNumber);
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