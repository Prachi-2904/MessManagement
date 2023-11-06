package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.code.Customer;
import com.code.MessPlan;

import custm_Exception.CustomerException;

public class ValidationRules {
//Check for duplications 
	public static void checkForDuplicate(String email,Map<String,Customer>custMap)throws CustomerException {		
		if(custMap.containsKey(email))
		throw new CustomerException("Email Already Exists");
	}
	
	public static Customer validateLogin(String email,String password,Map<String,Customer>custMap) throws CustomerException {
		if(!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomerException("Invalid Email Syntax");
		Customer c = custMap.get(email);
	  if(c!=null) {
		  if(!(password.equals(c.getPassword()))) 
				  throw new CustomerException("Invalid password");
	  }
		  else throw new CustomerException("Invalid emailid");
	      return c;
		}
		
	public static MessPlan parseandValidatePlan(String Plan,double charges) throws CustomerException {
		MessPlan mesplan = MessPlan.valueOf(Plan.toUpperCase());
		if(mesplan.getCharges()!=charges)
			throw new CustomerException("Chrages doesnt match with the plan");
		return mesplan;
	}
	public static LocalDate paresLocalDate(MessPlan plan,LocalDate registrDate) {
		if(MessPlan.MONTHLY==plan) {
			return registrDate.plusMonths(1);
		}
		else if(MessPlan.QUATERLY==plan) {
			return registrDate.plusMonths(3);
		}
		else if(MessPlan.HALFYEAR==plan) {
			return registrDate.plusMonths(6);
		}
		else if(MessPlan.YEARLY==plan) {
			return registrDate.plusMonths(12);
		}
		return registrDate;
	}
	public static void ValidatePhoneNum(String pnm) throws CustomerException {
		if(!(pnm.matches("^[0-9]{10}$")))
				throw new  CustomerException("Invalid Phone Number");
	}
	public static Customer ValidateAllInputs(String firstName, String lastName, String email, String password, String address,
			String registrDate, String phoneNum, String plan, double amunt) throws CustomerException{
		Map<String,Customer>custMap = new HashMap<>();
		checkForDuplicate(email,custMap);
		MessPlan Plan =parseandValidatePlan(plan,amunt);
		LocalDate regdt = LocalDate.parse(registrDate);
		LocalDate enddt =paresLocalDate(Plan,regdt);
		ValidatePhoneNum(phoneNum);
	return new Customer(firstName,lastName,email,password,address,regdt,enddt,phoneNum,Plan,amunt);
	}
}
