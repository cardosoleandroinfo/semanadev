package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepositorio;

	public void sendSms(Long id) {

		Sale sale = saleRepositorio.findById(id).get();
		String mensagem;
		
		mensagem="Vendedor " + sale.getSellerName();
		mensagem="Olá dudows";
		
		//Twilio.init(twilioSid, twilioKey);
		Twilio.init("AC6bb6f9ce1489e96cea695a83fa04b7af", "f348d5dc60f185120979a56af9b4d1c2");

		PhoneNumber to = new PhoneNumber("+14014257906");
		PhoneNumber from = new PhoneNumber("+55062982048319");
		
		Message message = Message.creator(to, from, mensagem).create();
		//Message message = Message.creator("+14014257906", "+5562982048319", mensagem).create();

		System.out.println(message.getSid());
	}
}

