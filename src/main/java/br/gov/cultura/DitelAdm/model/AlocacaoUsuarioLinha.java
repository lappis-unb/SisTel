package br.gov.cultura.DitelAdm.model;
// Generated 24/08/2016 14:33:52 by Hibernate Tools 4.3.4.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlocacaoUsuarioLinha generated by hbm2java
 */
@Entity
@Table(name = "alocacao_usuario_linha", catalog = "diteladmdev")
public class AlocacaoUsuarioLinha implements java.io.Serializable {

	private Integer idAlocacaoUsuarioLinha;
	private Linha linha;
	private Usuario usuario;
	private Date dtDevolucao;
	private Date dtRecebido;

	public AlocacaoUsuarioLinha() {
	}

	public AlocacaoUsuarioLinha(Linha linha, Usuario usuario, Date dtRecebido) {
		this.linha = linha;
		this.usuario = usuario;
		this.dtRecebido = dtRecebido;
	}

	public AlocacaoUsuarioLinha(Linha linha, Usuario usuario, Date dtDevolucao, Date dtRecebido) {
		this.linha = linha;
		this.usuario = usuario;
		this.dtDevolucao = dtDevolucao;
		this.dtRecebido = dtRecebido;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_alocacao_usuario_linha", unique = true, nullable = false)
	public Integer getIdAlocacaoUsuarioLinha() {
		return this.idAlocacaoUsuarioLinha;
	}

	public void setIdAlocacaoUsuarioLinha(Integer idAlocacaoUsuarioLinha) {
		this.idAlocacaoUsuarioLinha = idAlocacaoUsuarioLinha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_linha", nullable = false)
	public Linha getLinha() {
		return this.linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_devolucao", length = 19)
	public Date getDtDevolucao() {
		return this.dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_recebido", nullable = false, length = 19)
	public Date getDtRecebido() {
		return this.dtRecebido;
	}

	public void setDtRecebido(Date dtRecebido) {
		this.dtRecebido = dtRecebido;
	}

}
