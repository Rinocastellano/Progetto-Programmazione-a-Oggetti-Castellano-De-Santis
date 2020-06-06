package univpm.it.CastelDeSa.progettoOOP.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
* classe di writing dato il percorso del file
* @author Castellano Rino
* @author Matteo De Santis
*
*/
public class writing {
	
	/**
	 * scrittura su file dato il suo percorso
	 * @param file
	 * @param post , arrayList di string contenente i messaggi per i post temporizzati randomici
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writingFile(String file, ArrayList<String> post) throws FileNotFoundException,IOException {
		
			BufferedWriter in = new BufferedWriter(new FileWriter(file));
			for(String str: post) {
				in.write(str +System.lineSeparator());
				}
			in.close();
	}

}
