package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jt.service.ForgotPasswordService;

@RestController
public class ForgotPasswordRestController {

	@Autowired
	private ForgotPasswordService service;
	
	@PostMapping(value = "/login/{email}")
	public String getPassword(@PathVariable String email) {
		return service.findPassword(email);
	}
}
