
package nakliye_vt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDemo {
   
    public static void main(String[] args) throws SQLException {
       baglan();
       sofor_listesi();
    }
static Connection con = null;
public static void baglan(){
 try {
            Class.forName("com.mysql.jdbc.Driver");
           
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veritabani","admin","1234");
       
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }}

public static void sofor_listesi() throws SQLException{

PreparedStatement pr = con.prepareStatement("select * from soforler");
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                String isim = rs.getString(1);
                System.out.println(isim);
            }
            rs.close();
            pr.close();
            con.close(); 

}



}
