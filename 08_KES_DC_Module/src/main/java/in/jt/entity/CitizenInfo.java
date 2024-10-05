package in.jt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "CITIZEN_INFO")
public class CitizenInfo {

	@Id
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
}
