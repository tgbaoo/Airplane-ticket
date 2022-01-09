//package AirplaneTicketFinal;
import java.util.*;
import java.io.*;
public class RWFile {
    public void readFile(FlightList flight, String path) {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
            try {
                while (true) { // xin cap phat them
                    String flightId = inputStream.readUTF();
                    String routeId = inputStream.readUTF();
                    String flightRouteId = inputStream.readUTF();
                    String airplaneId = inputStream.readUTF();
                    int status = inputStream.readInt();
                    int num = inputStream.readInt();
                    String takeOffDay = inputStream.readUTF();
                    String landingDay = inputStream.readUTF();
                    Flight temp = new Flight(flightId, routeId, flightRouteId, airplaneId, status, num,
                                            takeOffDay, landingDay);
                    if(flight.searchFlightById(temp.getFlightId()) == null) {
                        flight.addElement(temp);
                    }
                }
            } catch(EOFException e) {
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        }
    }
   
 
    public void writeFile(FlightList flight, String path) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for (int i = 0; i < flight.getFlightList().length; i++) {
            flight.flight[i].writeFile();
        }
        outStream.close();
    }
 
    public void readFile(FlightTicketList flightTicket, String path) {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
            try {
                while (true) { // xin cap phat them
                    int flag = inputStream.readInt();
                    if (flag == 0) {
                        // Economy Class
                        String flightTicketId = inputStream.readUTF();
                        String flightId = inputStream.readUTF();
                        int ticketType = inputStream.readInt();
                        int ticketPrice = inputStream.readInt();
                        String chairNumber = inputStream.readUTF();
                        EconomyClassTicket temp = new EconomyClassTicket(flightTicketId, flightId, ticketType, ticketPrice, chairNumber);
                        if(flightTicket.searchFlightTicketById(temp.getFlightTicketId()) == null) {
                            flightTicket.addElement(temp);
                        }
       
                    } else if (flag == 1) {
                            //business class
                            String flightTicketId = inputStream.readUTF();
                            String flightId = inputStream.readUTF();
                            int ticketType = inputStream.readInt();
                            int ticketPrice = inputStream.readInt();
                            String waitingRoomId = inputStream.readUTF();
                            String businessClassId = inputStream.readUTF();
                            BusinessClassTicket temp = new BusinessClassTicket(flightTicketId, flightId, ticketType, ticketPrice, waitingRoomId, businessClassId);
                            if(flightTicket.searchFlightTicketById(temp.getFlightTicketId()) == null) {
                                flightTicket.addElement(temp);
                            }
                        }
                    // while
                }
            } catch(EOFException e) {
            } finally {
                inputStream.close();
            } 
        } catch(Exception e) {}
    }
 
 
    public void writeFile(FlightTicketList flightTicket, String path) throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for (int i = 0; i < flightTicket.getFlightTicketList().length; i++) {
            if(flightTicket.flightTicket[i] instanceof EconomyClassTicket){
                EconomyClassTicket ect = new EconomyClassTicket();
                ect = (EconomyClassTicket)flightTicket.flightTicket[i];
                ect.writeFile();
            } else if(flightTicket.flightTicket[i] instanceof BusinessClassTicket) {
                BusinessClassTicket bct = new BusinessClassTicket();
                bct = (BusinessClassTicket)flightTicket.flightTicket[i];
                bct.writeFile();   
            }
        }
        outStream.close();
    }


 
    //Hoa don
   
    public void writeFile(BillList Bill , String path) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
             for (int i = 0; i < Bill.bill.length; i++) {
                Bill.bill[i].writeFile();
             }
         outStream.close();
    }
    
    public void readFile(BillList Bill , String path) {
    	
        try{
     
            DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
            try {
                    while (true) { // xin cap phat them
                        String billId = inputStream.readUTF();
                        String billDate = inputStream.readUTF();
                        String staffId = inputStream.readUTF();
                        String clientId = inputStream.readUTF();
                        float billTax = inputStream.readFloat();
                        float billSum = inputStream.readFloat();
                        Bill temp = new Bill(billId, billDate, staffId, clientId, billTax, billSum);
                        if(Bill.searchBillById(temp.getBillId()) == null) {
                        	
                            Bill.addElement(temp);
                        }
                    } // while
                }catch (EOFException e) {
                    
                } // close the Stream
                finally {
                    inputStream.close();
                }
        } catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }
 
 
   //Khach hang
   
   public void writeFile(CustomerList Customer, String path) throws IOException 
    {
       DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
           for (int i = 0; i < Customer.customer.length; i++) {
                Customer.customer[i].writeFile();
              }
       outStream.close();
    }
 
 
    public void readFile(CustomerList Customer , String path) {
        try{
 
        DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
        try {
                while (true) { // xin cap phat them
                    String customerId = inputStream.readUTF();
                    String customersurName = inputStream.readUTF();
                    String customerName = inputStream.readUTF();
                    String phoneNumber = inputStream.readUTF();
                    String identityCart = inputStream.readUTF();
                    int sex = inputStream.readInt();
                    Customer temp = new Customer(customerId, customersurName ,customerName, phoneNumber, identityCart, sex);
                    if(Customer.searchCustomerById(temp.getCustomerId()) == null) {
                        Customer.addElement(temp);
                    }
                }
            } catch (EOFException e) {
                
            } // close the Stream
            finally {
                inputStream.close();
            }
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
    }
 
 
 
     // Nhan vien
     
     public void writeFile(StaffList Staff, String path) throws IOException 
{
         DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
             for (int i = 0; i < Staff.staff.length; i++) {
                Staff.staff[i].writeFile();
             }
            outStream.close();                      
    }
 
    public void readFile(StaffList Staff, String path) {
        try{
            DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
            try {
                while (true) { // xin cap phat them
                    String staffId = inputStream.readUTF();
                    String staffsurName = inputStream.readUTF();
                    String staffName = inputStream.readUTF();
                    String phoneNumber = inputStream.readUTF();
                    String identityCart = inputStream.readUTF();
                    Staff temp = new Staff(staffId, staffsurName, staffName, phoneNumber, identityCart);
                    if (Staff.searchStaffById(temp.getStaffId()) == null) {
                        Staff.addElement(temp);
                    }
    
                }
            }catch (EOFException e) {
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        	 System.out.println(e.getMessage());
        }
    }
 
 
   
//    // routeList
    public void readFile(RouteList routeList,String path) {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
            try {
            	while(true) {
                    String routeId = inputStream.readUTF();
                    String routeName = inputStream.readUTF();
                    Route a= new Route(routeId,routeName);
                    if(routeList.searchRouteID(a.getRouteID() )== null) {
                        routeList.addElement(a);
                    }
                }	
            }
            catch (EOFException e) {
				// TODO: handle exception
			}
            finally {
            	inputStream.close();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    public void writeFile(RouteList routeList,String path)throws IOException {
    	DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for(int i=0;i<routeList.routeList.length;i++) {
            routeList.routeList[i].writeFile();
        }
        outStream.close();
    }
//   
//    // FlightRoute
//   
    public void readFile(FlightRoutesList a,String path) {
        try {
            DataInputStream inputStream = 
            		new DataInputStream(new FileInputStream(path));
            try {
            	  while(true) {
                      String flightRouteId = inputStream.readUTF();
                      String takeOffAirport = inputStream.readUTF();
                      String landingAirport = inputStream.readUTF();
                      String takeOffTime = inputStream.readUTF();
                      String landingTime = inputStream.readUTF();
                      FlightRoutes temp=
                      new FlightRoutes(flightRouteId,takeOffAirport,landingAirport,takeOffTime,landingTime);
                      if( a.searchFlightRoutesByID(temp.getFlightRouteId()) ==null) {
                          a.addElement(temp);
                      }
                  }
            }
            catch(EOFException e) {}
            finally{
            	inputStream.close();
            }
          
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    public void writeFile(FlightRoutesList a,String path) throws IOException {
    	DataOutputStream outStream = 
    			new DataOutputStream(new FileOutputStream(path));
        for(int i=0;i<a.fl.length;i++) {
             a.fl[i].writeFile();
        }
         outStream.close();
    }
   
   
    public void readFile(AirportList a,String path) {
        try {
        	DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
        	try {
                while(true) {
                    String AirportID = inputStream.readUTF();
                    String AirportName = inputStream.readUTF();
                    String City = inputStream.readUTF();
                    Airport tmp = new Airport(AirportID, AirportName, City);
                    if(a.SearchAirportByID(tmp.getAirportID())==null) {
//                    	tmp.output();
                        a.addElement(tmp);
                    }
                }
        	}catch(EOFException e) {}
        	finally {
        		inputStream.close();
        	}
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
   
    public void writeFile(AirportList a,String path) throws IOException {
    	  DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
          for(int i=0;i<a.airlist.length;i++) {
              a.airlist[i].writeFile();
          }
          outStream.close();
    }
 
 
//   
//    //May bay
    public void readFile(AirplaneList airplaneList, String path) {
	try{
        DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
        try {
            while (true) { // xin cap phat them
                String airplaneID = inputStream.readUTF();
                String airplaneName = inputStream.readUTF();
                int numberOfSeats = inputStream.readInt();
                String description = inputStream.readUTF();
                String airplaneCompanyID= inputStream.readUTF();
                Airplane temp = new Airplane(airplaneID, airplaneName, numberOfSeats, description, airplaneCompanyID);
                if(airplaneList.searchAirplaneById(temp.getAirplaneID()) == null) {
                	
                    airplaneList.addElement(temp);
                }
                }
            } catch(EOFException e) {
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        }
    }
 
 
    public void writeFile(AirplaneList airplaneList, String path) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for (int i = 0; i < airplaneList.airplaneList.length; i++) {
            airplaneList.airplaneList[i].writeFile();
        }
        outStream.close();
    }
 
//    //Cusomer ticket
    public void readFile(CustomerTicketList customerTicketList, String path) {
     try{
        DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
        try {
            while (true) { // xin cap phat them
                String customerTicketID = inputStream.readUTF();
                String customerID = inputStream.readUTF();
                String ticketID = inputStream.readUTF();
                String boardingTime= inputStream.readUTF();
                int seatNumber = inputStream.readInt();
                CustomerTicket temp = new CustomerTicket(customerTicketID, customerID, ticketID, boardingTime, seatNumber);
                if(customerTicketList.searchCustomerTicketById(temp.getCustomerTicketID()) == null) {
                    customerTicketList.addElement(temp);
               }
               }
            } catch(EOFException e) {
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        }
    }
 
 
    public void writeFile(CustomerTicketList customerTicketList, String path) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for (int i = 0; i < customerTicketList.customerTicketList.length; i++) {
            customerTicketList.customerTicketList[i].writeFile();
        }
        outStream.close();
    }
 
    //Hang may bay
    public void readFile(AirplaneCompanyList airplaneCompanyList, String path) {
    	
     try{
        DataInputStream inputStream = new DataInputStream(new FileInputStream(path));
        try {
            while (true) { // xin cap phat them
            	
                String airplaneCompanyID = inputStream.readUTF();
                String airplaneCompanyName = inputStream.readUTF();
                AirplaneCompany temp = new AirplaneCompany(airplaneCompanyID, airplaneCompanyName);
                
                if(airplaneCompanyList.searchAirplaneCompanyById(temp.getAirplaneCompanyID()) == null) {
                    airplaneCompanyList.addElement(temp);
                    System.out.println(airplaneCompanyID + "  " +airplaneCompanyName);
                    
                 }
                }
            } catch(EOFException e) {
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
        	 System.out.println(e.getMessage());
        }
    }
 
 
    public void writeFile(AirplaneCompanyList airplaneCompanyList, String path) throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path));
        for (int i = 0; i < airplaneCompanyList.airplaneCompanyList.length; i++) {
            airplaneCompanyList.airplaneCompanyList[i].writeFile();
        }
        outStream.close();
    }

}



 
 
 

