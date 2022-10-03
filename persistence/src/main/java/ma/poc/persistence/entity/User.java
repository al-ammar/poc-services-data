package ma.poc.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UTILISATEUR")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "THE_PASSWORD")
	private String thePassword;

	@Column(name= "UPDATE_DATE")
	private LocalDateTime updateDate;
	
	@Lob
	@Column(name= "CONTENT")
    private byte[] content;

	
}
