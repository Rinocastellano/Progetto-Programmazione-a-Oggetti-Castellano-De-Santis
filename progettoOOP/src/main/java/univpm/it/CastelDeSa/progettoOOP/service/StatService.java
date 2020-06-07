package univpm.it.CastelDeSa.progettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.StatNum;
import univpm.it.CastelDeSa.progettoOOP.stat.StatCalculate;

/**
 * classe per il servizio statistica, utile alla creazione istantanea di una classe statX (X=max,avg,min,ecc.)
 * 
 * @author Castellano Rino
 * @author Matteo De Santis
 *  */
public class StatService {
	
	private static String dir="univpm.it.CastelDeSa.progettoOOP.stat.stat";
	/**
	 * Metodo calcolante la classe statistica utile per il service Stat
	 * @param command, specifica per la statistica utile alla creazione della classe
	 * @param post, arrayList di post da analizzare
	 * @return statistica impostata secondo le richieste
	 * @throws commandStatException 
	 */
	public static StatCalculate statFormulation(String command, ArrayList<Post> post) throws CommandException {
		
		StatCalculate newStat = null;
		try {
			Class <?> c = Class.forName(dir+command.substring(0, 1).toUpperCase()+command.substring(1));
			
			Constructor<?> con = c.getDeclaredConstructor(ArrayList.class);
			newStat= (StatCalculate) con.newInstance(post);
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
		return newStat;
	}

}
