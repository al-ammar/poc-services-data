package ma.poc.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "THE_PASSWORD")
	private String thePassword;

	

	
}
