/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static kelimeoyunu.gameGUI.timerBG_label;
import static kelimeoyunu.gameGUI.timer_label;
import static kelimeoyunu.gameGUI.tpuan_label;

public class welcomeGUI extends javax.swing.JFrame {

    //Define variables
    static String username;
    
    //Define ImageIcon for images
    public ImageIcon yesilBG = new ImageIcon(new ImageIcon(getClass().getResource("yesil.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    public ImageIcon turuncuBG = new ImageIcon(new ImageIcon(getClass().getResource("turuncu.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    public ImageIcon kirmiziBG = new ImageIcon(new ImageIcon(getClass().getResource("kirmizi.png")).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    
    //Define Date
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    
    //Define Timer
    public static Timer timer = new Timer();
    public Timer t = new Timer();
    public TimerTask tt = null;
    public TimerTask ct = null;
    
    public static int diffCounter = -1;
    public static int difficulty = 1;
    

    public welcomeGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basla_button = new javax.swing.JButton();
        soru_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(780, 520));
        setMinimumSize(new java.awt.Dimension(780, 520));
        setPreferredSize(new java.awt.Dimension(780, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(780, 520));
        getContentPane().setLayout(null);

        basla_button.setBackground(new java.awt.Color(51, 0, 51));
        basla_button.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        basla_button.setText("Oyuna Başla");
        basla_button.setAutoscrolls(true);
        basla_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basla_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(basla_button);
        basla_button.setBounds(490, 170, 210, 70);

        soru_button.setBackground(new java.awt.Color(51, 0, 51));
        soru_button.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        soru_button.setText("Soru Ekle");
        soru_button.setAutoscrolls(true);
        soru_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soru_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(soru_button);
        soru_button.setBounds(490, 270, 210, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\src\\kelimeoyunu\\welcomeback3.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //start button actions
    private void basla_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basla_buttonActionPerformed

        username = JOptionPane.showInputDialog(null, "Lütfen Kullanıcı Adı Giriniz", "Bilgi Ekranı", JOptionPane.QUESTION_MESSAGE);
        System.out.println(username);

        if (username == null || username.equals("")) {

            JOptionPane.showMessageDialog(null, "Lütfen Kullanıcı Adı Giriniz");

        } else {
            JOptionPane.showMessageDialog(null, "Hoşgeldiniz");
            gameGUI frame1 = new gameGUI();
            setVisible(false);
            frame1.setVisible(true);
            frame1.setResizable(false);

            String path = "C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\src\\kelimeoyunu\\kayıt.txt";

            File file = new File(path);

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                System.out.println("Dosya Mevcut");
            }

            try {
                FileWriter dosya_yaz = new FileWriter(path, true);
                BufferedWriter writer = new BufferedWriter(dosya_yaz);
                writer.write(username + " ");

                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            gameGUI.running = true;

            ct = new TimerTask() {
                int time = 4 * 60;

                @Override
                public void run() {
                    if (gameGUI.running != false) {
                        time -= 1;
                        String a = Integer.toString(time);
                        timer_label.setText(a);
                        if (time > 180) {
                            timer_label.setForeground(Color.BLACK);
                            timerBG_label.setIcon(yesilBG);
                        } else if (180 >= time && time >= 60) {
                            timer_label.setForeground(Color.BLACK);
                            timerBG_label.setIcon(turuncuBG);
                        } else {
                            timer_label.setForeground(Color.BLACK);
                            timerBG_label.setIcon(kirmiziBG);
                        }
                        if (time == 0) {
                            timer.cancel();
                            gameOverGUI frame = new gameOverGUI();
                            frame1.setVisible(false);
                            frame.setVisible(true);
                            frame.setResizable(false);
                            
                            
                            
                            frame.isim_label.setText(username);
                            frame.tpuan2_label.setText(tpuan_label.getText());
                            frame.time_label.setText(timer_label.getText());
                            frame.date_label.setText(formatter.format(date));
                            //gameOverGUI.gameover_label.setText(welcomeGUI.username + " ,Topladığınız Puan : " + tpuan_label.getText() + " ,Kalan Süre : " + timer_label.getText() + " ,Oynama Tarihi ve Zamanı : " + formatter.format(date));
                        }
                    }
                }
            };
            /*
            tt = new TimerTask() {
                @Override
                public void run() {

                    if (difficulty == 4) {

                        //setVisible(false);
                        //gg.setVisible(false);
                        //frame.setVisible(true);

                        t.cancel();
                    }
                }
            };*/

            //t.schedule(tt, 0, 1000);
            timer.schedule(ct, 0, 1000);

        }


    }//GEN-LAST:event_basla_buttonActionPerformed

    private void soru_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soru_buttonActionPerformed

        AddQuestion frame = new AddQuestion();
        setVisible(false);
        frame.setVisible(true);
        frame.setResizable(false);

    }//GEN-LAST:event_soru_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(welcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcomeGUI().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton basla_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton soru_button;
    // End of variables declaration//GEN-END:variables
}
