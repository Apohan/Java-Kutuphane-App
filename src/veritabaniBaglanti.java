import java.sql.Connection;
import java.sql.DriverManager;

public class veritabaniBaglanti {
    public static Connection getConnection (){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kutuphane","root","");
            System.out.println("Bağlandı");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
        
        
        return connection;
    }
}
