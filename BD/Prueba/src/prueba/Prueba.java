/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;
import java.sql.*;

/**
 *
 * @author hectorsama
 */
public class Prueba {

 public static void main(String[] args) {
        // TODO code application logic here
        try{
            String Query = "select * from student where rol = 1";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gustosculposos?useUnicode=true&useJDBCCompliant&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true", "gustosculposos", "quesoqueso");  
            System.out.println("Conectado!");
            Statement st = conn.createStatement();
            //st.executeUpdate("CREATE   TABLE   prueba   "+ "(id_prueba   INTEGER,   nombre   VARCHAR(30)"+ "cantidad   INTEGER,   total   INTEGER);");
            ResultSet rs = st.executeQuery(Query);
       rs.next();
            String nombre = rs.getString(2);
            System.out.println(nombre);
            //Eliminar un usuario
            st.executeUpdate("DELETE  FROM student WHERE rol=1;");
            //actualizar  estudiante
            st.executeUpdate("UPDATE student SET nombre='jesusu' WHERE rol=2");
            
            conn.close();
        }catch(Exception e){
            
        }
    }
    
}
