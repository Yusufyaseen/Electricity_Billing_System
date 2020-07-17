
package classes;

/**
 *
 * @author Mohamed Saeed
 */

import DB.Connection1;
import java.sql.Connection;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Email {
    static Connection con;
    static Properties mailserverproperties;
    static Session mailsession;
    static MimeMessage generatemailmessage;
    
    String tomail = "";
    String subject = "";
    String emailbody = "";

    

    public Email(String tomail, String subject, String emailbody) {
        Connection1 conn = new Connection1();
        try{
            con = conn.connect();
            System.out.println("gooood");
        }
        catch(Exception e){
                System.out.println("not gooood");
        }
        this.tomail = tomail;
        this.subject = subject;
        this.emailbody = emailbody;
    }
    
    public void generateAndsendEmail() throws AddressException, MessagingException{
        
        mailserverproperties = System.getProperties();
        mailserverproperties.put("mail.smtp.port", "587");
        mailserverproperties.put("mail.smtp.auth", "true");
        mailserverproperties.put("mail.smtp.startls.enable", "true");
        System.out.println("suit nnn");
        mailsession = Session.getDefaultInstance(mailserverproperties, null);
        
        generatemailmessage = new MimeMessage(mailsession);
        generatemailmessage.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
        generatemailmessage.setSubject(subject);
        generatemailmessage.setContent(emailbody, "text/html");
        System.out.println("suit mmmm");
        
        try (Transport transport = mailsession.getTransport("smtp")) {
            transport.connect("smtp.gmail.com", "yaseenyoussef7@gmail.com", "you00ya11");
            transport.sendMessage(generatemailmessage, generatemailmessage.getAllRecipients());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "not sent");
        }
        
    }
    
    
}
