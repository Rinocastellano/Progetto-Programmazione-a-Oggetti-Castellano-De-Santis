package univpm.it.CastelDeSa.progettoOOP.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writing {
	
	public static void writingFile(String file, ArrayList<String> post) throws FileNotFoundException,IOException {
		
			BufferedWriter in = new BufferedWriter(new FileWriter(file));
			for(String str: post) {
				in.write(str +System.lineSeparator());
				}
			in.close();
	}

}
