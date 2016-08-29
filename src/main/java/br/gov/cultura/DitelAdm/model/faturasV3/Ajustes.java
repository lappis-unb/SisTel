package br.gov.cultura.DitelAdm.model.faturasV3;
// Generated 29/08/2016 10:12:50 by Hibernate Tools 4.3.4.Final

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
 * Ajustes generated by hbm2java
 */
@Entity
@Table(name = "ajustes", catalog = "diteladmdev")	
public class Ajustes implements java.io.Serializable {

	private Integer idAjustes;
	private Categoriaajuste categoriaajuste;
	private Resumo resumo;
	private Date dataInicio;
	private Date horaInicio;
	private String tipo;
	private Float baseCalculo;
	private Float percentual;
	private String sinal;
	private float valor;
	private Date dataFim;
	private Date horaFim;
	private String campoLivreOp;
	private String numRecurso;

	public Ajustes() {
	}

	public Ajustes(Categoriaajuste categoriaajuste, Resumo resumo, String tipo, String sinal, float valor) {
		this.categoriaajuste = categoriaajuste;
		this.resumo = resumo;
		this.tipo = tipo;
		this.sinal = sinal;
		this.valor = valor;
	}

	public Ajustes(Categoriaajuste categoriaajuste, Resumo resumo, Date dataInicio, Date horaInicio, String tipo,
			Float baseCalculo, Float percentual, String sinal, float valor, Date dataFim, Date horaFim,
			String campoLivreOp, String numRecurso) {
		this.categoriaajuste = categoriaajuste;
		this.resumo = resumo;
		this.dataInicio = dataInicio;
		this.horaInicio = horaInicio;
		this.tipo = tipo;
		this.baseCalculo = baseCalculo;
		this.percentual = percentual;
		this.sinal = sinal;
		this.valor = valor;
		this.dataFim = dataFim;
		this.horaFim = horaFim;
		this.campoLivreOp = campoLivreOp;
		this.numRecurso = numRecurso;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ajustes", unique = true, nullable = false)
	public Integer getIdAjustes() {
		return this.idAjustes;
	}

	public void setIdAjustes(Integer idAjustes) {
		this.idAjustes = idAjustes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoriaAjuste_id_catAjuste", nullable = false)
	public Categoriaajuste getCategoriaajuste() {
		return this.categoriaajuste;
	}

	public void setCategoriaajuste(Categoriaajuste categoriaajuste) {
		this.categoriaajuste = categoriaajuste;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resumo_id_resumo")
	public Resumo getResumo() {
		return this.resumo;
	}

	public void setResumo(Resumo resumo) {
		this.resumo = resumo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataInicio", length = 10)
	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "horaInicio", length = 19)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Column(name = "tipo", nullable = false, length = 1)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "baseCalculo", precision = 12, scale = 0)
	public Float getBaseCalculo() {
		return this.baseCalculo;
	}

	public void setBaseCalculo(Float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	@Column(name = "percentual", precision = 12, scale = 0)
	public Float getPercentual() {
		return this.percentual;
	}

	public void setPercentual(Float percentual) {
		this.percentual = percentual;
	}

	@Column(name = "sinal", nullable = false, length = 1)
	public String getSinal() {
		return this.sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

	@Column(name = "valor", nullable = false, precision = 12, scale = 0)
	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataFim", length = 10)
	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "horaFim", length = 19)
	public Date getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	@Column(name = "campoLivreOp", length = 25)
	public String getCampoLivreOp() {
		return this.campoLivreOp;
	}

	public void setCampoLivreOp(String campoLivreOp) {
		this.campoLivreOp = campoLivreOp;
	}

	@Column(name = "numRecurso", length = 17)
	public String getNumRecurso() {
		return this.numRecurso;
	}

	public void setNumRecurso(String numRecurso) {
		this.numRecurso = numRecurso;
	}

}
