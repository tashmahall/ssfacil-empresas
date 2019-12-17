package br.gov.ans.ssfacilempresas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "HEALTH_OPERATORS_SHORT")
@Entity
@Data
public class HealthOperatorShort {
	@JsonIgnore
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String healthOperatorId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CLIENT_COMPANY_COD", referencedColumnName = "CLIENT_COMPANY_COD")
	private ClientCompany clientCompany;

}
