package com.dromedicas.test;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.dromedicas.mailservices.BuilderMessage;
import com.dromedicas.mailservices.JavaMailService;

public class Test {

	public static void main(String[] args) {
		//enviarEmail();
		leerMensajes();
		
	}
		
	public static void enviarEmail(){
		//Objeto de servicio Email
		JavaMailService  service = new JavaMailService();
		//Clase generica para componeer email
		BuilderMessage message;
		
		try {
			//Html personalizado para el mensaje
			File inputHtml = new File(
					"C:/FarmapuntosEmail/basic.html");
			Document doc = Jsoup.parse(inputHtml, "UTF-8");
			
			//Parametros del mensaje
			message = new BuilderMessage(service.createUserMailSession());
			message.setFrom("pruebassistemas@dromedicas.com.co");
			message.setText(doc.html());
			message.setRecipient("cualquiercosa@gmail.es");
			message.setSubject("Mensaje Farmapuntos");						
			//envio del mensajse			
			service.sendEmail(message.buildText("HTML"));			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static void leerMensajes(){
		try {
			//Clase de servico para operaciones con el correo
			JavaMailService  service = new JavaMailService();
			
			List<Message> inboxM = service.getNewMessages();//Mensajes recibidos			
			ArrayList<Message> archivo = new ArrayList<Message>();//coleccion de mensajes errados
			System.out.println("tamanio:" + inboxM.size());
			
			for(Message m: inboxM){
				String address = service.readNewEmail(m);
				if( address != null ){
					//cuando un mensaje es fallido se debe anadir este mensaje a una nueva coleccion
					//para luego ser copiado en una carpeta de leidos y se debe eliminar
					archivo.add(m);
					service.copiarMensajes(service.getMailInbox(), service.getAchivedFolder(), 
											archivo.toArray(new Message[0]) );
					service.deleteMessage(m);
					System.out.println("Email Fallido>>>\t"+address);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
