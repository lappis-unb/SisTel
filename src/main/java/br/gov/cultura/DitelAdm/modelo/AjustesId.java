package br.gov.cultura.DitelAdm.modelo;
// Generated 05/07/2016 12:36:15 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AjustesId generated by hbm2java
 */
@Embeddable
public class AjustesId implements java.io.Serializable {

	private String idAjustes;
	private int categoriaAjusteCodCatAjuste;
	private Date dataInicio;
	private Date horaInicio;

	public AjustesId() {
	}

	public AjustesId(String idAjustes, int categoriaAjusteCodCatAjuste, Date dataInicio, Date horaInicio) {
		this.idAjustes = idAjustes;
		this.categoriaAjusteCodCatAjuste = categoriaAjusteCodCatAjuste;
		this.dataInicio = dataInicio;
		this.horaInicio = horaInicio;
	}

	@Column(name = "idAjustes", nullable = false)
	public String getIdAjustes() {
		return this.idAjustes;
	}

	public void setIdAjustes(String idAjustes) {
		this.idAjustes = idAjustes;
	}

	@Column(name = "categoriaAjuste_codCatAjuste", nullable = false)
	public int getCategoriaAjusteCodCatAjuste() {
		return this.categoriaAjusteCodCatAjuste;
	}

	public void setCategoriaAjusteCodCatAjuste(int categoriaAjusteCodCatAjuste) {
		this.categoriaAjusteCodCatAjuste = categoriaAjusteCodCatAjuste;
	}

	@Column(name = "dataInicio", nullable = false, length = 10)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "horaInicio", nullable = false, length = 19)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AjustesId))
			return false;
		AjustesId castOther = (AjustesId) other;

		return (this.getIdAjustes() == castOther.getIdAjustes())
				&& (this.getCategoriaAjusteCodCatAjuste() == castOther.getCategoriaAjusteCodCatAjuste())
				&& ((this.getDataInicio() == castOther.getDataInicio()) || (this.getDataInicio() != null
						&& castOther.getDataInicio() != null && this.getDataInicio().equals(castOther.getDataInicio())))
				&& ((this.getHoraInicio() == castOther.getHoraInicio())
						|| (this.getHoraInicio() != null && castOther.getHoraInicio() != null
								&& this.getHoraInicio().equals(castOther.getHoraInicio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdAjustes() == null ? 0 : this.getIdAjustes().hashCode());
		result = 37 * result + this.getCategoriaAjusteCodCatAjuste();
		result = 37 * result + (getDataInicio() == null ? 0 : this.getDataInicio().hashCode());
		result = 37 * result + (getHoraInicio() == null ? 0 : this.getHoraInicio().hashCode());
		return result;
	}

}
