
package nakliye_vt;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbKatmani {
    
    
    private Connection conn;
    String dburl="jdbc:mysql://localhost:3306/mydb";
    String user="admin";
    String pass="1234";
    
    
    
    public Statement baglan() throws SQLException{
    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      System.out.println("Baglanti basarili");
      conn =(Connection) DriverManager.getConnection(dburl,user,pass);
    }catch (Exception e){
    System.out.println("Baglanti basarisiz");
    }      
           return (Statement)conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);           
    }
    
    
    public static void main(String Args[]) throws SQLException{
    dbKatmani dbk= new dbKatmani();
    dbk.sofor();
    } 
    
    String kullanici;
    
    public void sofor() throws SQLException{
     if(conn==null){
         System.out.println("bağlı değil bağlanıyorum..");
         baglan();
     }  
    try {
    Statement stmt=baglan();
  //  stmt.executeUpdate("insert into soforler(SOFOR_NO,ISIM) Values(3455,'deneme2')");
    ResultSet rs=stmt.executeQuery("select KULLANICI_ADI from sifreleme ");
   // System.out.println("deneme" );
  // while(rs.next()){
   System.out.println(rs.getString(1)+" "+rs.getString(2) );
   
   //}  
        
   kullanici=rs.getString(1);  
//System.out.println(kullanici); 
    }catch (SQLException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    catch(Exception e) {
    e.printStackTrace();
    }
    }
   
    
    
}
