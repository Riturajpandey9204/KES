package in.jt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import in.jt.response.binding.Plans;
import in.jt.service.PlansInfoService;

@RestController
public class PlansInfoRestController {

	@Autowired
	private PlansInfoService service;
	
	@GetMapping(value = "/allPlansInfo", produces = "application/json")
	public List<Plans> getAllPlansDetails(){
		return service.getAllPlansInfo();
	}
	
	@GetMapping(value = "/planInfo/{pid}", produces = "application/json")
	public Plans getPlanDetails(@PathVariable Integer pid){
		return service.getPlanInfo(pid);
	}
}
