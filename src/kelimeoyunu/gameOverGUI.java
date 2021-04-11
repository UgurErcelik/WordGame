/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import static kelimeoyunu.gameGUI.timer_label;
import static kelimeoyunu.gameGUI.tpuan_label;
//import static kelimeoyunu.welcomeGUI.username;

/**
 *
 * @author ugure
 */
public class gameOverGUI extends javax.swing.JFrame {
    
    String path="src\\kelimeoyunu\\kayıt.txt";
    public void DosyaYaz()
    {
        try {
                
                FileWriter dosya_yaz = new FileWriter(path,true);
                BufferedWriter writer = new BufferedWriter(dosya_yaz);
                
                writer.write(tpuan_label.getText());
                
                writer.newLine();
                writer.close();
                
            } catch (Exception e) { 
                e.printStackTrace();
            }
    }
    
    public gameOverGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        isim_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tpuan2_label = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(720, 510));
        setMinimumSize(new java.awt.Dimension(720, 510));
        setPreferredSize(new java.awt.Dimension(720, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SÜRENİZ BİTTİ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 0, 360, 79);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("İSİM :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 35, 30);

        isim_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(isim_label);
        isim_label.setBounds(70, 90, 210, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TOPLANAN PUAN :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 180, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("KALAN SÜRE :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 270, 90, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("OYNAMA TARİHİ VE ZAMANI :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 370, 180, 50);

        tpuan2_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(tpuan2_label);
        tpuan2_label.setBounds(140, 170, 150, 50);

        time_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(time_label);
        time_label.setBounds(130, 260, 150, 60);

        date_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(date_label);
        date_label.setBounds(210, 370, 250, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\WordGame\\src\\wordgame\\Untitled2.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 720, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel date_label;
    public static javax.swing.JLabel isim_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel time_label;
    public static javax.swing.JLabel tpuan2_label;
    // End of variables declaration//GEN-END:variables
}
