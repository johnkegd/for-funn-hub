package mesajes_app;

import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

	public static void main(String [] args){
		
		Conextion conextion1 = new Conextion();
		
		try (Connection cnx = conextion1.get_connection()){
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	
	
}
