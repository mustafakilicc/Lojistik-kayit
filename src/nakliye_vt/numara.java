
package nakliye_vt;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class numara extends javax.swing.JInternalFrame {

   
    public numara() {
        initComponents();
        numaraTablosunuAyarla();
    }
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

    private void numaraTablosunuAyarla() {
        
        try {
            
            Statement s = baglan();
            String sql = "SELECT SOFOR_NO,CONCAT(ISIM,' ',SOYISIM),TELEFON FROM soforler ";
            ResultSet rs = s.executeQuery(sql);
            
            numara_model model = new numara_model(rs);
            jTable1.setModel(model);
        
            
           // baglantiKapat();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Personel Tablosu Gösterilirken Hata Oluştu!!!\n" + e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(44, 62, 80));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Rehber");

        jTable1.setBackground(new java.awt.Color(108, 122, 137));
        jTable1.setForeground(new java.awt.Color(228, 241, 254));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(204, 0, 51));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
