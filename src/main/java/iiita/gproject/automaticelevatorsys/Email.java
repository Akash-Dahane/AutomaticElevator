/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiita.gproject.automaticelevatorsys;
/**
 *
 * @author bluelord
 */


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.mail.*;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class Email {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args){
        //System.out.println("test");
    }
    public static void emailer(String recpt) {
        // TODO code application logic here
        System.out.println(recpt);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        //properties.put("mail.smtp.ssl.enable","true");
        //properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        final String sendr = "IIT2019176@iiita.ac.in";
        final String passwd= "Akash@437";//"123qwe,./";//"Akash@437";
        Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {  
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {  
            return new PasswordAuthentication(sendr,passwd);  
        }  
    });  
        Message message = null;
        try {
            message = prepareMessage(session,sendr,recpt);
        } catch (AddressException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Transport.send(message);
            //System.out.println("yup");
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Message prepareMessage(Session session, String sendr,String recpt) throws AddressException {
        try{
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(sendr));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recpt));
            message.setSubject("Power Drop occurred");
            message.setText("Power drop occured in CC3 elevator.\nElevator reached safely to the nearest floor.\nElevator will resume services once electricity problem is solved.");
            //System.out.println("success");
            return message;
        }catch(MessagingException e){
            System.err.println(e);
        }
        return null;
    }
}
