package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.request.binding.CitizenData;
import in.jt.response.binding.PlanInfo;
import in.jt.service.EDRulesService;

@RestController
public class EDRulesRestController {

	@Autowired
	private EDRulesService service;
	
	@PostMapping(value = "/rules", consumes = "application/json",produces = "application/json")
	public PlanInfo checkCitizenEligibility(@RequestBody CitizenData cdata) {
		return service.checkEligibility(cdata);
	}
}
