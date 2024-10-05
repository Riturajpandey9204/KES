package in.jt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PLANS_INFO")
public class PlansInfoEntity {

	@Id
	@Column(name="PLAN_ID")
	private Integer pid;
	
	@Column(name="PLAN_NAME")
	private String pname;
	
	@Column(name="PLAN_DURATION")
	private Byte pduration;
	
	@Column(name="PLAN_FUND")
	private Double pfund;
}
