package util;

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

public class httpRequest {

	public static String postRequest(String url, String createdTime) throws IOException, ParseException, URISyntaxException {
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
		        System.out.println(statusCode);
		        //HttpEntity entity=((BasicClassicHttpRequest) response).getEntity();
		        //String responseString= EntityUtils.toString(entity);
		        //System.out.println(responseString);
		        
		        return response.getReasonPhrase();
		        
	}
}
