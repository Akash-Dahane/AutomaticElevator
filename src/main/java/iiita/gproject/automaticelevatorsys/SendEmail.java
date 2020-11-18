/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiita.gproject.automaticelevatorsys;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author bluelord
 */
public class SendEmail {
    public SendEmail(){
         File f = new File("emailfile");
        /*if(f.exists() == false){
            f.createNewFile();
            
        }
        BufferedWriter bf = null;
        bf = new BufferedWriter(new FileWriter(f));
        bf.write("x");
        bf.close();*/
        BufferedReader cr = null;
        try {
            cr = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(f))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
	String recpt=null;
        try {
            recpt = cr.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cr.close();
        } catch (IOException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String recpt="iit2019176@iiita.ac.in"; //contact.akashdahane@gmail.com
        // TODO code application logic here
        Email.emailer(recpt);
        //System.out.println("done");
    }
    /**
     * @param args the command line arguments
     * @throws javax.mail.MessagingException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws MessagingException, IOException {
       
        //System.out.println("done");
    }
    
}
