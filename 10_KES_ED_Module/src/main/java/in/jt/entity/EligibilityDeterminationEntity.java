package in.jt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELIGIBILITY_DTLS")
public class EligibilityDeterminationEntity {

	@Id
	@Column(name = "CD_ID")
	private Long cdId;
	
	@Column(name = "CITIZEN_NAME")
	private String name;
	
	@Column(name = "CITIZEN_SSN")
	private Long ssn;
	
	@Column(name = "CITIZEN_EMAIL")
	private String email;
	
	@Column(name = "CITIZEN_PLAN_NAME")
	private String planName;
	
	@Column(name = "CITIZEN_PLAN_STATUS")
	private String planStatus;
	
	@Column(name = "PLAN_START_DATE")
	private String startDate;
	
	@Column(name = "PLAN_END_DATE")
	private String endDate;
	
	@Column(name = "BENIFIT_AMOUNT")
	private Double benifitAmount;
	
	@Column(name = "DENIAL_REASON")
	private String denialReason;
}
