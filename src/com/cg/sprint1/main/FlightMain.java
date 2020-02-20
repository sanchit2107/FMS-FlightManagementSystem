package com.cg.sprint1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.sprint1.bean.Booking;
import com.cg.sprint1.bean.Flight;
import com.cg.sprint1.bean.Schedule;
import com.cg.sprint1.bean.User;
import com.cg.sprint1.exceptions.InvalidUserIdException;
import com.cg.sprint1.service.BookingService;
import com.cg.sprint1.service.BookingServiceImpl;
import com.cg.sprint1.service.FlightService;
import com.cg.sprint1.service.FlightServiceImpl;
import com.cg.sprint1.service.ScheduleFlightService;
import com.cg.sprint1.service.ScheduleFlightServiceImpl;
import com.cg.sprint1.service.UserService;
import com.cg.sprint1.service.UserServiceImpl;

/**
 * 
 * @author Sanchit Singhal
 * @author Piyush kr Singh
 *
 */

public class FlightMain {
	static Scanner sc = new Scanner(System.in);
	static FlightService fs = new FlightServiceImpl();
	static UserService us = new UserServiceImpl();
	static BookingService bs  = new BookingServiceImpl();
	static ScheduleFlightService sfs = new ScheduleFlightServiceImpl();
	static User user = null;

	public static void main(String[] args) {
		int ch = FlightMain.menu();
		function(ch);
	}

	public static void function(int ch) {
		switch (ch) {
		case 1:
			User userObj = FlightMain.login();
			String userType = userObj.getUserType();
			switch (userType) {
			case "A":
				while (true) {
					FlightMain.adminFunctions();
				}
			case "U":
				while (true) {
					FlightMain.userFunctions(userObj);
				}

			default:
				System.out.println("!! Invalid User Type !!");
			}
		case 2:
			FlightMain.signUp();
			System.out.println("ID Created with userID " + user.getUserId());
			int choice = FlightMain.menu();
			function(choice);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("!! Invalid Input !!");
		}

	}

	public static int menu() {
		System.out.println("!! Welcome to Domestic Flight Management System !!");
		System.out.println("Please Enter");
		System.out.println("\t<1> For Login ");
		System.out.println("\t<2> For SignUp ");
		System.out.println("\t<3> To Exit Dashboard ");
		System.out.println("Enter your Choice ");
		int ch = sc.nextInt();
		return ch;
	}
	
	/**
	 * @author Piyush Kr Singh
	 *signup() 
	 */
	public static void signUp() {
		user = new User();
		System.out.println("!Welcome to Sign Up!");
		System.out.println("Enter UserId : (Greater than 1000)");
		long userId = sc.nextLong();
		user.setUserId(userId);
		System.out.println("Enter UserType:: (A) for Admin / (U) for User: ");
		String userType = sc.next();
		user.setUserType(userType);
		System.out.println("Enter username: ");
		String userName = sc.next();
		user.setUserName(userName);
		System.out.println("Enter password: (length atleast 4)");
		String userPassword = sc.next();
		user.setPassword(userPassword);
		System.out.println("Enter phone number: ");
		long userPhone = sc.nextLong();
		user.setUserPhone(userPhone);
		System.out.println("Enter email: ");
		String userEmail = sc.next();
		user.setUserEmail(userEmail);
		us.addUser(user);
	}

	/**
	 * @author Piyush Kr Singh
	 * @return
	 * 
	 */
	public static User login() {
		user = new User();
		User u = new User();
		System.out.println("Enter UserID: ");
		long userId = sc.nextLong();
		user.setUserId(userId);
		System.out.println("Enter Password: ");
		String userPassword = sc.next();
		user.setPassword(userPassword);
		u = us.validateUser(user);
		if (u != null) {
			System.out.print("! Welcome " + u.getUserName() + " as ");
			return u;
		} else {
			throw new InvalidUserIdException("Invalid UserID/Password!!");
		}
	}
	
	/**
	 * @author Piyush Kr Singh
	 * @param flight
	 */
	
	public static void displayAllFlights(List<Flight> flight) {
		for(Flight f: flight) {
		System.out.println("Flight Number: "+f.getFlightNumber()+" Flight Model: "+f.getFlightModel()+" Carrier Name: "+f.getCarrierName()+
		"Seat Capacity: "+f.getSeatCapacity());
		}
		}
	
	/**
	 * @author Sanchit Singhal
	 * @author Piyush Kr Singh
	 */
	public static void adminFunctions() {
		Flight flight = null;
		Schedule s = null;
		long flightNumber, scheduleID;
		System.out.println("Admin !");
		System.out.println("Please Enter");
		System.out.println("\t<1> To Add Flight ");
		System.out.println("\t<2> To Modify Flight ");
		System.out.println("\t<3> To Search Flight by Flight Number ");
		System.out.println("\t<4> To View All Flights ");
		System.out.println("\t<5> To Delete Flight by Flight Number ");
		System.out.println("\t<6> To Schedule Flight ");
		System.out.println("\t<7> To View Scheduled Flights between two airports");
		System.out.println("\t<8> To Search a Scheduled Flight with ScheduleID ");
		System.out.println("\t<9> To View All Scheduled Flights ");
		System.out.println("\t<10> To Modify Scheduled Flight ");
		System.out.println("\t<11> To Delete a Scheduled Flight ");
		System.out.println("\t<12> To Log Out");
		System.out.println("Enter your Choice: ");
		int ch1 = sc.nextInt();
		switch (ch1) {
		case 1:
			flight = new Flight();
			System.out.println("Enter Flight Number greater than 1000: ");
			flightNumber = sc.nextLong();
			sc.nextLine();
			flight.setFlightNumber(flightNumber);
			System.out.println("Enter Flight Model: ");
			String flightModel = sc.next();
			flight.setFlightModel(flightModel);
			System.out.println("Enter Carrier Name of atleast 3 characters: ");
			String carrierName = sc.next();
			flight.setCarrierName(carrierName);
			System.out.println("Enter Seat Capacity: ");
			int seatCapacity = sc.nextInt();
			flight.setSeatCapacity(seatCapacity);
			fs.addFlight(flight);
			System.out.println("! Flight added with Flight Number= " + flight.getFlightNumber() + " !");
			break;
			
		case 2:
			flight=new Flight();
            System.out.println("Enter Flight Number: ");
            flightNumber=sc.nextLong();
            flight.setFlightNumber(flightNumber);
            System.out.println("Enter Flight Model: ");
            flightModel=sc.next();
            flight.setFlightModel(flightModel);
            System.out.println("Enter Carrier Name of atleast 3 characters: ");
            carrierName=sc.next();
            flight.setCarrierName(carrierName);
            System.out.println("Enter Seat Capacity: ");
            seatCapacity=sc.nextInt();
            flight.setSeatCapacity(seatCapacity);
            fs.modifyFlight(flight);
            System.out.println("! Flight Modified !");
			break;
			
		case 3:
			System.out.println("Enter Flight Number: ");
			flightNumber = sc.nextLong();
			flight = new Flight();
			flight = fs.viewFlight(flightNumber);
			System.out.println("Flight Model: " + flight.getFlightModel() + " Carrier Name: " + flight.getCarrierName()
					+ " Seat Capacity:" + flight.getSeatCapacity());
			break;
			
		case 4:
			displayAllFlights(fs.viewFlight());
			break;
			
		case 5:
			System.out.println("Enter Flight Number: ");
			flightNumber = sc.nextLong();
			fs.deleteFlight(flightNumber);
			System.out.println("! Flight deleted !");
			break;
			
			
		case 6:
			
			s =new Schedule();
			System.out.println("Schedule Flight here!!");
			
			System.out.println("Enter ScheduleID : ");
			long sID = sc.nextLong();
			s.setScheduleID(sID);
			
			System.out.println("Enter Source Airport : ");
			String source = sc.next();
			s.setSourceAirpot(source);
			
			System.out.println("Enter Destination Airport : ");
			String destination = sc.next();
			s.setDestinationAirpot(destination);
			
			System.out.println("Enter Departure Date : ");
			String departure = sc.next();
			s.setDepartureTime(departure);
			
			System.out.println("Enter Arrival Date : ");
			String arrival = sc.next();
			s.setArrivalTime(arrival);
			
			sfs.scheduleFlights(s);
			
			System.out.println("Flight is Scheduled between " + s.getSourceAirpot() + " and  " +  
			s.getDestinationAirpot() + " and ScheduleID : "+ s.getScheduleID());
			
			break;
			
			
		case 7 :
			
			List<Schedule> sList = new ArrayList<Schedule>();
			System.out.println("<--- Find Scheduled Flight --->");
			System.out.println("");System.out.println("");
			
			System.out.println("Enter Source Airport - ");
			String sourcePort = sc.next();
			
			System.out.println("Enter Destination Airport - ");
			String destinationPort = sc.next();
			
			System.out.println("Enter the Date of the schedule flight - ");
			String scheduleDate = sc.next();
			
			sList = sfs.viewScheduledFlight(sourcePort, destinationPort, scheduleDate);
			
			for(Schedule sItr: sList) {
				System.out.println("Schedule ID : " + sItr.getScheduleID() + "\n" + "Departure Time : " + sItr.getDepartureTime() + "\n" +
			"Arrival Time : "+ sItr.getArrivalTime());
				
			}
			System.out.println(sList);
			System.out.println("Thanks!");
			break;
			
			
		case 8:
			
			s = new Schedule();
			System.out.println("Enter the ScheduleID : ");
			long flightNum = sc.nextLong();
			
			s = sfs.viewScheduledFlights(flightNum);
			
			System.out.println("Source Airport : " + s.getSourceAirpot());
			System.out.println("Destination Airport : " + s.getDestinationAirpot());
			System.out.println("Departure Date : " + s.getDepartureTime());
			System.out.println("Arrival Date : " + s.getArrivalTime());
			
			break;
			
			
		case 9:
			
			displayAllScheduleFlight(sfs.viewScheduledFlight());
			break;
			
		
		case 10: 
			
			s = new Schedule();
			
			System.out.println("Enter ScheduleID for which need to update : ");
			long schID = sc.nextLong();
			s.setScheduleID(schID);
			
			System.out.println("Enter new Source Airport : ");
			String src = sc.next();
			s.setSourceAirpot(src);
			
			System.out.println("Enter new Destination Airport : ");
			String dest = sc.next();
			s.setDestinationAirpot(dest);
			
			System.out.println("Enter new Departure Date : ");
			String depDate = sc.next();
			s.setDepartureTime(depDate);
			
			
			System.out.println("Enter new Arrival Date : ");
			String arrDate = sc.next();
			s.setArrivalTime(arrDate);
			
			sfs.modifyScheduledFlight(s);
			
			System.out.println("Scheduled Flight Modified!!");
			break;
			
			
		case 11:
			
			System.out.println("Enter ScheduleFlight ID: ");
			scheduleID = sc.nextLong();
			sfs.deleteScheduledFlight(scheduleID);
			System.out.println("!Schedule Flight deleted !");
			break;
			
		case 12:
			int ch = FlightMain.menu();
			function(ch);
			break;
		default:
			System.out.println("!! Invalid Input !!");
			FlightMain.adminFunctions();
			break;
		}

	}

	/**
	 * @author Sanchit Singhal
	 * @param viewScheduledFlight
	 */
	public static void displayAllScheduleFlight(List<Schedule> viewScheduledFlight) {

		for(Schedule sItr : viewScheduledFlight) {
			System.out.println("ScheduleId : " + sItr.getScheduleID());
			System.out.println("Source Airport : " + sItr.getSourceAirpot());
			System.out.println("Destination Airport : "+ sItr.getDestinationAirpot());
			System.out.println("Departure Date : "+ sItr.getDepartureTime());
			System.out.println("Arrival Date : " + sItr.getArrivalTime());
		}
		
	}
	/**
	 * @author Sanchit Singhal
	 * @param userObj
	 */
	public static void userFunctions(User userObj) {
		
		Booking book = null;
		
		System.out.println("User !!");
		System.out.println("Please Enter");
		System.out.println("\t<1> To Add Booking ");
		System.out.println("\t<2> To Modify Booking ");
		System.out.println("\t<3> To View a Booking");
		System.out.println("\t<4> To Delete a Booking ");
		System.out.println("\t<5> To Log Out ");
		System.out.println("Enter your Choice: ");
		int ch1 = sc.nextInt();
		switch (ch1) {
		case 1:
			book  = new Booking();
			
			System.out.println("Enter Booking ID");
			long bID = sc.nextLong();
			book.setBookingID(bID);
			
			System.out.println("Enter User ID");
			long uID = sc.nextLong();
			book.setUserID(uID);
			
			System.out.print("Enter Date for booking(DD-MMM-YYYY) --> ");
			String date = sc.next();
			book.setBookingDate(date);
			
			System.out.print("Enter Price of Ticket --> ");
			long price = sc.nextLong();
			book.setTicketCost(price);
			
			System.out.print("Enter number of Passengers --> ");
			int count = sc.nextInt();
			book.setNoOfPassengers(count);
			
			System.out.print("Enter Flight Number --> ");
			long fno = sc.nextLong();
			book.setFlight(fno);
			
			bs.addBooking(book);
			
			System.out.println("Booking Successfull!!  "
					+ "Your BookingID is : "+book.getBookingID() +"!!");
			System.out.println("Flight Number is : "+ book.getFlight() + "!!");
			
			break;
			
		case 2:
			
			book = new Booking();
			
			System.out.print("Enter Booking ID : ");
			long bId = sc.nextLong();
			book.setBookingID(bId);
			
			System.out.print("Enter UserID : ");
			long uId = sc.nextLong();
			book.setUserID(uId);
			
			System.out.print("Update Booking Date : ");
			String dateInput = sc.next();
			book.setBookingDate(dateInput);
			
			System.out.print("Update Passenger Count : ");
			int pCount = sc.nextInt();
			book.setNoOfPassengers(pCount);
			
			System.out.println("Update Flight Number : ");
			long fnum = sc.nextLong();
			book.setFlight(fnum);
			
			bs.modifyBooking(book);
			
			System.out.println("----Your Booking is Modified----");
			System.out.println("~~~~ Updated Details are as: ~~~~~");
			System.out.println("Flight Number : " +book.getFlight());
			System.out.println("Booking Date : "+ book.getBookingDate());
			
			break;
			
		case 3:
			
			System.out.println("<--- View your Booking here --->");
			
			System.out.print("Enter your Booking ID : ");
			long bookID = sc.nextLong();
			Booking bookObj = new Booking();
			bookObj = bs.viewBooking(bookID);
			
			System.out.println("Booking ID : "+ bookObj.getBookingID());
			System.out.println("Uer ID : "+ bookObj.getUserID());
			System.out.println("Booking Date :" + bookObj.getBookingDate());
			System.out.println("Ticket Cost : " + bookObj.getTicketCost());
			System.out.println("No. of Passengers : " + bookObj.getNoOfPassengers());
			System.out.println("Flight Number : " + bookObj.getFlight());

			break;

		case 4:
			
			System.out.println("<--- Cancel Booking here --->");
			
			System.out.print("Enter Booking ID : ");
			long cancelBookId = sc.nextLong();
			bs.deleteBooking(cancelBookId);
			
			System.out.println("Your Booking is Cancelled!!");
			
			break;
		case 5:
			int ch = FlightMain.menu();
			function(ch);
			break;
			
		default:
			System.out.println("!! Invalid Input !!");
			FlightMain.userFunctions(userObj);
			break;
		}

	}
}
