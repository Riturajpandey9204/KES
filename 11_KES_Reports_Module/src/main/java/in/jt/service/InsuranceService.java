package in.jt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.jt.entity.EligibilityDeterminationEntity;
import in.jt.repository.EligibilityDeterminationEntityRepository;
import in.jt.response.binding.PlanInfo;

@Service
public class InsuranceService {
	@Autowired
	private EligibilityDeterminationEntityRepository edeRepo;

	public List<PlanInfo> searchPlans() {

		EligibilityDeterminationEntity entity = new EligibilityDeterminationEntity();

		Example<EligibilityDeterminationEntity> example = Example.of(entity);
		List<EligibilityDeterminationEntity> allEntities = edeRepo.findAll(example);
		List<PlanInfo> plans = new ArrayList<>();
		for (EligibilityDeterminationEntity entity1 : allEntities) {
			PlanInfo info = new PlanInfo();
			BeanUtils.copyProperties(entity1, info);
			plans.add(info);
		}
		return plans;

	}

}
