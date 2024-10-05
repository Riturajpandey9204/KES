package in.jt.response.binding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class PlanInfo {

	private String name;
	private Long ssn;
	private String email;
	private String planName;
	private String planStatus;
	private String startDate;
	private String endDate;
	private Double benifitAmount;
	private String denialReason;
}
