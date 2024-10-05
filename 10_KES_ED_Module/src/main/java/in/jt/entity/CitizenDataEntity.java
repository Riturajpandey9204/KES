package in.jt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CITIZEN_DATA")
public class CitizenDataEntity {

	@Id
	@Column(name = "CD_ID")
	private Long cdId;
	
	@Column(name = "AR_NUMBER")
	private String arNumber;
	
	@Column(name = "CITIZEN_NAME")
	private String citizenName;
	
	@Column(name = "CITIZEN_MOBILE_NUMBER")
	private Long citizenMobileNo;
	
	@Column(name = "CITIZEN_SSN")
	private Long citizenSsn;
	
	@Column(name = "CITIZEN_DOB")
	private String citizenDob;
	
	@Column(name = "CITIZEN_GENDER")
	private String citizenGender;
	
	@Column(name = "CITIZEN_EMAIL_ID")
	private String citizenMailId;
	
	@Column(name = "CITIZEN_AGE")
	private Integer age;
	
	@Column(name = "CITIZEN_INCOME")
	private Double Income;
	
	@Column(name = "CITIZEN_MARITALSTATUS")
	private String maritalStatus;
	
	@Column(name = "CITIZEN_KIDS")
	private String kids;
	
	@Column(name = "CITIZEN_KIDS_AGE")
	private Integer kidsAge;
	
	@Column(name = "CITIZEN_QUALIFICATION")
	private String qualification;
	
	@Column(name = "CITIZEN_EMPLOYMENT_STATUS")
	private String employmentStatus;

}
