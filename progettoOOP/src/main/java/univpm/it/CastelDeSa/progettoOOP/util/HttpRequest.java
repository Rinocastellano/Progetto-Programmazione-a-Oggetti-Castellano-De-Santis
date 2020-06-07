package univpm.it.CastelDeSa.progettoOOP.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;

import univpm.it.CastelDeSa.progettoOOP.exceptions.BadReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.NotFoundMethodException;
/**
 * classe che crea una richiesta http di post
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class HttpRequest {

	/**
	 * comando di invio richiesta POST al web
	 * @param url , url di richiesta da inviare come HttpRequest
	 * @param createdTime , data per la schedule post
	 * @return messaggio di conferma post
	 * @throws IOException
	 * @throws ParseException
	 * @throws URISyntaxException
	 * @throws BadReqException
	 * @throws NotFoundMethodException
	 */
	public static void postRequest(String url, String createdTime) throws IOException, ParseException, URISyntaxException, BadReqException, NotFoundMethodException {
				//Define a postRequest request
				HttpClient httpClient = HttpClients.createDefault();
				URI u=new URI(url);
		        HttpPost postRequest = new HttpPost(u);

		        //Set the request post body
		        StringEntity strEntity = new StringEntity(createdTime, Charset.forName("UTF-8"));
		        postRequest.setEntity(strEntity);

		        //Send the request; It will immediately return the response in HttpResponse object if any
		        HttpResponse response = httpClient.execute(postRequest);
		        //verify the valid error code first
		        int statusCode = response.getCode();
		        if(statusCode==400) {
		        	throw new BadReqException();

		        }
		        else if(statusCode==404) {
		        	throw new NotFoundMethodException();

		        }
		        else {
		        System.out.println(statusCode);
		        //HttpEntity entity=((BasicClassicHttpRequest) response).getEntity();
		        //String responseString= EntityUtils.toString(entity);
		        //System.out.println(responseString);

		        
		        }

	}
}