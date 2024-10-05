package in.jt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import in.jt.app.constants.AppConstants;
import in.jt.app.properties.AppProperties;
import in.jt.entity.CitizenInfo;
import in.jt.repository.CitizenInfoRepository;
import in.jt.request.binding.CitizenData;
@Service
public class CitizenInfoService {

	@Autowired
	private CitizenInfoRepository repo;

	@Autowired
	private AppProperties appProperties;

	public String checkCitizenEligibility(CitizenData cdata) {
		String endpoint = "http://localhost:8095/getstate/" + cdata.getCitizenSsn();
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(endpoint, String.class);

		String stateName = responseEntity.getBody();
		if ("kentucky".equalsIgnoreCase(stateName)) {
			CitizenInfo entity = new CitizenInfo();
			BeanUtils.copyProperties(cdata,entity);
			repo.save(entity);
			return appProperties.getMessages().get(AppConstants.ELIGIBLE);
		} else {
			return appProperties.getMessages().get(AppConstants.ELIGIBLE);
		}
	}
}
