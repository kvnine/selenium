package rd;import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;



public class WebAppFormLoginUsingHttpClient_WorkingCode2 {



        @SuppressWarnings("deprecation")
		public static void main(String[] args) throws Exception {

            //DefaultHttpClient httpclient = new DefaultHttpClient();
        	
        	CloseableHttpClient httpclient = HttpClients.custom()
                                      .build();

         /*   HttpGet httpget = new HttpGet("http://www.rfp.ca/login/");

            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            System.out.println("Login form get: " + response.getStatusLine());
            if (entity != null) {
                entity.consumeContent();
            }
            System.out.println("Initial set of cookies:");*/
       /*     List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }*/

            HttpPost httpost = new HttpPost("http://demo.guru99.com/V4/index.php");

            List <NameValuePair> nvps = new ArrayList <NameValuePair>();

            nvps.add(new BasicNameValuePair("uid", "mgr123"));
            nvps.add(new BasicNameValuePair("password", "mgr!23"));  
            nvps.add(new BasicNameValuePair("action", "LOGIN"));
          nvps.add(new BasicNameValuePair("return_url", "/manager/Managerhomepage.php"));

            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            CloseableHttpResponse response = httpclient.execute(httpost);
            HttpEntity entity = response.getEntity();

            System.out.println("5555555555Response---------------------------------"+IOUtils.toString(entity.getContent()));
            http://demo.guru99.com/V4/index.php            
            
            
         /*   System.out.println("Login form get: " + response.getStatusLine());
            if (entity != null) {

                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new
InputStreamReader(is));
                String str ="";
                while ((str = br.readLine()) != null){
                    System.out.println(""+str);
                }
            }

            System.out.println("Post logon cookies:");
            cookies = httpclient.getCookieStore().getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }*/
            httpclient.getConnectionManager().shutdown();

    }
}
