package in.jt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CO_TRIGGERS")
public class CoTriggerEntity {

	@Id
	@Column(name = "CD_ID")
	private Long cdId;
	
	@Column(name = "TRIGGER_STATUS")
	private String triggerStatus;
}
