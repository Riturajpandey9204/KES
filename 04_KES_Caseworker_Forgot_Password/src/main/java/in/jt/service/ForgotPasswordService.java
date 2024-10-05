package in.jt.service;

import javax.persistence.DiscriminatorColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.constants.AppConstants;
import in.jt.entity.CaseworkerEntity;
import in.jt.properties.AppProperties;
import in.jt.repository.CaseworkerEntityRepository;
import in.jt.response.binding.LoginRequest;

@Service
public class ForgotPasswordService {

	@Autowired
	private CaseworkerEntityRepository repo;
	
	@Autowired
	private AppProperties appProperties;
	
	public String findPassword(String email) {
		CaseworkerEntity caseworkerEntity = repo.findByCwEmailId(email);
		if(caseworkerEntity == null) {
			return appProperties.getMessages().get(AppConstants.FAIL);
		}
		else {
			return appProperties.getMessages().get(AppConstants.SUCCESS) +"   >>>>    " + caseworkerEntity.getCwPassword();
		}
	}
}
