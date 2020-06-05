package univpm.it.CastelDeSa.progettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.filter.filter;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalculate;

public class filterService {
	private static String dir="univpm.it.CastelDeSa.progettoOOP.filter.filter";
	/**
	 * Metodo calcolante la classe statistica utile per il service Stat
	 * @param command, specifica per la statistica utile alla creazione della classe
	 * @param post, arrayList di post da analizzare
	 * @return
	 * @throws commandStatException 
	 */
	public static filter filterFormulation(String command, ArrayList<post> post, ArrayList<String> param) throws commandStatException {
		
		filter newFilter = null;
		
		try {
			Class <?> c = Class.forName(dir+command.substring(0, 1).toUpperCase()+command.substring(1));
			
			Constructor<?> con = c.getDeclaredConstructor(ArrayList.class, ArrayList.class);
			newFilter= (filter) con.newInstance(post,param);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		throw new commandStatException(e);
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
