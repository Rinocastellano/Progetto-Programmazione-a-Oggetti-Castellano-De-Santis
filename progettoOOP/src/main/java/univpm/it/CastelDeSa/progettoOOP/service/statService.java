package univpm.it.CastelDeSa.progettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalc;

/**
 * classe per il servizio statistica, utile alla creazione istantanea di una classe statX (X=max,avg,min,ecc.)
 * 
 * @author Castellano Rino
 *
 */
public class statService {
	
	private static String dir="univpm.it.CastelDeSa.progettoOOP.stat.stat";
	/**
	 * Metodo calcolante la classe statistica utile per il service Stat
	 * @param command, specifica per la statistica utile alla creazione della classe
	 * @param post, arrayList di post da analizzare
	 * @return
	 * @throws commandStatException 
	 */
	public static statCalc statFormulation(String command, ArrayList<post> post) throws commandStatException {
		
		statCalc newStat = null;
		try {
			Class <?> c = Class.forName(dir+command.substring(0, 1).toUpperCase()+command.substring(1));
			
			Constructor<?> con = c.getDeclaredConstructor(ArrayList.class);
			newStat= (statCalc) con.newInstance(post);
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
		return newStat;
	}

}
