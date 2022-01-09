// package AirplaneTicket;
// package AirplaneTicketFinal;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AirportList implements ListInterface{
	Airport[] airlist=new Airport[1];
	int n;
	Scanner sc = new Scanner(System.in);
	public AirportList() {
		
	}
	
	public AirportList(Airport[] airlist,int n) {
		this.airlist=airlist;
		this.n=n;
	}
	
	public Airport[] getAirportList() {
		return airlist;
	}
	
	public void setAirportList(Airport[] airlist) {
		this.airlist=airlist;
	}
	
	public int getN() {
		return this.n;
	}
	
	public void setN(int n) {
		this.n=n;
	}
	
	public void input() {
		System.out.println("How many airport you want to have ?");
		n = Integer.parseInt(sc.nextLine());
		airlist = new Airport[n];
		for(int i=0;i<n;i++) {
			airlist[i]=new Airport();
			System.out.println("Airport "+(i+1)+ " ");
			airlist[i].input();
			System.out.println();
		}
	}
	public void MockOutPut() {
		System.out.println("=======================Danh sach san bay===========================");
		System.out.println("|-----------|-------------|------|");
		System.out.println("| AirportID | AirportName | City |");
		System.out.println("|-----------|-------------|------|");
	}
	public void output() {
		MockOutPut();
		for(int i=0;i<airlist.length;i++) {
			airlist[i].output();
			System.out.println();
		}
	}
	
	public void addElement(Airport fl1) {
        n = airlist.length;
        airlist = Arrays.copyOf(airlist, n + 1);
        airlist[n] = new Airport(fl1);
    }
	
	//    public void writeFile() throws IOException {
	//         DataOutputStream outStream = new DataOutputStream(new FileOutputStream("airport.txt"));
	//         for (int i = 0; i < airlist.length; i++) {
	//         	airlist[i].writeFile();
	//         }
	//         outStream.close();
	//     }
	
	   
	//     public void readFile() {
	//         int i = 0;
	//         try {
	//             DataInputStream inputStream = new DataInputStream(
	//             		new FileInputStream("airport.txt"));
	//             try {
	//                 while (true) { // xin cap phat them
	//                     String AirportID = inputStream.readUTF();
	//                     String AirportName = inputStream.readUTF();
	//                     String City = inputStream.readUTF();
	//                     airlist[i] = new Airport(AirportID,AirportName,City);
	//                     System.out.println("Airport " + (i + 1) + ": ");
	//                     airlist[i].output();
	//                     System.out.println();
	//                     i++;
	                    
	//                 } // while
	//             } catch (EOFException e) {
	//                 System.out.println(e.getMessage());
	//             } // close the Stream
	//             finally {
	//                 n = i;
	//                 System.out.println(n);
	//                 inputStream.close();
	//             }
	//         } catch (IOException e) {
	//         }
	//     }
	   
	    // public void readFileAll() {
	    //     int i = 0;
	    //     try {
	    //         DataInputStream inputStream = new DataInputStream(new FileInputStream("airport.txt"));
	    //         try {
	    //             while (true) { // xin cap phat them
	    //             	String AirportID = inputStream.readUTF();
		//                 String AirportName = inputStream.readUTF();
		//                 String City = inputStream.readUTF();
		//                 airlist[i] = new Airport(AirportID,AirportName,City);
	    //                 System.out.println("Airport " + (i + 1) + ": ");
	    //                 airlist[i].output();
	    //                 System.out.println();
	    //                 i++;
	    //                 n = airlist.length;
	    //                 if(inputStream.available() > 0){
	    //                 	airlist = Arrays.copyOf(airlist, n + 1);
	    //                     System.out.println("Checked");
	    //                     airlist[n] = new Airport();
	    //                 } 
	    //             } // while
	    //         } catch (EOFException e) {
	    //             System.out.println(e.getMessage());
	    //         } // close the Stream
	    //         finally {
	    //             n = i;
	    //             System.out.println(n);
	    //             inputStream.close();
	    //         }
	    //     } catch (IOException e) {
	    //     }
	    // }
	    
	   
	public Airport addAirport(Airport f) {
		for(int i=0;i<airlist.length;i++) {
			if(airlist[i].getAirportID().equals(f)){
				System.out.println("Already use");
				return null;
			}
		}
		n=airlist.length;
		airlist=Arrays.copyOf(airlist, n+1);
		airlist[n]=new Airport(f);
		n++;
		return f;
	}
	public void add() {
        Scanner sc1 = new Scanner(System.in);
		System.out.println("-----Them chuyen bay-----");
		System.out.print("Nhap so luong muon them: ");
		int k = Integer.parseInt(sc1.nextLine());
		int t = 0;

        //Xin cap phat them
        n = airlist.length;
        airlist = Arrays.copyOf(airlist, n + k);
        // System.out.println("Check!");
        for(int i = 0; i < n + k; i++) {
        	sc1 = new Scanner(System.in);
            System.out.print("Nhap ma chuyen bay: ");
            String f_id = sc1.nextLine();
            do {
                t = 0;
                for(int j = 0; j < n; j++) {
                    if(f_id.equals(airlist[j].getAirportID())) {
                        System.out.println("Ma chuyen bay da bi trung!");
                        t = 1;
                    }
                }
                if(t == 1) {
                    System.out.print("Nhap lai ma chuyen bay: ");
                    f_id = sc1.nextLine();
                }
            } while(t == 1);
            if(t == 0) {
            	sc1 = new Scanner(System.in);
            	System.out.println("Enter Airport ID: ");
        		String 	airportID = sc1.nextLine();
        		System.out.println("Enter Airport Name: ");
        		String	airportName = sc1.nextLine();
        		System.out.println("Enter Airport City: ");
        		String	city = sc1.nextLine();
        		airlist[i]= new Airport(airportID, airportName, city);
            }
        }
        n = n + k;
        // writeFile();
        System.out.println("Them chuyen bay thanh cong");
        System.out.println("-----------***-----------");
    }
	public void remove() {
		Scanner sc1=new Scanner(System.in);
		System.out.println("|| ------------- Chon thao tac xoa -------------- ||");
		System.out.println("|| 1. Xoa san bay theo ma						  ||");
		System.out.println("|| 2. Xoa cac san bay theo ten				      ||");
		System.out.println("|| 2. Xoa cac san bay theo thanh pho			  ||");
		System.out.println("||------------------------***---------------------||");
		System.out.print("Nhap lua chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch(c) {
        	case 1:{
        		System.out.println("Nhap ma san bay");
        		sc1=new Scanner(System.in);
        		String find=sc.nextLine();
        		removeAirportById(find);
        		break;
        	}
        	case 2:{
        		System.out.println("Nhap ten san bay");
        		sc1=new Scanner(System.in);
        		String find=sc.nextLine();
        		removeAirportByName(find);
        		break;
        	}
        	case 3:{
        		System.out.println("Nhap ten thanh pho");
        		sc1=new Scanner(System.in);
        		String find=sc.nextLine();
        		removeAirportByCity(find);
        		break;
        	}
        	default:{
        		System.out.println("Thoat khoi chuong trinh");
        		return ;
        	}
        }
	}
	
	public void search() {
		Scanner sc1= new Scanner(System.in);
		System.out.println("||------- Chon thao tac tim kiem -------||");
		System.out.println("|| 1. Tim Kiem theo ma san bay");
		System.out.println("|| 1. Tim Kiem theo ten san bay");
		System.out.println("|| 1. Tim Kiem theo thanh pho");
		System.out.println("||------------------***-----------------||");
		System.out.print("Nhap lua chon cua ban: ");
        int c = Integer.parseInt(sc1.nextLine());
        switch(c) {
        	case 1:{
        		System.out.println("Nhap ma san bay can tim");
        		String find=sc1.nextLine();
        		MockOutPut();
        		for(int i=0;i<airlist.length;i++) {
        			if(airlist[i].getAirportID().equals(find))
        				airlist[i].output();
        		}
        		break;
        	}
        	case 2:{
        		System.out.println("Nhap ten san bay can tim");
        		String find=sc1.nextLine();
        		MockOutPut();
        		for(int i=0;i<airlist.length;i++) {
        			if(airlist[i].getAirportName().equals(find))
        				airlist[i].output();
        	
        		}
        		break;
        	}
        	case 3:{
        		System.out.println("Nhap ten thanh pho can tim");
        		String find=sc1.nextLine();
        		MockOutPut();
        		for(int i=0;i<airlist.length;i++) {
        			if(airlist[i].getCity().equals(find)) {
        				airlist[i].output();
        			}
        		}
				break;
        	}
        	default:{
        		System.out.println("Thoat khoi tim kiem");
        		return ;
        	}
        }
        sc1.close();
	}
	
	public void edit() {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Nhap ma tuyen bay can sua");
    	String fix=sc1.nextLine();
    	int t;
    	for(int k=0;k<airlist.length;k++) {
    		t=1;
    		do {
    			if(airlist[k].getAirportID().equals(fix)) {
        			t=1;
        			System.out.println("|| ---------- Chon thao tac chinh sua ---------- ");
        			System.out.println("|| 1. Chinh sua theo ma san bay");
        			System.out.println("|| 2. Chinh sua theo ten san bay");
        			System.out.println("|| 3. Chinh sua theo thanh pho");
        			System.out.println("||------------------***-----------------||");
        			System.out.print("Nhap lua chon cua ban: ");
        	        int c = Integer.parseInt(sc.nextLine());
        	        switch(c) {
        	        	case 1:{
        	        		sc1=new Scanner(System.in);
        	        		System.out.println("Nhap ma san bay can chinh sua");
        	        		String find=sc1.nextLine();
        	        		for(int i=0;i<airlist.length;i++) {
        	        			if(airlist[i].getAirportID().equals(find)) {
        	        				airlist[i].setAirportID(find);
        	        			}
        	        		}
        	        		
        	        		break;
        	        	}
        	        	
        	        	case 2:{
        	        		sc1=new Scanner(System.in);
        	        		System.out.println("Nhap ten san bay can chinh sua");
        	        		String find=sc1.nextLine();
        	        		for(int i=0;i<airlist.length;i++) {
        	        			if(airlist[i].getAirportName().equals(find)) {
        	        				airlist[i].setAirportName(find);
        	        			}
        	        		}
        	        		break;
        	        	}
        	        	case 3:{
        	        		sc1=new Scanner(System.in);
        	        		System.out.println("Nhap ten thanh pho can chinh sua");
        	        		String find=sc1.nextLine();
        	        		for(int i=0;i<airlist.length;i++) {
        	        			if(airlist[i].getCity().equals(find)) {
        	        				airlist[i].setCity(find);
        	        			}
        	        		}
        	        		break;
        	        	}
        	        	default:{
        	        		System.out.println("Thoat khoi chinh sua");
        	        		return ;
        	        	}
        	        
        	        }
        		}else System.out.println("Nhap sai ma !!!!");
    		}while(t==0);
    	
    	}
		sc1.close();
	}
	
	public void removeAirportById(String ID) {
		for(int i=0;i<airlist.length;i++) {
			if(airlist[i].getAirportID().equals(ID)) {
				for(int j=i;j<airlist.length-1;j++)
				{
					airlist[j]=airlist[j+1];
				
				}
				break;
			}
		
		}
		n=airlist.length;
		airlist=Arrays.copyOf(airlist, n-1);
		n--;
	}
	
	public void removeAirportByName(String Name) {
		for(int i=0;i<airlist.length;i++) {
			if(airlist[i].getAirportName().equals(Name)) {
				for(int j=i;j<airlist.length-1;j++) {
					airlist[j]=airlist[j+1];
				}
				n=airlist.length;
				airlist=Arrays.copyOf(airlist, n-1);
				n--;
			}
		}
	}
	
	public void removeAirportByCity(String City) {
		for(int i=0;i<airlist.length;i++) {
			if(airlist[i].getCity().equals(City)) {
				for(int j=i;j<airlist.length;j++)
					airlist[j]=airlist[j+1];
			}
			n=airlist.length;
			airlist=Arrays.copyOf(airlist, n-1);
			n--;
		}
	}
	
	public Airport SearchAirportByID(String ID) {
		boolean flag=false;
		for(int i=0;i<airlist.length;i++)
			if(airlist[i].getAirportID().equals(ID))
				return airlist[i];
		if(flag==false) System.out.println("Not Found");
		return null;
	}
	
	public Airport SearchAirportByName(String Name) {
		boolean flag=false;
		for(int i=0;i<airlist.length;i++)
			if(airlist[i].getAirportName().equals(Name))
				return airlist[i];
		if(flag==false) System.out.println("Not Found");
		return null;
	}
	
	public Airport[] SearchAirportByCity(String city) {
		Airport[] ls=new Airport[0];
		boolean flag=false;
		int count=0;
		for(int i=0;i<airlist.length;i++)
			if(airlist[i].getAirportName().equals(city)) {
				flag=true;
				ls=Arrays.copyOf(ls, count+1);
				ls[count]=new Airport(airlist[i]);
				count++;
			}
		if(flag) return ls;
		System.out.println("Not Found");
		return null;
	}
	public String tableOutput(String m, int n) {
        String s = "";
        
        for(int i = 0; i < n-m.length(); i++) {
            s = s + " ";
        }
        
        return s;
    }

}
