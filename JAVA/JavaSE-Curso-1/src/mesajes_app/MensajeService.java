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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Tiene algun Id de mensaje?");
		System.out.println("1. Si  / 2.No : ");
		int respose = Integer.parseInt(sc.nextLine());
		
		if(respose == 1) {
			int id = sc.nextInt();
			Mensajes consulta = new Mensajes();
			consulta.setId_mensaje(id);
			
		}else {
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	public static void borrarMensajes() {
		System.out.println("borrando mensaje xd");
	}
	
	public static void editarMensajes() {
		System.out.println("editando mensaje xd");
	}
	
	
	

}
