package com.bluebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.bluebank.dto.UsuarioDto;

@RestController
public class AwsSnsController {

		@Autowired
		private AmazonSNSClient snsCliente;


		@Autowired
		private UsuarioController userController;

		private String TOPIC_ARN = "";

		@CrossOrigin(origins = "http://localhost:3006")
		@GetMapping("/addInscricao/{email}")
		public String addSubscription(@PathVariable String email) {

			SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
			snsCliente.subscribe(request);
			return "Seu cadastro está pedente. Para confirmar, verifique seu e-mail:" + email;
		}

		@CrossOrigin(origins = "http://localhost:3006")
		@GetMapping("/enviaNotificacao")
		public String publishMessageToTopic() throws Exception {
			PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(), "Notificatio: Network connectivity issue");
			snsCliente.publish(publishRequest);
			return "Notificação enviada com sucesso!";
		}


		private String buildEmailBody() throws Exception {
			return "Querido cliente,\n"+
					"\n"+
					"Seja bem vindo ao BlueBank! \n"+
					"\n"+
					"Agora você está apto a realizar as suas movimentações" +
					"\n" +
					"Seu número de conta é: " + userController.pegarIds();

		}

}
