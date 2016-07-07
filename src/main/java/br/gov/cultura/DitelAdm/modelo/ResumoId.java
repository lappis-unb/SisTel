package br.gov.cultura.DitelAdm.modelo;
// Generated 05/07/2016 12:36:15 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ResumoId generated by hbm2java
 */
@Embeddable
public class ResumoId implements java.io.Serializable {

	private int id;
	private String numRecurso;
	private int faturaNumFatura;
	private String faturaClienteCodCliente;
	private int faturaClienteOperadoraCodOperadora;
	private Date faturaDataEmissao;

	public ResumoId() {
	}

	public ResumoId(int id, String numRecurso, int faturaNumFatura, String faturaClienteCodCliente,
			int faturaClienteOperadoraCodOperadora, Date faturaDataEmissao) {
		this.id = id;
		this.numRecurso = numRecurso;
		this.faturaNumFatura = faturaNumFatura;
		this.faturaClienteCodCliente = faturaClienteCodCliente;
		this.faturaClienteOperadoraCodOperadora = faturaClienteOperadoraCodOperadora;
		this.faturaDataEmissao = faturaDataEmissao;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "numRecurso", nullable = false, length = 20)
	public String getNumRecurso() {
		return this.numRecurso;
	}

	public void setNumRecurso(String numRecurso) {
		this.numRecurso = numRecurso;
	}

	@Column(name = "fatura_numFatura", nullable = false)
	public int getFaturaNumFatura() {
		return this.faturaNumFatura;
	}

	public void setFaturaNumFatura(int faturaNumFatura) {
		this.faturaNumFatura = faturaNumFatura;
	}

	@Column(name = "fatura_cliente_codCliente", nullable = false, length = 15)
	public String getFaturaClienteCodCliente() {
		return this.faturaClienteCodCliente;
	}

	public void setFaturaClienteCodCliente(String faturaClienteCodCliente) {
		this.faturaClienteCodCliente = faturaClienteCodCliente;
	}

	@Column(name = "fatura_cliente_operadora_codOperadora", nullable = false)
	public int getFaturaClienteOperadoraCodOperadora() {
		return this.faturaClienteOperadoraCodOperadora;
	}

	public void setFaturaClienteOperadoraCodOperadora(int faturaClienteOperadoraCodOperadora) {
		this.faturaClienteOperadoraCodOperadora = faturaClienteOperadoraCodOperadora;
	}

	@Column(name = "fatura_dataEmissao", nullable = false, length = 10)
	public Date getFaturaDataEmissao() {
		return this.faturaDataEmissao;
	}

	public void setFaturaDataEmissao(Date faturaDataEmissao) {
		this.faturaDataEmissao = faturaDataEmissao;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResumoId))
			return false;
		ResumoId castOther = (ResumoId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getNumRecurso() == castOther.getNumRecurso()) || (this.getNumRecurso() != null
						&& castOther.getNumRecurso() != null && this.getNumRecurso().equals(castOther.getNumRecurso())))
				&& (this.getFaturaNumFatura() == castOther.getFaturaNumFatura())
				&& ((this.getFaturaClienteCodCliente() == castOther.getFaturaClienteCodCliente())
						|| (this.getFaturaClienteCodCliente() != null && castOther.getFaturaClienteCodCliente() != null
								&& this.getFaturaClienteCodCliente().equals(castOther.getFaturaClienteCodCliente())))
				&& (this.getFaturaClienteOperadoraCodOperadora() == castOther.getFaturaClienteOperadoraCodOperadora())
				&& ((this.getFaturaDataEmissao() == castOther.getFaturaDataEmissao())
						|| (this.getFaturaDataEmissao() != null && castOther.getFaturaDataEmissao() != null
								&& this.getFaturaDataEmissao().equals(castOther.getFaturaDataEmissao())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + (getNumRecurso() == null ? 0 : this.getNumRecurso().hashCode());
		result = 37 * result + this.getFaturaNumFatura();
		result = 37 * result
				+ (getFaturaClienteCodCliente() == null ? 0 : this.getFaturaClienteCodCliente().hashCode());
		result = 37 * result + this.getFaturaClienteOperadoraCodOperadora();
		result = 37 * result + (getFaturaDataEmissao() == null ? 0 : this.getFaturaDataEmissao().hashCode());
		return result;
	}

}