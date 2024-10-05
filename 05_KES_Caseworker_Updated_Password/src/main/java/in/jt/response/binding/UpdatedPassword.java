package in.jt.response.binding;

import lombok.Data;

@Data
public class UpdatedPassword {

	private String cwEmailId;
	private String cwOldPassword;
	private String cwNewPassword;
	private String cwConfirmPassword;
}
