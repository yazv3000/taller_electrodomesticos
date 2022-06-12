package utp.taller.controller.email;

import java.io.File;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import utp.taller.entidades.Electrodomestico;

public class EnvioCorreo {
	public void enviarCorreo() {


		String remitente = "tallerutp.oficial@gmail.com";
		String clave = "tbwushvhyjherman"; //chochee
		String destino = "tochoherencia@gmail.com";

		System.out.println("Se eviará correo a: " + destino);

		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.host", "smtp.gmail.com"); // gmail stmp server
		propiedades.put("mail.smtp.port", 587);
		propiedades.put("mail.smtp.auth", true);
		propiedades.put("mail.smtp.starttls.enable", true);
		propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
		propiedades.put("mail.imap.ssl.enable", "true"); // required for Gmail
		propiedades.put("mail.imap.auth.mechanisms", "XOAUTH2");

		propiedades.put("mail.transport.protocol", "smtp");
		propiedades.put("mail.smtp.user", remitente);
		propiedades.put("mail.smtp.clave", clave);

		Session session = Session.getDefaultInstance(propiedades);
		
		MimeMessage mensaje = new MimeMessage(session);

		try {

			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			// mensaje.addRecipient(Message.RecipientType.CC, new
			// InternetAddress(AppAutocine.usuario.getEmail()));
			mensaje.setSubject("Envio boleta Autocine - UTP");

			BodyPart parteTexto = new MimeBodyPart();
			parteTexto.setContent("Envío de <b>boleta</b>", "text/html");

			BodyPart parteArchivo = new MimeBodyPart();

			parteArchivo.setDataHandler(new DataHandler(new FileDataSource("ReporteTecnico.pdf")));
			parteArchivo.setFileName("ReporteTecnico.pdf");

			MimeMultipart todasLasPartes = new MimeMultipart();
			todasLasPartes.addBodyPart(parteTexto);
			todasLasPartes.addBodyPart(parteArchivo);

			mensaje.setContent(todasLasPartes);

			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(mensaje, mensaje.getAllRecipients());
			transport.close();

			System.out.println("Correo Enviado con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}

//		// Borrando el pdf temporal de la boleta
//		String RUTA = "ReporteTecnico.pdf";
//
//		try {
//			File archivo = new File(RUTA);
//
//			if (archivo.delete()) {
//				System.out.println("El archivo fue eliminado satisfactoriamente.");
//			} else {
//				System.out.println("No se ha podido borrar el archivo.");
//			}
//
//		} catch (Exception e) {
//			System.err.println("Error -> " + e.getMessage());
//		}
	}
	public void verRuta() {
		File f = new File("program.txt");
		  
        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();

        // Display the file path of the file object
        // and also the file path of absolute file
        System.out.println("Original  path: "
                           + f.getPath());
        System.out.println("Absolute  path: "
                           + absolute);

	}
}
