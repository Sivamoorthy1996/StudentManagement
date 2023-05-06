package org.tyys.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains java reusable code
 * @author Sivasubramaniam.M
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate the random number
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(1000);
	}
	/**
	 * This method is used to generate the random number
	 * @param Limit
	 * @return
	 */
	public int getRandomNumber(int Limit) {
		return new Random().nextInt(Limit);
	}
	
	/**
	 * This method is used to convert string to long datatype
	 * @param stringData
	 * @return
	 */
	public long convertStringToLong(String stringData) {
		return Long.parseLong(stringData);
	}
	/**
	 * This method is method is used to covert string to int datatype
	 * @param stringData
	 * @return
	 */
	public long convertStringToInt(String stringData) {
		return Integer.parseInt(stringData);
	}
	/**
	 * This method  is used to get the current date in simple date format
	 */
	public String getCurrentDate(String strategy) {
		return new SimpleDateFormat(strategy).format(new Date());
	}
	/**
	 * The method is used to split the string based on value and strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] splitString(String value ,String strategy) {
		return value.split(strategy);
	}
	/**
	 * This method is used to print the values in the console
	 * @param value
	 */
	public void printStatement(String value) {
		System.out.println(value);
	}


}
