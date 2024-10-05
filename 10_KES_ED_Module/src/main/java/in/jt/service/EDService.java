package in.jt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.jt.entity.CitizenDataEntity;
import in.jt.entity.CoTriggerEntity;
import in.jt.entity.EligibilityDeterminationEntity;
import in.jt.repository.CitizenDataEntityRepository;
import in.jt.repository.CoTriggerEntityRepository;
import in.jt.repository.EligibilityDeterminationEntityRepository;
import in.jt.request.binding.CitizenData;
import in.jt.request.binding.EDBind;
import in.jt.response.binding.PlanInfo;

@Service
public class EDService {

	@Autowired
	private CitizenDataEntityRepository cdrepo;
	
	@Autowired
	private EligibilityDeterminationEntityRepository edrepo;
	
	@Autowired
	private CoTriggerEntityRepository corepo;
	
	public PlanInfo getPlanDetails(EDBind bind) {
		Optional<CitizenDataEntity> optional = cdrepo.findById(bind.getCdId());
		if(optional.isPresent()) {
			CitizenDataEntity citizenDataEntity = optional.get();
			CitizenData cd = new CitizenData();
			cd.setPlanName(citizenDataEntity.getCitizenName());
			cd.setAge(citizenDataEntity.getAge());
			cd.setEmail(citizenDataEntity.getCitizenMailId());
			cd.setSsn(citizenDataEntity.getCitizenSsn());
			cd.setPlanName(bind.getPlanName());
			cd.setIncome(citizenDataEntity.getIncome());
			cd.setKidsAge(citizenDataEntity.getKidsAge());
			cd.setEmploymentStatus(citizenDataEntity.getEmploymentStatus());
			
			String endpointurl = "http://localhost:8098/rules";
			RestTemplate rt = new RestTemplate();
			ResponseEntity<PlanInfo> responseEntity = rt.postForEntity(endpointurl, cd,PlanInfo.class);
			
			PlanInfo planInfo = responseEntity.getBody();
			if("APPROVED".equalsIgnoreCase(planInfo.getPlanStatus())) {
				EligibilityDeterminationEntity ede = new EligibilityDeterminationEntity();
				BeanUtils.copyProperties(planInfo, ede);
				ede.setCdId(bind.getCdId());
				edrepo.save(ede);
				
				CoTriggerEntity ct = new CoTriggerEntity();
				ct.setCdId(bind.getCdId());
				ct.setTriggerStatus("P");
				corepo.save(ct);
			}
			return planInfo;
		}
		else {
			return null;
		}
	}
}
