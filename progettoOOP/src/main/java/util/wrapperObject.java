package util;

import java.util.ArrayList;
import java.util.HashMap;

import univpm.it.CastelDeSa.progettoOOP.model.stat;

public class wrapperObject {
	private static HashMap<String,ArrayList<String>> map= new HashMap<String,ArrayList<String>>();
	private static stat statistic= new stat();
	public static HashMap<String, ArrayList<String>> getMap() {
		return map;
	}
	public void setMap(HashMap<String, ArrayList<String>> map) {
		this.map = map;
	}
	public static stat getStatistic() {
		return statistic;
	}
	public void setStatistic(stat statistic) {
		this.statistic = statistic;
	}
	
	

}
