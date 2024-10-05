package in.jt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.jt.entity.PlansInfoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.jt.repository.PlansInfoEntityRepository;
import in.jt.response.binding.Plans;

@Service
public class PlansInfoService {

	@Autowired
	private PlansInfoEntityRepository repo;
	
	public List<Plans> getAllPlansInfo(){
		List<PlansInfoEntity> entityList = repo.findAll();
		ArrayList<Plans> bindingList = new ArrayList<Plans>();
		entityList.forEach((PlansInfoEntity entity)->{
			Plans plan = new Plans();
			BeanUtils.copyProperties(entity, plan);
			bindingList.add(plan);
		});
		return bindingList;
	}
	
	public Plans getPlanInfo(Integer pid) {
		Optional<PlansInfoEntity> optional = repo.findById(pid);
		if(optional.isPresent()) {
			PlansInfoEntity entity = optional.get();
			Plans plan = new Plans();
			BeanUtils.copyProperties(entity, plan);
			return plan;
		}
		else {
			return null;
		}
	}
}
