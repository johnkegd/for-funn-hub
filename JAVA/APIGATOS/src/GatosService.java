import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GatosService {
	
	
	public static void verGatos() throws IOException {
		
			OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://api.thecatapi.com/v1/images/search")
				  .method("GET", null)
				  .build();
				Response response = client.newCall(request).execute();
				
				
				//envolviendo en json
				
				String Json = response.body().string();
				
				Json = Json.substring(1,Json.length());
				Json = Json.substring(0,Json.length()-1);
				
				
				Gson gson = new Gson();
				Gatos gatos = gson.fromJson(Json, Gatos.class);
				
				System.out.println(gatos.getUrl());
				//resize img
		
				Image img = null;
				try {
					URL url = new URL(gatos.getUrl());
					img = ImageIO.read(url);
					
					ImageIcon fondoGato = new ImageIcon(img);
					
					if(fondoGato.getIconWidth() > 800) {
					
						Image fondo = fondoGato.getImage();
						Image resized = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
						fondoGato = new ImageIcon(resized);
					}
					/*
					if(fondoGato.getIconHeight() > 600) {
						
						Image fondo = fondoGato.getImage();
						Image resized = fondo.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
						fondoGato = new ImageIcon(resized);
					}*/
					
					
					// String menu = "Opciones" + "1.Siguiente \n" + "2.favorito \n" + "3.volver \n";
					String [] btn = {"Siguiente","Favorito","DeleteFav","Main Menu"};
					String id_gato = gatos.getId();
					
					int opcion = JOptionPane.showOptionDialog(null, "", "Id: "+ id_gato, 0, JOptionPane.INFORMATION_MESSAGE, fondoGato, btn, btn[0]);
	
					switch(opcion) {
					case 0:
						System.out.println("Siguiente");
						verGatos();
						break;
					case 1:
						System.out.println("favorito : " + gatos.getId());
						addFavorito(gatos);
						break;
					case 2:
						Scanner sc = new Scanner(System.in);
						System.out.println("introduce id: ");
						String respose = sc.nextLine();
						gatos.setId(respose);
						deleteFavorito(gatos);
						break;
					case 3:
						Main.mainMenu();
						break;
					default:
						System.exit(0);
						break;
					
					}
		
					
					
					
				} catch (Exception e) {
					System.out.println(e);
					// TODO: handle exception
				}
			
		
	}
	
	
	

	public static void addFavorito(Gatos gato) throws IOException {
		
		
		try {
			 OkHttpClient client = new OkHttpClient();
				RequestBody body = RequestBody.create("{\n\t\"image_id\": \""+gato.getId()+"\"\n}",null);
	            Request request = new Request.Builder()
	              .url("https://api.thecatapi.com/v1/favourites")
	              .post(body)
	              .addHeader("Content-Type", "application/json")
	              .addHeader("x-api-key", gato.getApikey())
	              .build();
	            Response response = client.newCall(request).execute();
	            System.out.println(response);

		} catch (IOException e) {
			System.out.println(e);
		
		}

		
		
	}
	
	
	
	public static void deleteFavorito(Gatos gato)throws IOException{
		
		try {
			
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
			  .url("https://api.thecatapi.com/v1/favourites/"+gato.getId())
			  .delete()
			  .addHeader("x-api-key", gato.getApikey())
			  .build();

			Response response = client.newCall(request).execute();
			System.out.println(response);
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}
	}
	
	
	

}
