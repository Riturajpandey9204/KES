package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.jt.service.StateVerificationService;

@RestController
public class StateVerificationRestController {

	@Autowired
	private StateVerificationService service;
	
	@GetMapping(value = "/getstate/{ssn}")
	public String getStateName(@PathVariable String ssn) {
		return service.fetchStateName(ssn);
	}
}
