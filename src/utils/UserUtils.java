package utils;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.code.Customer;
import com.code.MessPlan;

public class UserUtils {
	

		public static Map<String,Customer> populateDetails(){
			Map<String,Customer>custMap = new HashMap<>();
			/*int id, String firstName, String lastName, String email, String password, String address,
			LocalDate registerDate, LocalDate planEndDate, String phoneNumber, MessPlan plan, MONTHLY(3000), QUATERLY (11700), HALFYEAR(17500),YEARLY (32000);*/
			custMap.put("p@gmail.com",new Customer("parchi","Agrawal","p@gmail.com","prac1","Pune",LocalDate.parse("2021-05-29"),LocalDate.parse("2021-08-29"),"1121298256",MessPlan.QUATERLY,11700));
			custMap.put("pa@gmail.com",new Customer("prajyot","Goyal","pa@gmail.com","prac2","Mumbai",LocalDate.parse("2023-07-29"),LocalDate.parse("2023-08-29"),"8894213483",MessPlan.MONTHLY,3000));
			custMap.put("sp@gmail.com",new Customer("sayali","Patil","sp@gmail.com","sayali1","Kolhapur",LocalDate.parse("2023-05-29"),LocalDate.parse("2024-05-29"),"0567864654",MessPlan.YEARLY,32000));
			custMap.put("pv@gmail.com",new Customer("Pradnya","Pail","pv@gmail.com","pra25","Stara",LocalDate.parse("2023-01-29"),LocalDate.parse("2023-07-29"),"9856526623",MessPlan.HALFYEAR,17500));
			
			return custMap ;
			
		}

}
