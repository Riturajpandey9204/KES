package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.request.binding.CitizenData;
import in.jt.service.CitizenInfoService;

@RestController
public class CitizenInfoRestController {

	@Autowired
	private CitizenInfoService service;
	
	@PostMapping(value = "/eligible", consumes = "application/json")
	public String isEligible(@RequestBody CitizenData cdata) {
		return service.checkCitizenEligibility(cdata);
	}
}
