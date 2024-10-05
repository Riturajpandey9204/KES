package in.jt.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "reg-app")
public class AppProperties {

	private Map<String,String> messages = new HashMap<String,String>();

	public Map<String, String> getMessages() {
		//System.out.println("111111111111");
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		//System.out.println("222222222222222");
		this.messages = messages;
	}
	
}
