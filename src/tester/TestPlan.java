package tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.code.Customer;
import com.code.MessPlan;

import static utils.UserUtils.*;
import static utils.IOUtils.*;
import static utils.ValidationRules.*;

public class TestPlan {

	public static void main(String[] args) {
		Map<String,Customer>custMap=populateDetails();
		
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			System.out.println("Enter file name");
			String fname = sc.next();
			do {
			System.out.println("0.Exit\n"+"1.Sign In\n"+"2.Sign up\n"+"3. Change Password\n"+
			"4.Sort by firstName\n"+"5. Sort by Plan\n"+"6.sort by Regiration Date\n"+"7.Unsubcribe if plan ended\n"
					+"8.Display\n"+"9.Modify all customers first name\n"+"10.Display email addresses of the customers\n "
							+ "who did registration in month of January\n"+"11.) Display count of the Customers who have register for plan: Monthly\n"
					+"12.Search the Customer who lived in Akurdi\n"+"13.Give the 20% discount to the customers who have selected plan for 1 year.");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			try {
			switch(ch) {
			case 0:
				storeDetails(fname,custMap); 
				System.out.println("Details Stores successfully");
				System.out.println("You choosed to exit");
				exit = true;
				break;
			case 1:
				System.out.println("Enter firstName,lastName,email, password, address,\r\n" + 
						"registrDate (yyyy-mm-dd), phoneNum(Enter 10 no digit),plan(Monthly,Quaterly,HalfYear,Yearly),amunt");
				
				Customer c =ValidateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),
						sc.next(),sc.next(),sc.next(),sc.nextDouble());
				custMap.put(c.getEmail(),c);
				custMap.values().forEach(p->System.out.println(p));
				System.out.println("Enter filename");
				storeDetails(fname,custMap);
				break;
			case 2:
				System.out.println("ENter email and Password");
				validateLogin(sc.next(),sc.next(),custMap);
				System.out.println("You're successfully logged in");
				
				break;
			case 3:
				System.out.println("Enter email,old Password,newPassword");
				Customer cus =validateLogin(sc.next(),sc.next(),custMap);
				String newpass = sc.next();
				cus.setPassword(newpass);
				storeDetails(fname,custMap);
				break;
			case 4:
				custMap.values().stream()
				.sorted((p1,p2)->p1.getFirstName().compareTo(p2.getFirstName()))
				.forEach(p->System.out.println(p));
				break;
			case 5:
				custMap.values().stream()
				.sorted((p1,p2)->p1.getPlan().compareTo(p2.getPlan()))
				.forEach(p->System.out.println(p));
				break;
			case 6:
				custMap.values().stream()
				.sorted((p1,p2)->p1.getRegistrDate().compareTo(p2.getRegistrDate()))
				.forEach(p->System.out.println(p));
				break;
			case 7:
				custMap.values().removeIf(p->p.getPlanEndDate().isAfter(LocalDate.now()));
				System.out.println("Customer usubscribed suceessfully");
				storeDetails(fname,custMap);
				break;
			case 8:				
				System.out.println("Enter Filename");
				custMap=restoreDetails(sc.next());
				custMap.values().stream().forEach(p->System.out.println(p));
				break;
			case 9:
				custMap.values().stream()
				.forEach(p->p.getFirstName().toUpperCase());
				List<Customer>custList =new ArrayList<>(custMap.values());
				for(Customer cu :custList)
					System.out.println(cu);
			case 10:
				custMap.values().stream()
				.filter(p->p.getRegistrDate().getMonthValue()==1)
				.forEach(p->System.out.println(p.getEmail()));
				break;
			case 11:
				Long list = custMap.values().stream()
				.filter(p->p.getPlan()==MessPlan.MONTHLY)
				.count();
				System.out.println(list);
				break;
			case 12:
				custMap.values().stream()
				.filter(p->p.getAddress().equalsIgnoreCase("Pune"))
				.forEach(p->System.out.println(p));
				break;
			case 13:
				custMap.values().stream()
				.filter(p->p.getPlan().equals(MessPlan.YEARLY))
				.forEach(p->p.setAmunt(p.getAmunt()-p.getAmunt()*0.2));
				List<Customer>custlist =new ArrayList<>(custMap.values());
			for(Customer u :custlist)
				System.out.println(u);
				break;
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(!exit);
		}

	}

	}
