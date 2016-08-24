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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "diteladmdev")
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private LimiteAtesto limiteAtesto;
	private String cargoUsuario;
	private String cpfUsuario;
	private String lotacaoUsuario;
	private String nomeUsuario;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<AlocacaoUsuarioLinha> alocacaoUsuarioLinhas = new HashSet(0);

	public Usuario() {
	}

	public Usuario(LimiteAtesto limiteAtesto, String cargoUsuario, String cpfUsuario, String lotacaoUsuario,
			String nomeUsuario) {
		this.limiteAtesto = limiteAtesto;
		this.cargoUsuario = cargoUsuario;
		this.cpfUsuario = cpfUsuario;
		this.lotacaoUsuario = lotacaoUsuario;
		this.nomeUsuario = nomeUsuario;
	}

	public Usuario(LimiteAtesto limiteAtesto, String cargoUsuario, String cpfUsuario, String lotacaoUsuario,
			String nomeUsuario, Set<AlocacaoUsuarioLinha> alocacaoUsuarioLinhas) {
		this.limiteAtesto = limiteAtesto;
		this.cargoUsuario = cargoUsuario;
		this.cpfUsuario = cpfUsuario;
		this.lotacaoUsuario = lotacaoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.alocacaoUsuarioLinhas = alocacaoUsuarioLinhas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_usuario", unique = true, nullable = false)
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "limite_atesto_id_limite_atesto", nullable = false)
	public LimiteAtesto getLimiteAtesto() {
		return this.limiteAtesto;
	}

	public void setLimiteAtesto(LimiteAtesto limiteAtesto) {
		this.limiteAtesto = limiteAtesto;
	}

	@Column(name = "cargo_usuario", nullable = false)
	@NotEmpty(message="Cargo e obrigat�rio!")
	@Size(max = 100, message = "Maximo de 100 caracteres para cargo!")
	public String getCargoUsuario() {
		return this.cargoUsuario;
	}

	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}

	@Column(name = "cpf_usuario", nullable = false, length = 11)
	@CPF
	@NotNull(message="CPF e obrigat�rio!")
	public String getCpfUsuario() {
		return this.cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	@Column(name = "lotacao_usuario", nullable = false)
	@NotNull(message = "Campo lota��o e obrigat�rio!")
	public String getLotacaoUsuario() {
		return this.lotacaoUsuario;
	}

	public void setLotacaoUsuario(String lotacaoUsuario) {
		this.lotacaoUsuario = lotacaoUsuario;
	}

	@Column(name = "nome_usuario", nullable = false, length = 255)
	@NotEmpty(message="Nome e obrigat�rio!")
	@Size(max = 100, message = "Maximo de 100 caracteres para nome!")
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<AlocacaoUsuarioLinha> getAlocacaoUsuarioLinhas() {
		return this.alocacaoUsuarioLinhas;
	}

	public void setAlocacaoUsuarioLinhas(Set<AlocacaoUsuarioLinha> alocacaoUsuarioLinhas) {
		this.alocacaoUsuarioLinhas = alocacaoUsuarioLinhas;
	}

}
