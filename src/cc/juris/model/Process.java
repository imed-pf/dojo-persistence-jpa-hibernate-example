package cc.juris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity(name="processo")
@SequenceGenerator(name="processo_codigo", sequenceName="processo_codigo")
public class Process {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="processo_codigo")
	@Column(name="codigo", nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Customer customer;
	
	@Column(name="numeroprocesso")
	private	Long number;
	
	@Column(name = "ativo")
	@Type(type = "cc.juris.model.type.BooleanCharacterType")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}