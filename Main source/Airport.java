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
public class Airport { // SAN BAY
	// Attribute
	Scanner in = new Scanner(System.in);
	private String airportID; // Lưu trữ mã sân bay
	private String airportName; // Lưu trữ tên sân bay
	private String city; // Lưu trữ tên thành phố có cái sân bay đó
	public Airport() {
		
	}
	public Airport(String airportID, String airportName, String city) {
		this.airportID = airportID;
		this.airportName = airportName;
		this.city = city;
	}

	public Airport(Airport a) {
		airportID = a.airportID;
		airportName = a.airportName;
		city = a.city;
	}

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void test() {
		System.out.println("test");
	}
	public void input() {
		System.out.println("Enter Airport ID: ");
		airportID = in.nextLine();
		System.out.println("Enter Airport Name: ");
		airportName = in.nextLine();
		System.out.println("Enter Airport City: ");
		city = in.nextLine();
	}

	public void output() {
		System.out.print("| "+airportID +tableOutput(airportID, 13)
		+airportName +tableOutput(airportName, 13)
		+city + tableOutput(city, 13));
		System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|---------------|-------------|--------------|");
	}
	
	public void writeFile() throws IOException{
		DataOutputStream outStream = new DataOutputStream(new FileOutputStream("airport1.txt", Boolean.TRUE));
		outStream.writeUTF(airportID);
		outStream.writeUTF(airportName);
		outStream.writeUTF(city);
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
