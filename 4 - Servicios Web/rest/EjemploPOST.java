package rest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.Charsets;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;

public class EjemploPOST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");
			// Creamos el contenido del cuerpo, en este caso un JSONObject
			JSONObject objeto = new JSONObject();
			objeto.accumulate("userId", 1);
			objeto.accumulate("title", "prueba");
			objeto.accumulate("body", "cuerpo");
			// Creamos nuestra entidad, la cual estará formada por el contenido
			// de nuestro JSONObject en String.
			StringEntity entidad = new StringEntity(objeto.toString(), StandardCharsets.UTF_8);
			httpPost.setEntity(entidad);
			
			// Asignamos headers a nuestra petición
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json; charset=UTF-8");

			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println(response.getCode() + " mensaje: " + response.getReasonPhrase());
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
