package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.response.binding.UpdatedPassword;
import in.jt.service.UpdatedPasswordService;

@RestController
public class UpdatedPasswordRestController {

	@Autowired
	private UpdatedPasswordService service;
	
	@PostMapping(value = "/updatedpassword",consumes = "application/json")
	public String updatedPassword(@RequestBody UpdatedPassword updatedPassword) {
		return service.getUpdatedPassword(updatedPassword);
	}
}
