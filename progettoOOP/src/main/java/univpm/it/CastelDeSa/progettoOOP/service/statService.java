package univpm.it.CastelDeSa.progettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalcNum;

public class statService {
	
	private static String dir="univpm.it.CastelDeSa.progettoOOP.stat.stat";
	
	public static statCalcNum statFormulation(String command, ArrayList<post> post) {
		
		statCalcNum newStat = null;
		try {
			Class <?> c = Class.forName(dir+command.substring(0, 1).toUpperCase()+command.substring(1));
			Constructor<?> con = c.getDeclaredConstructor(ArrayList.class);
			newStat= (statCalcNum) con.newInstance(post);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
