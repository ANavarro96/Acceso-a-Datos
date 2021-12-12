package ejemplosjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON {
	
	static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	static final String JSONEjemplo = "{ story : \"Have you heard of swamp harmonica steady?\"}";
	static final String JSONArrayEjemplo = "[{\"id\":264033,\"type\":\"Song\",\"title\":\"I Was Scared And Im Sorry\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"CHORDS\"]},{\"id\":264034,\"type\":\"Song\",\"title\":\"Local Man Ruins Everything\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264035,\"type\":\"Song\",\"title\":\"My Last Semester\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264036,\"type\":\"Song\",\"title\":\"Logan Circle\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264037,\"type\":\"Song\",\"title\":\"Hey Thanks\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264038,\"type\":\"Song\",\"title\":\"Wont Be Pathetic Forever\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264039,\"type\":\"Song\",\"title\":\"Living Room Song\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"CHORDS\"]},{\"id\":264040,\"type\":\"Song\",\"title\":\"Christmas At 22\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"CHORDS\"]},{\"id\":264041,\"type\":\"Song\",\"title\":\"This Party Sucks\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264042,\"type\":\"Song\",\"title\":\"Everything I Own Fits In This Backpack\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":264043,\"type\":\"Song\",\"title\":\"Ive Given You All\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"CHORDS\"]},{\"id\":264044,\"type\":\"Song\",\"title\":\"Youre Not Salinger Get Over It\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":278665,\"type\":\"Song\",\"title\":\"And Now Im Nothing\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":278666,\"type\":\"Song\",\"title\":\"Melrose Diner\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337678,\"type\":\"Song\",\"title\":\"Racing Trains\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337679,\"type\":\"Song\",\"title\":\"Washington Square Park\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337680,\"type\":\"Song\",\"title\":\"Dont Let Me Cave In\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337681,\"type\":\"Song\",\"title\":\"All My Friends Are In Bar Bands\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337682,\"type\":\"Song\",\"title\":\"Dynamite Shovel\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337683,\"type\":\"Song\",\"title\":\"Keystone State Dude-core\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337684,\"type\":\"Song\",\"title\":\"Buzz Aldrin The Poster Boy For Second Place\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337685,\"type\":\"Song\",\"title\":\"Solo And Chewy Holdin It Down\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337686,\"type\":\"Song\",\"title\":\"Lets Moshercise\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337687,\"type\":\"Song\",\"title\":\"Mike Kennedy Is A Bad Friend\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337688,\"type\":\"Song\",\"title\":\"We Wont Bury You\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337689,\"type\":\"Song\",\"title\":\"Coffee Eyes\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337690,\"type\":\"Song\",\"title\":\"Came Out Swinging\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":true,\"tabTypes\":[\"TEXT_GUITAR_TAB\",\"CHORDS\"]},{\"id\":337691,\"type\":\"Song\",\"title\":\"Hoodie Weather\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":337692,\"type\":\"Song\",\"title\":\"Bout To Get Fruit Punched Homie\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"TEXT_GUITAR_TAB\"]},{\"id\":383759,\"type\":\"Song\",\"title\":\"You're Not Salinger, Get Over It\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":398445,\"type\":\"Song\",\"title\":\"Local Man Ruins Everything\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":398446,\"type\":\"Song\",\"title\":\"The Devil In Ma Bloodstream\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":400864,\"type\":\"Song\",\"title\":\"Came Out Swinging\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":401287,\"type\":\"Song\",\"title\":\"Hoodie Weather\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":401313,\"type\":\"Song\",\"title\":\"There, There\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":401577,\"type\":\"Song\",\"title\":\"Cardinals\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":402050,\"type\":\"Song\",\"title\":\"My Last Semester V1\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":404793,\"type\":\"Song\",\"title\":\"Brothers &\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":404896,\"type\":\"Song\",\"title\":\"Dismantling Summer\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":404897,\"type\":\"Song\",\"title\":\"Suburbia\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":409790,\"type\":\"Song\",\"title\":\"I Don't Like Who I Was Then\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":409791,\"type\":\"Song\",\"title\":\"Cigarettes & Saints\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":426629,\"type\":\"Song\",\"title\":\"We Won't Bury You\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":426630,\"type\":\"Song\",\"title\":\"Living Room Song\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":426631,\"type\":\"Song\",\"title\":\"Hey Thanks\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":426632,\"type\":\"Song\",\"title\":\"Dynamite Shovel\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":433216,\"type\":\"Song\",\"title\":\"Passing Through A Screen Door\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":433250,\"type\":\"Song\",\"title\":\"Chaser\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":433258,\"type\":\"Song\",\"title\":\"A Song For Patsy Cline\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":433373,\"type\":\"Song\",\"title\":\"Cul-De-Sac\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":433374,\"type\":\"Song\",\"title\":\"I Just Want To Sell Out My Funeral\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":443522,\"type\":\"Song\",\"title\":\"I Ain't Saying He A Gold Digga (Sike!)\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]},{\"id\":460868,\"type\":\"Song\",\"title\":\"I Do Not Like Who I Was Back Then\",\"artist\":{\"id\":38911,\"type\":\"Artist\",\"nameWithoutThePrefix\":\"Wonder Years\",\"useThePrefix\":true,\"name\":\"The Wonder Years\"},\"chordsPresent\":false,\"tabTypes\":[\"PLAYER\"]}]";

	public static void recorrerJSON(JSONObject o) {
				for (String clave : o.keySet()) {
					System.out.print(" Clave : " + clave + " valor: " + o.get(clave));
				}
				System.out.println();
	}
	
	public static void ejemploJSONObject(String valorInicial) {
		
		if(valorInicial == null) {
		JSONObject lebron = new JSONObject();
		
		// Con put añadimos o actualizamos el valor de una clave.
		// Podemos incluir cualquier valor: entero, decimal, booleano, OTRO JSONObject....
		lebron.put("Nombre", "Felipe Reyes");
		lebron.put("Nombre", "Lebron James");
		lebron.put("Edad", 37);
		lebron.accumulate("GOAT", true);
		
		// Con append lo que hacemos es crear una lista de valores en la clave.
		lebron.append("PPP", 27.7);
		lebron.accumulate("PPP", 30.3);
		
		
		// Así podemos iterar sobre un JSONObject.
		recorrerJSON(lebron);
		
		lebron.remove("GOAT");
		// No da error
		lebron.opt("Años En la LIGAAA");
		// Sí que lo da, descomentalo para verlo bien
		// lebron.get("No existe");
	
		}
		else {
			
			JSONObject objeto = new JSONObject(valorInicial);
			recorrerJSON(objeto);
			
			
		}
		
	}
	
	public static void ejemploJSONArray(String valorInicial) {
		if(valorInicial == null) {
			JSONArray listaJugadores = new JSONArray();
			
			JSONObject lebron = new JSONObject().accumulate("nombre", "Lebron James");
			JSONObject alocen = new JSONObject().accumulate("nombre", "Carlos Alocén");
			
			listaJugadores.put(lebron);
			listaJugadores.put(alocen);
			

			
			
			for(int i = 0;i < listaJugadores.length();i++) {
				JSONObject jugador = listaJugadores.getJSONObject(i);
				
				recorrerJSON(jugador);
				
			}
			
		}
		else {
			JSONArray listaCancionesTWY = new JSONArray(valorInicial);
			
			for(int i = 0;i < listaCancionesTWY.length();i++) {
				JSONObject cancion = listaCancionesTWY.getJSONObject(i);
				
				recorrerJSON(cancion);
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = -1;
		System.out.println("Qué versión quieres ejecutar?");
		System.out.println("1 - Ejemplo de JSONOBject con datos iniciales");
		System.out.println("2 - Ejemplo de JSONObject construyéndolo desde cero");
		System.out.println("3 - Ejemplo de JSONArray con datos iniciales");
		System.out.println("4 - Ejemplo de JSONArray construyéndolo desde cero");
		try {
			while((opcion = Integer.parseInt(teclado.readLine())) < 1 || opcion > 4) {
				System.out.println("Qué versión quieres ejecutar?");
				System.out.println("1 - Ejemplo de JSONOBject con datos iniciales");
				System.out.println("2 - Ejemplo de JSONObject construyéndolo desde cero");
				System.out.println("3 - Ejemplo de JSONArray con datos iniciales");
				System.out.println("4 - Ejemplo de JSONArray construyéndolo desde cero");
			}
			if(opcion == 1) ejemploJSONObject(JSONEjemplo);
			else if (opcion == 2) ejemploJSONObject(null);
			else if (opcion==3) ejemploJSONArray(JSONArrayEjemplo);
			else ejemploJSONArray(null);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		System.err.println("No me pongas cosas raras");
			
		} catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
	}

}
