package br.gov.ans.ssfacilempresas.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "CLIENT_COMPANIES")
@Entity
@Data
public class ClientCompany {
	@JsonIgnore
	@Id
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name="CLIENT_COMPANY_COD", nullable = false, unique = true )
	private String clientCompanyCod;
	
	@JsonManagedReference()
	@OneToMany(mappedBy = "clientCompany")
	private Collection<HealthOperatorShort> healthOperatorList;
}
