package cc.juris.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity(name = "cliente")
@SequenceGenerator(name = "cliente_codigo", sequenceName = "cliente_codigo")
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_codigo")
	@Column(name = "codigo", nullable=false)
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "ativo")
	@Type(type = "cc.juris.model.type.BooleanCharacterType")
	private Boolean active;
	
	@OneToMany(mappedBy="customer")
	private List<Process> processList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Process> getProcessList() {
		return processList;
	}
	
	public void setProcessList(List<Process> processList) {
		this.processList = processList;
	}
	
}

