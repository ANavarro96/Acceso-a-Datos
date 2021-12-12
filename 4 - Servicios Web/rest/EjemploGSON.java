package rest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.google.gson.Gson;

public class EjemploGSON {
	
	static  final CloseableHttpClient httpclient = HttpClients.createDefault();
	static  final Gson gson = new Gson();
	
	public static void main(String[] args) {
		HttpGet getRequest = new HttpGet("https://cat-fact.herokuapp.com/facts");
		
		 try (CloseableHttpResponse response1 = httpclient.execute(getRequest)) {
			 
		     HttpEntity entidadRespuesta = response1.getEntity();

		     
		     String resultado = EntityUtils.toString(entidadRespuesta);
		     Gatito[] listaGatos = gson.fromJson(resultado, Gatito[].class);
		     
		     for(Gatito gatito: listaGatos) {
		    	 System.out.println(gatito.getText());
		     }
		     
		     // and ensure it is fully consumed
		     EntityUtils.consume(entidadRespuesta);
		 } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
      
}
