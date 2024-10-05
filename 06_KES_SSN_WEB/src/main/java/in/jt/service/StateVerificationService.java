package in.jt.service;

import org.springframework.stereotype.Service;

import in.jt.constants.StateEnums;

@Service
public class StateVerificationService {

	public String fetchStateName(String ssn) {
		if (ssn != null) {
			if (ssn.startsWith("6") && ssn.length() == StateEnums.LENGTH) {
				return StateEnums.S3;
			} else if (ssn.startsWith("5") && ssn.length() == StateEnums.LENGTH) {
				return StateEnums.S2;
			} else if (ssn.startsWith("7") && ssn.length() == StateEnums.LENGTH) {
				return StateEnums.S1;
			} else if (ssn.startsWith("4") && ssn.length() == StateEnums.LENGTH) {
				return StateEnums.S4;
			} else {
				return StateEnums.INVALID;
			}
		} else
			return StateEnums.INVALID;
	}

}
