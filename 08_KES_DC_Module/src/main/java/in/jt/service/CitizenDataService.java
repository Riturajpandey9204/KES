package in.jt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.app.constants.AppConstants;
import in.jt.app.properties.AppProperties;
import in.jt.entity.CitizenDataEntity;
import in.jt.entity.CitizenInfo;
import in.jt.repository.CitizenDataInfoRepository;
import in.jt.repository.CitizenInfoRepository;
import in.jt.request.binding.CitizenData;
@Service
public class CitizenDataService {

	@Autowired
	private CitizenInfoRepository repo;
	
	@Autowired
	private CitizenDataInfoRepository repo1;
	
	@Autowired
	private AppProperties prop;
	
	public String confirmSaveInfo(CitizenData cd) {

		CitizenDataEntity entity = new CitizenDataEntity();
		System.err.println(entity);
		
		Optional<CitizenInfo> opt = repo.findById(cd.getArNumber());
		
		CitizenInfo info = null;
		if(opt.isPresent()) {
			info = opt.get();
			BeanUtils.copyProperties(info, entity);
			BeanUtils.copyProperties(cd, entity);
			
			CitizenDataEntity cde = repo1.findByCitizenSsn(entity.getCitizenSsn());
			if(cde==null) {
				repo1.save(entity);
				System.err.println(entity);
				return prop.getMessages().get(AppConstants.SUCCESS);
			}
			else {
				return prop.getMessages().get(AppConstants.EXISTS);
			}
		}
		return prop.getMessages().get(AppConstants.FAIL);
	}

	
}
