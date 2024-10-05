package in.jt.response.binding;

import lombok.Data;

@Data
public class LoginRequest {
	private String email;
	private String pwd;
}
