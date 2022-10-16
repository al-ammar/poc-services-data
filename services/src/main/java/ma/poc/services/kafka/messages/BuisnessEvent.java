package ma.poc.services.kafka.messages;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuisnessEvent {

	private String name;
	private String acion;
	private Date date;
	
	
	
}
