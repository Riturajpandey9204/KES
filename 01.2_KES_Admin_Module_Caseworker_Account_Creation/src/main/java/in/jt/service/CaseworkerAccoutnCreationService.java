package in.jt.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.entity.CaseworkerEntity;
import in.jt.properties.AppProperties;
import in.jt.repository.CaseworkerEntityRepository;
import in.jt.request.binding.Caseworker;

@Service
public class CaseworkerAccoutnCreationService {

	@Autowired
	private CaseworkerEntityRepository repository;

	@Autowired
	private AppProperties appProperties;

	public String createCaseworkerAccountCreation(Caseworker caseworker) {

		// creating object for entity class
		CaseworkerEntity entity = new CaseworkerEntity();

		// copying data from binding class to entity class
		BeanUtils.copyProperties(caseworker, entity);

		// saving caseworker data into db by using entity class
		CaseworkerEntity caseworkerEntity = repository.save(entity);

		if(caseworkerEntity==null) {
			return appProperties.getMessages().get("FAIL");
		}
		else {
			return appProperties.getMessages().get("SUCCESS");
		}
		/*
		 * if (caseworkerEntity == null) { Map<String, String> messages =
		 * appProperties.getMessages(); String response = messages.get("FAIL"); return
		 * response; } else { Map<String, String> messages =
		 * appProperties.getMessages(); String response = messages.get("SUCCESS");
		 * return response; }
		 */
	}

}
