package br.gov.ans.ssfacilempresas.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import br.gov.ans.ssfacilempresas.domain.ClientCompany;
import br.gov.ans.ssfacilempresas.domain.HealthOperatorShort;

@RestController
@RequestMapping(value="/", produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
public class ClientCompanyController {
	
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping
	public ResponseEntity<ArrayNode> getClientCompanys() {
		ArrayNode an = om.createArrayNode();
		
		ClientCompany ctemp = new ClientCompany();
		ctemp.setName("teste");
		ctemp.setClientCompanyCod("123456");
		Collection<HealthOperatorShort> ltemp = new ArrayList<HealthOperatorShort>();
		HealthOperatorShort hTemp = new HealthOperatorShort();
		hTemp.setClientCompany(ctemp);
		hTemp.setName("Name Operator");
		ltemp.add(hTemp);
		ctemp.setHealthOperatorList(ltemp);
		an.addPOJO(ctemp);
		return ResponseEntity.ok(an);
	}
	@PostMapping
	public ResponseEntity<ClientCompany> createClientCompany (ClientCompany clientCompany){
		return ResponseEntity.ok(clientCompany);
	}

}
