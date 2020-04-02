package mesajes_app;
import java.util.Scanner;


public class MensajeService {
	
	
	public static void crearMensaje() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe tu mensaje: ");
		String mensaje = sc.nextLine();
		
		System.out.println("Tu nombre: ");
		String nombre = sc.nextLine();
		
		
		Mensajes registro = new Mensajes();
		registro.setMensaje(mensaje);
		registro.setAutor_mensaje(nombre);
		
		
		MensajesDAO.crearMensajesDB(registro);
		
	}
	
	public static void listarMensajes() {
		System.out.println("listando mensaje xd");
	}
	
	public static void borrarMensajes() {
		System.out.println("borrando mensaje xd");
	}
	
	public static void editarMensajes() {
		System.out.println("editando mensaje xd");
	}
	
	
	

}
