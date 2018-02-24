package nakliye_vt;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class faturalar extends javax.swing.JInternalFrame {

   
    public faturalar() throws SQLException {
        initComponents();
        faturaTablosunuAyarla();
        
        
         Statement s = baglan();
            String sql = "SELECT CURDATE() as trh ";
          // String[] dizi=null;
           String tarih=null;
            ResultSet rs = s.executeQuery(sql);
           while(rs.next()){
               tarih=rs.getString("trh");
           jTextField1.setText(tarih);
           }
            
        
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
    
     private void faturaTablosunuAyarla() {
        
        try {
            
            Statement s = baglan();
            String sql = "SELECT FATURA_NO,FATURA_TARIHI,FATURA_TUTARI,CONCAT(ISIM,' ',SOYISIM) FROM faturalar,soforler where soforler.SOFOR_NO=faturalar.soforler_SOFOR_NO";
            ResultSet rs = s.executeQuery(sql);
            
            faturamodel model = new faturamodel(rs);
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(44, 62, 80));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Faturalar");
        setToolTipText("");

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
        jTable1.setToolTipText("Faturalar");
        jTable1.setGridColor(new java.awt.Color(204, 0, 51));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setText("Fatura Tarihi:");

        jTextField1.setBackground(new java.awt.Color(108, 122, 137));
        jTextField1.setForeground(new java.awt.Color(228, 241, 254));
        jTextField1.setText("jTextField1");

        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Tutar:");

        jTextField2.setBackground(new java.awt.Color(108, 122, 137));
        jTextField2.setForeground(new java.awt.Color(228, 241, 254));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Şöför TC:");

        jTextField3.setBackground(new java.awt.Color(108, 122, 137));
        jTextField3.setForeground(new java.awt.Color(228, 241, 254));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nakliye_vt/button_kaydet.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
//        String cumle =jTextField3.getText();
//        String[] kelime = null; 
//        kelime = cumle.split(" "); /*boşluk referansına gore parçalıyor*/
//        System.out.println(kelime[0]+"---"+kelime[1]);
             int ftr_no=4;
             Statement stmt1;
        try {
            stmt1 = baglan();
            String sql="insert into faturalar (FATURA_NO,FATURA_TARIHI,FATURA_TUTARI,soforler_SOFOR_NO) values("+ftr_no+",'"+jTextField1.getText()+"',"+jTextField2.getText()+","+jTextField3.getText();
            stmt1.executeUpdate(sql);
    
        } catch (SQLException ex) {
            Logger.getLogger(faturalar.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
