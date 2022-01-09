import java.util.Scanner;
import java.io.*;

public class Flight { // CHUYEN BAY
    // Attribute
    private String flightId; // ma chuyen bay
    private String routeId; // ma lo trinh
    private String flightRouteId; // ma tuyen bay
    private String airplaneId; // ma may bay
    private int status; // 1 - san sang, 0 - khong san sang
    private int numberOfTicketLeft; // tong so luong ve con lai
    private String takeOffDay; // ngay cat canh
    private String landingDay; // ngay ha canh

    public Flight() {
    }

    public Flight(String flightId, String routeId, String flightRouteId, String airplaneId, int status,
            int numberOfTicketLeft, String takeOffDay, String landingDay) {
        this.flightId = flightId;
        this.routeId = routeId;
        this.flightRouteId = flightRouteId;
        this.airplaneId = airplaneId;
        this.status = status;
        this.numberOfTicketLeft = numberOfTicketLeft;
        this.takeOffDay = takeOffDay;
        this.landingDay = landingDay;
    }

    public Flight(Flight f) {
        flightId = f.flightId;
        routeId = f.routeId;
        flightRouteId = f.flightRouteId;
        airplaneId = f.airplaneId;
        status = f.status;
        numberOfTicketLeft = f.numberOfTicketLeft;
        takeOffDay = f.takeOffDay;
        landingDay = f.landingDay;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getFlightRouteId() {
        return flightRouteId;
    }

    public void setFlightRouteId(String flightRouteId) {
        this.flightRouteId = flightRouteId;
    }

    public String getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(String airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberOfTicketLeft() {
        return numberOfTicketLeft;
    }

    public void setNumberOfTicketLeft(int numberOfTicketLeft) {
        this.numberOfTicketLeft = numberOfTicketLeft;
    }

    public String getTakeOffDay() {
        return takeOffDay;
    }

    public void setTakeOffDay(String takeOffDay) {
        this.takeOffDay = takeOffDay;
    }

    public String getLandingDay() {
        return landingDay;
    }

    public void setLandingDay(String landingDay) {
        this.landingDay = landingDay;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Flight ID: ");
        flightId = sc.nextLine();
        System.out.println("Enter Route ID: ");
        routeId = sc.nextLine();
        System.out.println("Enter Flight Route ID: ");
        flightRouteId = sc.nextLine();
        System.out.println("Enter Plane ID: ");
        airplaneId = sc.nextLine();
        System.out.println("Enter Status: \n 0: Available \n 1: Non-available \n");
        status = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Number of ticket left: ");
        numberOfTicketLeft = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Take Off Day: ");
        takeOffDay = sc.nextLine();
        System.out.println("Enter Landing Day: ");
        landingDay = sc.nextLine();
    }

    public void output() {
        System.out.print("|" + flightId + tableOutput(flightId, 13) +
                routeId + tableOutput(routeId, 13) +
                flightRouteId + tableOutput(flightRouteId, 14) +
                airplaneId + tableOutput(airplaneId, 14));
        if (status == 0) {
            System.out.print("San sang" + tableOutput("San sang", 13));
        } else if (status == 1) {
            System.out.print("Chua san sang" + tableOutput("Chua san sang", 13));
        }

        System.out.println(numberOfTicketLeft+tableOutput(Integer.toString(numberOfTicketLeft), 15)+ 
                          takeOffDay + tableOutput(takeOffDay, 13) +
                          landingDay + tableOutput(landingDay, 14));

        System.out.println(
                "|-------------|-------------|--------------|--------------|-------------|---------------|-------------|--------------|");

    }

    public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("..\\Source\\flight.txt", Boolean.TRUE));
        outStream.writeUTF(flightId);
        outStream.writeUTF(routeId);
        outStream.writeUTF(flightRouteId);
        outStream.writeUTF(airplaneId);
        outStream.writeInt(status);
        outStream.writeInt(numberOfTicketLeft);
        outStream.writeUTF(takeOffDay);
        outStream.writeUTF(landingDay);
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