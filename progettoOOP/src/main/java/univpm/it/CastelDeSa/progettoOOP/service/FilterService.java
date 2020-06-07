package univpm.it.CastelDeSa.progettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;
import univpm.it.CastelDeSa.progettoOOP.filter.Filter;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.stat.StatCalculate;
/**
 * classe calcolante il tipo di filtro da utilizzare
 * @author Rino Castellano
 * @author Matteo De Santis
 */
public class FilterService {
	private static String dir="univpm.it.CastelDeSa.progettoOOP.filter.filter";
	/**
	 * Metodo creante la classe filter 
	 * @param command, specifica per il filter utile alla creazione della classe
	 * @param post, arrayList di post da analizzare
	 * @return filtro impostato secondo le specifiche
	 * @throws commandStatException 
	 */
	public static Filter filterFormulation(String command, ArrayList<Post> post, ArrayList<String> param) throws CommandException {
		
		Filter newFilter = null;
		
		try {
			Class <?> c = Class.forName(dir+command.substring(0, 1).toUpperCase()+command.substring(1));
			
			Constructor<?> con = c.getDeclaredConstructor(ArrayList.class, ArrayList.class);
			newFilter= (Filter) con.newInstance(post,param);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		throw new CommandException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFilter;
	}

}
