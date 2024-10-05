package in.jt.service;

import javax.persistence.DiscriminatorColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.constants.AppConstants;
import in.jt.entity.CaseworkerEntity;
import in.jt.properties.AppProperties;
import in.jt.repository.CaseworkerEntityRepository;
import in.jt.response.binding.UpdatedPassword;

@Service
public class UpdatedPasswordService {

	@Autowired
	private CaseworkerEntityRepository repo;
	
	@Autowired
	private AppProperties appProperties;
	
	public String getUpdatedPassword(UpdatedPassword updatedPassword) {
		CaseworkerEntity caseworkerEntity = repo.findByCwEmailIdAndCwPassword(updatedPassword.getCwEmailId(), updatedPassword.getCwOldPassword() );
		if(caseworkerEntity == null) {
			return appProperties.getMessages().get(AppConstants.FAIL);
		}
		else {
			if(updatedPassword.getCwNewPassword().equals(updatedPassword.getCwConfirmPassword())) {
				caseworkerEntity.setCwPassword(updatedPassword.getCwNewPassword());
				repo.save(caseworkerEntity);
				return appProperties.getMessages().get(AppConstants.SUCCESS) + caseworkerEntity.getCwPassword();
			}
			else {
				return appProperties.getMessages().get(AppConstants.NOTMATCHED);

			}
		
		}
	}
}
