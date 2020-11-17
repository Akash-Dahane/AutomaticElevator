/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiita.gproject.automaticelevatorsys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.mail.MessagingException;
import javax.swing.Timer;
import static jdk.vm.ci.common.InitTimer.timer;
import static jdk.vm.ci.common.InitTimer.timer;

/**
 *
 * @author anshverma
 */
public class Initiate extends javax.swing.JFrame {
    
    public int idx,f,wt,n,cnt=0;   
    public final static int t = 3000;
    private int flag=0;
    NumberTracker track= new NumberTracker(idx,f);
    String[] doorStatus={
        "Closed",
        "Closed",
        "Closed",
        "Opening",
        "Opening",
        "Opening",
        "Closing",
        "Opened",
        "Closing",
        "Opened",
        "Closing",
        "Opened",
        "Closed",
        "Opened",
        
    };
    String[] overallStatus={
        "Lift Moving",
        "Lift Moving",
        "Lift Moving",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "People Entering & Exiting",
        "Power Drop",
        "Lift Capacity Exceeded",
    };
   
    
    public Initiate() throws IOException {
        initComponents();
        track.setVisible(true);
        
        javax.swing.Timer timer;
        timer = new javax.swing.Timer(t, (ActionEvent e) -> {
            
            if(flag==1)
            {
                ((Timer)e.getSource()).stop();
            }
            getContentPane().removeAll();
            try {
                initComponents();
            } catch (IOException ex) {
                Logger.getLogger(Initiate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            track.idx=idx;track.f=f;
            track.getContentPane().removeAll();
            track.initComponents();
            track.validate();
            track.repaint();
            
            validate();
            repaint();
        });
        timer.start(); 
    }

    public int rand(int l) {
    int pick = new Random().nextInt(l);
    return pick;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    
    public void precomp() {
        idx= rand(doorStatus.length);
        f= rand(5);
        if(idx<13)
        wt= rand(600);
        else
        wt= (int)(Math.random() * (900 - 700 + 1) + 700);
    }
    private void initComponents() throws IOException {
     
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        doorLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        peopleLabel = new javax.swing.JLabel();
        floorLabel = new javax.swing.JLabel();
        statLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Automatic Lift");
        
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Lift Status");

        jLabel2.setText("Door Status :");

        jLabel3.setText("Weights :");

        jLabel4.setText("No. of People in lift :");

        jLabel5.setText("Floor No. :");

        jLabel6.setText("Overall Status :");
        
        precomp();
        if(wt<60)
            n=1;
        else
            n= wt/50;
        
        doorLabel.setText(doorStatus[idx]);

        weightLabel.setText(Integer.toString(wt));
        
        peopleLabel.setText(Integer.toString(n));

        floorLabel.setText(Integer.toString(f));

        statLabel.setText(overallStatus[idx]);
        if("Power Drop".equals(statLabel.getText())){
            SendEmail sendEmail = new SendEmail();
        }
        
        
        jButton1.setText("Quit");
       
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doorLabel)
                            .addComponent(weightLabel)
                            .addComponent(peopleLabel)
                            .addComponent(floorLabel)
                            .addComponent(statLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton1))
                .addContainerGap(64, Short.MAX_VALUE)
            )       
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(doorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(weightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(peopleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(floorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(statLabel))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(79, Short.MAX_VALUE)
            )
                
        );

        pack();
        try{
            LogManager lm = LogManager.getLogManager();
            String LoggerName = Logger.GLOBAL_LOGGER_NAME;
            Logger logrep = lm.getLogger(LoggerName);
            logrep.setLevel(Level.INFO);
            logrep.setUseParentHandlers(false);

            FileHandler fh = new FileHandler("logreports.log",0,1,true);
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.INFO);
            logrep.addHandler(fh);
            logrep.log(Level.INFO, "\nWeight in lift:{0}\nNumber of people:{1}\nFloor no:{2}\nOverall Status:{3}", new Object[]{wt, n, f, statLabel.getText()});
            fh.flush();
            fh.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
    }// </editor-fold>                        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        flag=1;
        this.dispose();
        track.dispose();
    }
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        
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
            java.util.logging.Logger.getLogger(Initiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Initiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Initiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Initiate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Initiate().setVisible(true);
        }
        });*/
    }
   
    

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel doorLabel;
    private javax.swing.JLabel floorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel peopleLabel;
    public javax.swing.JLabel statLabel;
    private javax.swing.JLabel weightLabel;
    // End of variables declaration                   
}
