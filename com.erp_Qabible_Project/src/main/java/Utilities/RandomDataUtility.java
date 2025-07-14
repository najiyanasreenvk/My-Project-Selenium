package Utilities;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	 static Faker faker;
	 
	 public static String getrofessionName() {
		 faker =new Faker();
		 return faker.company().profession();
	 }
	 
	 public static String getName() {
		  faker = new Faker(new Locale("en-IND"));
			return faker.name().name();
	 }
	 
	 public static String getEmail() {

			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			int length = 5;
			for (int i = 0; i < length; i++) {
				int index = random.nextInt(alphabet.length());
				char randomChar = alphabet.charAt(index);
				sb.append(randomChar);
			}
			String randomStringEmail = sb.toString() + "@gmail.com";
			return randomStringEmail;

		}
	 
	 public static String getFirstName() {
		  faker = new Faker(new Locale("en-IND"));
			return faker.name().firstName();
	 }
	 
	 public static String getLastName() {
		  faker = new Faker(new Locale("en-IND"));
			return faker.name().lastName();
	 }
	 
	 public static String getPrifix() {
		  faker = new Faker();
			return faker.name().prefix();
	 }
	 
	 public static String getPassword() {
		 faker =new Faker();
		 return faker.internet().password(5,8);
	 }
	 
	 


}
