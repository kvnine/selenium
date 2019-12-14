package rd;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTutorial {
  
  private static String url = "http://www.apache.org/";

  public static void main(String[] args) throws ClientProtocolException, IOException {
	  HttpClient instance = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		    HttpResponse response = instance.execute(new HttpPost("http://t.co/I5YYd9tddw"));
		    //System.out.println(response.getStatusLine().getStatusCode());
		    
		    
		    HttpPost httpost = new HttpPost("https://gerardnico.com/data_storage/data_storage?do=login&sectok=");

            List <NameValuePair> nvps = new ArrayList <NameValuePair>();

            nvps.add(new BasicNameValuePair("u", "admin@lslksl.com"));
            nvps.add(new BasicNameValuePair("p", "mgr!23"));  
           // nvps.add(new BasicNameValuePair("action", "LOGIN"));
         //nvps.add(new BasicNameValuePair("return_url", ""));
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            HttpResponse response1 = instance.execute(httpost);
            HttpEntity entity = response1.getEntity();

            System.out.println("5555555555Response---------------------------------"+IOUtils.toString(entity.getContent()));
		    
  }
}