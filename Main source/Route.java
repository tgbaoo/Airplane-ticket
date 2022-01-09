// package DOANOOP;
// package AirplaneTicketFinal;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Route { //LO TRINH
	//Attribute
	private String routeID; //Ma Lo Trinh
	private String routeName; // Ten Lo Trinh
	
	Scanner in =new Scanner(System.in);
	public Route() {
		
	}
	public Route(String routeID,String routeName) {
		this.routeID=routeID;
		this.routeName=routeName;
	}
	
	public Route(Route a) {
		routeID=a.routeID;
		routeName=a.routeName;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public void input() {
		System.out.println("Enter Route ID: ");
		routeID = in.nextLine();
		System.out.println("Enter Route Name: ");
		routeName = in.nextLine();
	}
	
	public void output(){
		System.out.print("| " + routeID +tableOutput(routeID, 13)
		+ routeName + tableOutput(routeName, 13));
		System.out.println("|-------------|-------------|--------------|--------------|-------------|------------|---------------|-------------|--------------|");
		
	}
	
	public void writeFile() throws IOException{
		DataOutputStream outStream = new DataOutputStream(new FileOutputStream("C:\\Thepi\\Code\\Java\\OOP\\OOP Project\\Airplane-ticket\\Source code\\source\\route.txt", Boolean.TRUE));
		outStream.writeUTF(routeID);
		outStream.writeUTF(routeName);
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
