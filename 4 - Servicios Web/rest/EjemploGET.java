package rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

public class EjemploGET {

	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	


	/* Creamos la función capturadora (como los eventos en Android!) que se ejecutará en el momento en el que se haya procesado
	 * la petición GET.
	 * Se parametriza con el tipo de respuesta que espera (<String> en este caso)
	 */
  static final HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {

	  /* El objeto ClassicHttpResponse incluye toda la información de una respuesta Http: cuerpo, código, cabeceras...*/
      @Override
      public String handleResponse(final ClassicHttpResponse response) throws IOException {
          final int status = response.getCode();
          /* SC_SUCCESS representa el valor 200 (OK) y SC_REDIRECTION el valor 300 (el servidor se ha movido de sitio) */
          if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
              /* Un HttpEntity representa una entidad, o cualquier objeto que se puede enviar mediante peticiones HTTP */
        	  final HttpEntity entity = response.getEntity();
              try {
            	  if (entity != null) {
            		  return EntityUtils.toString(entity);
            	  }
            	  else
            		  return null;
              } catch (final ParseException ex) {
                  throw new ClientProtocolException(ex);
              }
          } else {
              throw new ClientProtocolException("Unexpected response status: " + status);
          }
      }

  };
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		String urlLyrics = "https://api.lyrics.ovh/v1/{artista}/{cancion}";
		final CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultado = "";
		String opcion = "";
		String artista = "blink-182";
		String cancion = "dammit";
		//Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
        //Choice depends on type of method you will be invoking.
		try {
			System.out.println("Hola!");
			System.out.println("Si quieres ver un ejemplo con valores por defecto, pulsa 1");
			System.out.println("Si quieres poner los datos, pulsa 2");
			while(!(opcion=teclado.readLine()).equals("1") && !opcion.equals("2") ) {
				System.out.println("Hola!");
				System.out.println("Si quieres ver un ejemplo con valores por defecto, pulsa 1");
				System.out.println("Si quieres poner los datos, pulsa 2");
			}
			System.out.println(opcion);
			String letras = "";
			if(opcion.equals("1")) {
				urlLyrics = urlLyrics.replace("{artista}", URLEncoder.encode(artista,"UTF-8"));
				urlLyrics = urlLyrics.replace("{cancion}", URLEncoder.encode(cancion,"UTF-8"));
		        HttpGet getRequest = new HttpGet(urlLyrics);
				   System.out.println(urlLyrics);
		        try (CloseableHttpResponse response1 = httpclient.execute(getRequest)) {
		            System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
		            HttpEntity entity1 = response1.getEntity();
		            // do something useful with the   response body
		            resultado = EntityUtils.toString(entity1);
		            // and ensure it is fully consumed
		            EntityUtils.consume(entity1);
		        } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}       
			}
			else {
				System.out.println("Dime el nombre del artista");
				urlLyrics = urlLyrics.replace("{artista}", URLEncoder.encode(teclado.readLine(),"UTF-8"));
				System.out.println("Dime la canción:");
				urlLyrics = urlLyrics.replace("{cancion}", URLEncoder.encode(teclado.readLine(),"UTF-8"));
				HttpGet getRequest = new HttpGet(urlLyrics);
				resultado = httpclient.execute(getRequest, responseHandler);
			}
			JSONObject json = new JSONObject(resultado);
			letras = json.getString("lyrics");
	        letras = letras.replaceAll("\n+", "\n");
	        if(opcion.equals("1"))
	        	System.out.println("Dammit - blink-182 (1997)");
	        else 
	        	System.out.println("Las letras de la canción elegida son:");
	        System.out.print(letras);
	    	teclado.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

	}

}
