package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.response.binding.LoginRequest;
import in.jt.service.LoginVerificationService;

@RestController
public class LoginVerificationRestController {

	@Autowired
	private LoginVerificationService service;
	
	@PostMapping(value = "/login",consumes = "application/json")
	public String loginVerification(@RequestBody LoginRequest request) {
		return service.doLogin(request);
	}
}
