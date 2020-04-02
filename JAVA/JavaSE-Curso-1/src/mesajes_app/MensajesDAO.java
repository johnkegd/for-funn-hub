package mesajes_app;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class MensajesDAO {

	
	
	public static void crearMensajesDB(Mensajes mensaje) {
	
		Conextion db_connect = new Conextion();
		
		try(Connection conexion = db_connect.get_connection()){
			
			PreparedStatement ps = null;
			
			try{
				String query = "INSERT INTO mensaje (mensaje, autor_mensaje) VALUES (?, ?)";
				ps = conexion.prepareStatement(query);
				ps.setString(1, mensaje.getMensaje());
				ps.setString(2,	mensaje.getAutor_mensaje());
				ps.executeUpdate();
				System.out.println("Mensaje Creado Correctamente");
				
			} catch (SQLException ex) {
				System.out.println(ex);
			}
			
		} catch(SQLException e){
			System.out.println(e);
		}
		
		
		
	}
	
	
	public static void leerMensajesDB() {
		
	}
	
	
	public static void borrarMensajeDB(int id_mensaje) {
		
	}
	
	public static void actualizarMensajesDB(Mensajes mensaje) {
		
	}
	
	
	
	
}
