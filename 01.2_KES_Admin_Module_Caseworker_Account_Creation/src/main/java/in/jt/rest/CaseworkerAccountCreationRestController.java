package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.request.binding.Caseworker;
import in.jt.service.CaseworkerAccoutnCreationService;

@RestController
public class CaseworkerAccountCreationRestController {

	@Autowired
	private CaseworkerAccoutnCreationService service;
	
	@PostMapping(value="/account", consumes="application/json")
	public String saveCaseworkerInfo(@RequestBody Caseworker caseworker) {
		return service.createCaseworkerAccountCreation(caseworker);
	}
	
}
