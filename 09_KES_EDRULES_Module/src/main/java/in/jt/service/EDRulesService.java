package in.jt.service;

import org.springframework.stereotype.Service;

import in.jt.request.binding.CitizenData;
import in.jt.response.binding.PlanInfo;
@Service
public class EDRulesService {

	public PlanInfo checkEligibility(CitizenData cdata) {

		PlanInfo planInfo = new PlanInfo();
		planInfo.setName(cdata.getName());
		planInfo.setPlanName(cdata.getPlanName());
		planInfo.setSsn(cdata.getSsn());
		planInfo.setEmail(cdata.getEmail());
		
		Double income = cdata.getIncome();
		String planName = cdata.getPlanName();
		if("SNAP".equalsIgnoreCase(planName)) {
			System.err.println("SNAP-SNAP-SNAP");
			if(income <= 200) {
				planInfo.setPlanStatus("APPROVED");
				planInfo.setBenifitAmount(3500.00);
				planInfo.setStartDate("06-07-2024");
				planInfo.setEndDate("05-06-2025");
			}
			else {
				planInfo.setPlanName("DENIED");
				planInfo.setDenialReason("SRY..!! YOUR INCOME IS VERY HIGH");
			}
		}
		else if("CCAP".equalsIgnoreCase(planName)) {
			Integer kidsAge = cdata.getKidsAge();
			if(income <= 200 && (kidsAge > 0 && kidsAge < 16)) {
				planInfo.setPlanStatus("APPROVED");
				planInfo.setBenifitAmount(4500.00);
				planInfo.setStartDate("07-07-2024");
				planInfo.setEndDate("06-06-2025");
			}
			else {
				planInfo.setPlanName("DENIED");
				planInfo.setDenialReason("SRY..!! YOUR INCOME IS VERY HIGH and KIDS ARE NOT KIDS ANYMORE :D");
			}
		}
		else if("MEDICAID".equalsIgnoreCase(planName)) {
			if(income <= 300) {
				planInfo.setPlanStatus("APPROVED");
				planInfo.setBenifitAmount(2500.00);
				planInfo.setStartDate("08-07-2024");
				planInfo.setEndDate("07-06-2025");
			}
			else {
				planInfo.setPlanName("DENIED");
				planInfo.setDenialReason("SRY..!! YOU HAVE HIGH INCOME AND RESOURCES..!!");
			}
		}
		else if("MEDICARE".equalsIgnoreCase(planName)) {
			Integer age = cdata.getAge();
			if(age >= 65) {
				planInfo.setPlanStatus("APPROVED");
				planInfo.setBenifitAmount(4500.00);
				planInfo.setStartDate("09-07-2024");
				planInfo.setEndDate("08-06-2025");
			}
			else {
				planInfo.setPlanName("DENIED");
				planInfo.setDenialReason("SRY..!! YOU can't APPLY FOR MEDICARE..!!");
			}
		}
		else if("KW".equalsIgnoreCase(planName)) {
			String employmentStatus = cdata.getEmploymentStatus();
			if("UNEMPLOYED".equalsIgnoreCase(employmentStatus)) {
				planInfo.setPlanStatus("APPROVED");
				planInfo.setBenifitAmount(1800.00);
				planInfo.setStartDate("10-07-2024");
				planInfo.setEndDate("11-06-2025");
			}
			else {
				planInfo.setPlanName("DENIED");
				planInfo.setDenialReason("SRY..!! YOU ARE NOT ELIGIBLE FOR KW PLAN..!!");
			}
		}else if("QHP".equalsIgnoreCase(planName)) {
			
				planInfo.setPlanStatus("APPROVED");
				planInfo.setStartDate("10-07-2024");
				planInfo.setEndDate("11-06-2025");
			
		}
		return planInfo;
	}

}
