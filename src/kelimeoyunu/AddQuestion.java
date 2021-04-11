/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static kelimeoyunu.Database.difficulty;




public class AddQuestion extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    public AddQuestion() {
        initComponents();
        conn=connect();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zorluk_label = new javax.swing.JLabel();
        soru_label = new javax.swing.JLabel();
        cevap_label = new javax.swing.JLabel();
        durum_label = new javax.swing.JLabel();
        zorluk_field = new javax.swing.JTextField();
        soru_field = new javax.swing.JTextField();
        cevap_field = new javax.swing.JTextField();
        durum_field = new javax.swing.JTextField();
        ekle_button = new javax.swing.JButton();
        anaekran_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(720, 510));
        setMinimumSize(new java.awt.Dimension(720, 510));
        setPreferredSize(new java.awt.Dimension(720, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        zorluk_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        zorluk_label.setText("Zorluk :");
        getContentPane().add(zorluk_label);
        zorluk_label.setBounds(10, 400, 90, 30);

        soru_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soru_label.setText("Soru :");
        getContentPane().add(soru_label);
        soru_label.setBounds(10, 40, 90, 30);

        cevap_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cevap_label.setText("Cevap :");
        getContentPane().add(cevap_label);
        cevap_label.setBounds(10, 180, 90, 30);

        durum_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        durum_label.setText("Durum :");
        getContentPane().add(durum_label);
        durum_label.setBounds(10, 290, 90, 30);
        getContentPane().add(zorluk_field);
        zorluk_field.setBounds(80, 400, 130, 30);
        getContentPane().add(soru_field);
        soru_field.setBounds(80, 40, 380, 80);
        getContentPane().add(cevap_field);
        cevap_field.setBounds(80, 170, 190, 60);
        getContentPane().add(durum_field);
        durum_field.setBounds(80, 290, 130, 30);

        ekle_button.setText("EKLE");
        ekle_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekle_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(ekle_button);
        ekle_button.setBounds(530, 415, 130, 50);

        anaekran_button.setText("ANA EKRAN");
        anaekran_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anaekran_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(anaekran_button);
        anaekran_button.setBounds(530, 350, 130, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\src\\kelimeoyunu\\gamegui.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekle_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekle_buttonActionPerformed
        
        
        String sql = "INSERT INTO questions(question,answer,status,difficulty) VALUES(?,?,?,?)";
        
        try{
            pst = conn.prepareStatement(sql);
            
            pst.setString(1,soru_field.getText());
            pst.setString(2,cevap_field.getText());
            pst.setString(3,durum_field.getText());
            pst.setString(4,zorluk_field.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Başarıyla Eklendi");
            
        }catch (Exception e){
            
            JOptionPane.showMessageDialog(null,e);
            
        }
    }//GEN-LAST:event_ekle_buttonActionPerformed

    private void anaekran_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anaekran_buttonActionPerformed
        welcomeGUI frame = new welcomeGUI();
        setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_anaekran_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anaekran_button;
    public static javax.swing.JTextField cevap_field;
    private javax.swing.JLabel cevap_label;
    public static javax.swing.JTextField durum_field;
    private javax.swing.JLabel durum_label;
    private javax.swing.JButton ekle_button;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JTextField soru_field;
    private javax.swing.JLabel soru_label;
    public static javax.swing.JTextField zorluk_field;
    private javax.swing.JLabel zorluk_label;
    // End of variables declaration//GEN-END:variables
}
