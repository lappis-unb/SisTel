package br.gov.cultura.DitelAdm.model;
// Generated 24/08/2016 15:08:19 by Hibernate Tools 4.3.4.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LimiteAtesto generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "limite_atesto", catalog = "diteladmdev")
public class LimiteAtesto implements java.io.Serializable {

	private Integer idLimiteAtesto;
	private String dasAtesto;
	private String valorLimite;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<Usuario> usuarios = new HashSet(0);
	public LimiteAtesto() {
	}

	public LimiteAtesto(Integer idLimiteAtesto, String dasAtesto, String valorLimite) {
		this.idLimiteAtesto = idLimiteAtesto;
		this.dasAtesto = dasAtesto;
		this.valorLimite = valorLimite;
	}

	public LimiteAtesto(Integer idLimiteAtesto, String dasAtesto, String valorLimite, Set<Usuario> usuarios) {
		this.idLimiteAtesto = idLimiteAtesto;
		this.dasAtesto = dasAtesto;
		this.valorLimite = valorLimite;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_limite_atesto", unique = true, nullable = false)
	public Integer getIdLimiteAtesto() {
		return this.idLimiteAtesto;
	}

	public void setIdLimiteAtesto(Integer idLimiteAtesto) {
		this.idLimiteAtesto = idLimiteAtesto;
	}

	@Column(name = "das_atesto", nullable = false)
	public String getDasAtesto() {
		return this.dasAtesto;
	}

	public void setDasAtesto(String dasAtesto) {
		this.dasAtesto = dasAtesto;
	}

	@Column(name = "valor_limite", nullable = false)
	public String getValorLimite() {
		return this.valorLimite;
	}

	public void setValorLimite(String valorLimite) {
		this.valorLimite = valorLimite;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "limiteAtesto")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
