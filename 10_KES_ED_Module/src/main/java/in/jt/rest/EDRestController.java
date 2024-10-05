package in.jt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jt.request.binding.EDBind;
import in.jt.response.binding.PlanInfo;
import in.jt.service.EDService;

@RestController
public class EDRestController {

	@Autowired
	private EDService service;
	
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public PlanInfo getPlanInformation(@RequestBody EDBind bind) {
		return service.getPlanDetails(bind);
	}
}
