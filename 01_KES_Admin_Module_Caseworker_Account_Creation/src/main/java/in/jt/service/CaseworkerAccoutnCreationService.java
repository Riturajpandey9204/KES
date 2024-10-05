package in.jt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.constant.AppConstants;
import in.jt.entity.CaseworkerEntity;
import in.jt.repository.CaseworkerEntityRepository;
import in.jt.request.binding.Caseworker;

@Service
public class CaseworkerAccoutnCreationService {

	@Autowired
	private CaseworkerEntityRepository repository;
	
	public String createCaseworkerAccountCreation(Caseworker caseworker) {
		
		
		//creating object for entity class
		CaseworkerEntity entity = new CaseworkerEntity();
		
		//copying data from binding class to entity class
		BeanUtils.copyProperties(caseworker, entity);
		
		//saving caseworker data into db by using entity class
		CaseworkerEntity caseworkerEntity = repository.save(entity);

		if(caseworkerEntity == null) {
			return AppConstants.FAIL;
		}
		else {
			return AppConstants.SUCCESS;
		}
	}

}
