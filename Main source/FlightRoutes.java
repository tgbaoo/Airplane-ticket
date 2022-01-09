// package DOANOOP;
// package AirplaneTicketFinal;
// package AirplaneTicket;
import java.util.Scanner;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Scanner;

public class FlightRoutes { // TUYEN BAY
	// Attribute
	private String flightRouteId; // ma tuyen bay
	private String takeOffAirport; // San Bay Cat Canh;
	private String landingAirport;// San Bay Ha Canh;
	private String takeOffTime; // gio cat canh
	private String landingTime; // gio ha canh

	public FlightRoutes() {
	}

	public FlightRoutes(String flightRouteId, String takeOffAirport, String landingAirport, String takeOffTime, String landingTime) {
		this.flightRouteId = flightRouteId;
		this.takeOffAirport = takeOffAirport;
		this.landingAirport = landingAirport;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
	}

	public FlightRoutes(FlightRoutes a) {
		takeOffAirport = a.takeOffAirport;
		landingAirport = a.landingAirport;
		flightRouteId = a.flightRouteId;
		takeOffTime = a.takeOffTime;
		landingTime = a.landingTime;
	}

	public String getFlightRouteId() {
		return flightRouteId;
	}

	public void setFlightRouteId(String flightRouteId) {
		this.flightRouteId = flightRouteId;
	}

	public String getTakeOffAirport() {
		return takeOffAirport;
	}

	public void setTakeOffAirport(String takeOffAirport) {
		this.takeOffAirport = takeOffAirport;
	}

	public String getLandingAirport() {
		return landingAirport;
	}

	public void setLandingAirport(String landingAirport) {
		this.landingAirport = landingAirport;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public void input() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Flight Route ID: ");
		flightRouteId = in.nextLine();
		System.out.println("Enter Take Off Airport: ");
		takeOffAirport = in.nextLine();
		System.out.println("Enter Landing Airport: ");
		landingAirport = in.nextLine();
		System.out.println("Enter Take Off Time:");
		takeOffTime = in.nextLine();
		System.out.println("Enter Landing Time: ");
		landingTime = in.nextLine();
	}

	public void output() {
		System.out.print("| "+flightRouteId+tableOutput(flightRouteId, 0)
		+takeOffAirport+tableOutput(takeOffAirport, 13)
		+landingAirport+tableOutput(landingAirport, 13)
		+takeOffTime+tableOutput(takeOffTime, 14)
		+landingTime+tableOutput(landingTime, 14)
				);
		System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|---------------|-------------|--------------|");
	}
	
	public void writeFile() throws IOException{
		 DataOutputStream outStream = new DataOutputStream(new FileOutputStream("flightroutes1.txt", Boolean.TRUE));
		 outStream.writeUTF(flightRouteId);
		 outStream.writeUTF(takeOffAirport);
		 outStream.writeUTF(landingAirport);
		 outStream.writeUTF(takeOffTime);
		 outStream.writeUTF(landingTime);
		 outStream.close();
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
