import java.util.*;
import java.sql.*;
public class practicaBD{
	public static void menu(){

		Scanner sc= new Scanner (System.in);
		System.out.println("Bienvenido");
		System.out.println("¿Te quieres registrar como:");
		System.out.println("1)Cliente");
		System.out.println("2Socio");

	}

	public static void main(String[] args) {
	 try
            {
                Class.forName("oracle.jdbc.OracleDriver");

                Connection con = DriverManager.getConnection(url, userName, password);
		
	}catch(java.lang.ClassNotFoundException e) {
  e.printStackTrace();
}

                Connection conn;
try {
   conn = DriverManager.getConnection(connectionURL);

  Statement st = conn.createStatement();

  // borra un usuario en concreto
st.execute("DELETE * FROM Cliente WHERE id_Cliente='101'");
} catch (Throwable e)  {
  System.out.println("Ha fallado el borrado de datos");
  e.printStackTrace();
} finally {
  try { conn.close(); }
  catch (Throwable t){}
}
}

}