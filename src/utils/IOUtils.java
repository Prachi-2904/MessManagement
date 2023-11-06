package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.code.Customer;

public interface IOUtils {

	public static void storeDetails(String filename,Map<String,Customer>custMap) throws FileNotFoundException, IOException {
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(custMap);
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Customer> restoreDetails(String filename) {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			return (Map<String, Customer>) in.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
}
}