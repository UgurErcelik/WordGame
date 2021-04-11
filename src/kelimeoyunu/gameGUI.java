/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
//import static kelimeoyunu.welcomeGUI.timer;

public class gameGUI extends javax.swing.JFrame {

    String cevap = "";
    String soru = "";
    
    public int id = 0;
    public int counter = 0;
    
    public static char ch[];
    public static int buffer[];
    
    public static int index = 0;
    public int alınan_harf = 0;
    
    
    public static boolean running = false;
    

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    public static Timer timerr = new Timer();
    public TimerTask ttt;
    
    
    //gameOverGUI go = new gameOverGUI();
    //welcomeGUI wg = new welcomeGUI();
    
    
    Database db = new Database();

    int zorluk = 1;

    public gameGUI() {
        initComponents();
        soruyaz();
        
        

    }
    
    
    
    public void SoruTimer()
    {
        ttt = new TimerTask() {
            int zaman = 1*20;
            @Override
            public void run() {
                
               zaman-=1; 
                System.out.println("Kalan Zaman : " + zaman);
                if(zaman == 0)
                {
                    ttt.cancel();
                    int Tpoint = Integer.parseInt(tpuan_label.getText());
                    JOptionPane.showMessageDialog(null,"Cevap Girmediğiniz İçin Puanınız 100 Puan Düşürüldü.","Bilgi Ekranı", JOptionPane.INFORMATION_MESSAGE);
                    Tpoint -= 100;
                    tpuan_label.setText(Integer.toString(Tpoint));
                    soruyaz();
                    SoruTimer();
                }
            }
        };
        timerr.schedule(ttt,0,1000);
    }
    
    
    

    public static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int indeks = rnd.nextInt(i + 1);
            int a = ar[indeks];
            ar[indeks] = ar[i];
            ar[i] = a;
        }

    }

    public void createBuffer() {
        buffer = new int[cevap.length()];
        ch = new char[cevap.length()];

        for (int i = 0; i < cevap.length(); i++) {
            buffer[i] = i;
        }
        shuffleArray(buffer);
    }

    public void soruyaz() {

        if (counter % 2 == 0 && counter != 0) {

            zorluk++;

        }

        ArrayList<Object> array;

        String str_zorluk = String.valueOf(zorluk);

        array = db.queryQuestion(str_zorluk);
        id = Integer.parseInt(array.get(0).toString());
        soru = array.get(1).toString();
        cevap = array.get(2).toString();

        soru_field.setText(array.get(1).toString());
        String DEFanswer = "";
        int strLen = array.get(2).toString().length();
        for (int i = 0; i < strLen; i++) {
            DEFanswer += " _";
        }

        cevap_field.setText(DEFanswer);
        spuan_label.setText(Integer.toString(strLen * 100));

        //System.out.println(array.get(1).toString());
        counter++;
        index=0;
        
        createBuffer();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cevapver_button = new javax.swing.JButton();
        harfalayım_button = new javax.swing.JButton();
        soru_field = new javax.swing.JTextField();
        cevap_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tpuan_label = new javax.swing.JLabel();
        spuan_label = new javax.swing.JLabel();
        timer_label = new javax.swing.JLabel();
        timerBG_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(1100, 590));
        setMinimumSize(new java.awt.Dimension(1100, 590));
        setPreferredSize(new java.awt.Dimension(1100, 590));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        cevapver_button.setText("CEVAP VER");
        cevapver_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevapver_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(cevapver_button);
        cevapver_button.setBounds(730, 410, 140, 40);

        harfalayım_button.setText("HARF ALAYIM");
        harfalayım_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harfalayım_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(harfalayım_button);
        harfalayım_button.setBounds(730, 340, 140, 40);
        getContentPane().add(soru_field);
        soru_field.setBounds(10, 380, 610, 80);
        getContentPane().add(cevap_field);
        cevap_field.setBounds(150, 490, 300, 50);

        jLabel2.setText("TOPLAM PUAN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(620, 50, 90, 40);

        jLabel3.setText("SORU PUANI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(740, 60, 80, 20);

        tpuan_label.setText("0");
        getContentPane().add(tpuan_label);
        tpuan_label.setBounds(620, 110, 90, 70);
        getContentPane().add(spuan_label);
        spuan_label.setBounds(740, 110, 90, 70);

        timer_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(timer_label);
        timer_label.setBounds(200, 90, 120, 110);

        timerBG_label.setIcon(new javax.swing.ImageIcon("C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\src\\kelimeoyunu\\yesil.png")); // NOI18N
        getContentPane().add(timerBG_label);
        timerBG_label.setBounds(60, 0, 380, 330);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\src\\kelimeoyunu\\gamegui.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cevapver_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevapver_buttonActionPerformed
      
        SoruTimer();
        running = false;
   
        
        int Tpoint = Integer.parseInt(tpuan_label.getText());
        String answer = JOptionPane.showInputDialog(null, "Cevabı Giriniz", "Cevap Kutusu", JOptionPane.INFORMATION_MESSAGE);
        
        if(answer == null ){
            
            ttt.cancel();
            JOptionPane.showMessageDialog(null,"Cevap Girmediğiniz İçin Puanınız 100 Puan Düşürüldü.","Bilgi Ekranı", JOptionPane.INFORMATION_MESSAGE);
            Tpoint -= 100;
            tpuan_label.setText(Integer.toString(Tpoint));
            soruyaz();
            
        }else{
            String sql = "SELECT * FROM questions WHERE id ="+id+"";
            try (Connection conn = db.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)) {
                String donenCevap = answer.toUpperCase();
                if(donenCevap.equals(rs.getString("answer"))){
                    
                    ttt.cancel();
                    alınan_harf=0;
                    int Qpoint = Integer.parseInt(spuan_label.getText());
                    Tpoint += Qpoint; 
                    
                    tpuan_label.setText(Integer.toString(Tpoint));
                    
                    if(counter <= 13)//5
                    {
                       soruyaz(); 
                    }
                    else
                    {
                       gameOverGUI frame = new gameOverGUI();
                       setVisible(false);
                       frame.setVisible(true);
                       frame.setResizable(false);
                       
                       welcomeGUI gui = new welcomeGUI();
                       frame.isim_label.setText(gui.username);
                       frame.tpuan2_label.setText(tpuan_label.getText());
                       frame.time_label.setText(timer_label.getText());
                       frame.date_label.setText(formatter.format(date));
                       
                       
                       //gameOverGUI.gameover_label.setText(welcomeGUI.username + " ,Topladığınız Puan : " + tpuan_label.getText() + " ,Kalan Süre : " + timer_label.getText() + " ,Oynama Tarihi ve Zamanı : " + formatter.format(date));
                    }
                    String UpdateSQL = "UPDATE questions SET status=1 WHERE id ="+ id+"";
                    stmt.executeQuery(UpdateSQL);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Girdiğiniz Cevap Yanlış");
                    ttt.cancel();
                    Tpoint -= ((zorluk+3-alınan_harf)*100);
                    tpuan_label.setText(Integer.toString(Tpoint));
                    
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        running = true;
        

    }//GEN-LAST:event_cevapver_buttonActionPerformed

    private void harfalayım_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harfalayım_buttonActionPerformed

        alınan_harf++;
        if(zorluk+3 <= alınan_harf){
            JOptionPane.showMessageDialog(null, "Harf Alma Hakkınız Kalmadı", "UYARI", JOptionPane.ERROR_MESSAGE);
            
        }
        else
        {
            int cvp_len = cevap.length();
        

        for (int i = 0; i < cvp_len; i++) {

            if (ch[i] != cevap.charAt(i)) {
                if (i == buffer[index]) {
                    ch[i] = cevap.charAt(i);
                    

                } else {
                    ch[i] = '_';
                    
                }
            }
        }
        System.out.println(index);
        index++;
        String newAnswer = "";
        for (int i = 0; i < cvp_len; i++) {
            newAnswer += " " + ch[i];
            
        }
        cevap_field.setText(newAnswer);
        
        
        int a = Integer.parseInt(spuan_label.getText());
        a -= 100;
        spuan_label.setText(Integer.toString(a));
            
        }
        

    }//GEN-LAST:event_harfalayım_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cevap_field;
    private javax.swing.JButton cevapver_button;
    private javax.swing.JButton harfalayım_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JTextField soru_field;
    public static javax.swing.JLabel spuan_label;
    public static javax.swing.JLabel timerBG_label;
    public static javax.swing.JLabel timer_label;
    public static javax.swing.JLabel tpuan_label;
    // End of variables declaration//GEN-END:variables
}

          

