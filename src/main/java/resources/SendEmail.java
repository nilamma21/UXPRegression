package resources;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail extends base{

	public void sendEmailWithAttachment(){
		// Recipient's email ID needs to be mentioned.
		
		String to2 = prop.getProperty("emailreceiver1");
		String to3 = prop.getProperty("emailreceiver2");
		String cc = prop.getProperty("emailreceiver");

		// Sender's email ID needs to be mentioned
		String from = prop.getProperty("emailsender");

		final String username = prop.getProperty("emailusername");
		final String password = prop.getProperty("emailpassword");

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "172.27.172.202";

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.webmail.com");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", "25");

		// Get the Session object.
		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to2));
			/*message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to3));
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(cc));*/
			
			// Set Subject: header field
			message.setSubject("UXP Automation Test Results");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("UXP App- Smoke Test execution");

			// Create a multi-part message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "UXPTestResults.html";
			String filepath = System.getProperty("user.dir")+"/reports/";
			DataSource source = new FileDataSource(filepath+filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Email has been sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}