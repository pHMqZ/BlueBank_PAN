package com.bluebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.bluebank.dto.UsuarioDto;
import com.bluebank.model.DadoUsuario;
import com.bluebank.repository.DadoUsuarioRepository;

@RestController
public class AwsSnsController {
	
		@Autowired
		private AmazonSNSClient snsClient;
	
	
		private String TOPIC_ARN = "";
		
		@GetMapping("/addSubscription/{email}")
		public String addSubscription(@PathVariable String email) {
			SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
			snsClient.subscribe(request);
			return "Seu cadastro está pedente. Para confirmar, verifique seu e-mail:" + email;
		}
		
		@GetMapping("/sendNotification")
		public String publishMessageToTopic() {
			PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Notificatio: Network connectivity issue");
			snsClient.publish(publishRequest);
			return "Notificação enviada com sucesso!";
		}
		
		private String buildEmailBody() {
			return "Querido cliente,\n"+
					"\n"+
					"Seja bem vindo ao BlueBank! \n"+
					"\n"+
					"Agora você está apto a realizar as suas movimentações";
		}

}
