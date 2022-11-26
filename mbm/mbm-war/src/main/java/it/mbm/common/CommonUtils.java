package it.mbm.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public class CommonUtils {

	/**
	 * Metodo di utilità che restituisce true se e solo se la stringa passata in input è uguale a stringa vuota o null.
	 */
	public static boolean isEmptyString(String inputString) {
		return inputString==null||inputString.equals("")||inputString.trim().equals("");
	}
	
	
	public static boolean isEmptyArray(Object[] inputArray) {
		return inputArray==null||inputArray.length == 0;
	}
	
	/**
	 * Metodo che verifica la correttezza (non formale) di una data sulla base della tripletta giorno, mese ed anno.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static boolean isDateValid(int day, int month, int year) {
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		cal.setLenient(false);
		try {
			cal.get(Calendar.DATE);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	/**
	 * Checks if is collection empty.
	 *
	 * @param collection
	 *            the collection
	 * @return true, if is collection empty
	 */
	public static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isStringEmptyOrNull(String inputString) {
		return inputString == null || "".equals(inputString.trim());
	}
	
}
