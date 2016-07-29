package br.gov.cultura.DitelAdm.modelo;
// Generated 05/07/2016 12:36:15 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Resumo generated by hbm2java
 */
@Entity
@Table(name = "resumo", catalog = "diteladmdev")
public class Resumo implements java.io.Serializable {

	private ResumoId id;
	private Fatura fatura;
	private String idUnico;
	private int cnl;
	private int modServ;
	private Date dataAtiv;
	private Date dataDesativ;
	private int quantRegServ;
	private float valorTotalRegChamadaImp;
	private float valorTotalImp;
	private float valorTotalContaRecursoImp;
	private String degrau;
	private String velocidade;
	private String uniVelocidade;
	private Date dataVenc;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set<Ajustes> ajusteses = new HashSet(0);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set<Descontos> descontoses = new HashSet(0);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set<Planos> planoses = new HashSet(0);
	@SuppressWarnings({ "rawtypes", "unchecked" })	
	private Set<Chamadas> chamadases = new HashSet(0);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set<Servicos> servicoses = new HashSet(0);

	public Resumo() {
	}

	public Resumo(ResumoId id, Fatura fatura, String idUnico, int cnl, int modServ, Date dataAtiv, Date dataDesativ,
			int quantRegServ, float valorTotalRegChamadaImp, float valorTotalImp, float valorTotalContaRecursoImp,
			Date dataVenc) {
		this.id = id;
		this.fatura = fatura;
		this.idUnico = idUnico;
		this.cnl = cnl;
		this.modServ = modServ;
		this.dataAtiv = dataAtiv;
		this.dataDesativ = dataDesativ;
		this.quantRegServ = quantRegServ;
		this.valorTotalRegChamadaImp = valorTotalRegChamadaImp;
		this.valorTotalImp = valorTotalImp;
		this.valorTotalContaRecursoImp = valorTotalContaRecursoImp;
		this.dataVenc = dataVenc;
	}

	public Resumo(ResumoId id, Fatura fatura, String idUnico, int cnl, int modServ, Date dataAtiv, Date dataDesativ,
			int quantRegServ, float valorTotalRegChamadaImp, float valorTotalImp, float valorTotalContaRecursoImp,
			String degrau, String velocidade, String uniVelocidade, Date dataVenc, Set<Ajustes> ajusteses, Set<Descontos> descontoses,
			Set<Planos> planoses, Set<Chamadas> chamadases, Set<Servicos> servicoses) {
		this.id = id;
		this.fatura = fatura;
		this.idUnico = idUnico;
		this.cnl = cnl;
		this.modServ = modServ;
		this.dataAtiv = dataAtiv;
		this.dataDesativ = dataDesativ;
		this.quantRegServ = quantRegServ;
		this.valorTotalRegChamadaImp = valorTotalRegChamadaImp;
		this.valorTotalImp = valorTotalImp;
		this.valorTotalContaRecursoImp = valorTotalContaRecursoImp;
		this.degrau = degrau;
		this.velocidade = velocidade;
		this.uniVelocidade = uniVelocidade;
		this.dataVenc = dataVenc;
		this.ajusteses = ajusteses;
		this.descontoses = descontoses;
		this.planoses = planoses;
		this.chamadases = chamadases;
		this.servicoses = servicoses;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "numRecurso", column = @Column(name = "numRecurso", nullable = false, length = 20)),
			@AttributeOverride(name = "faturaNumFatura", column = @Column(name = "fatura_numFatura", nullable = false)),
			@AttributeOverride(name = "faturaClienteCodCliente", column = @Column(name = "fatura_cliente_codCliente", nullable = false, length = 15)),
			@AttributeOverride(name = "faturaClienteOperadoraCodOperadora", column = @Column(name = "fatura_cliente_operadora_codOperadora", nullable = false)),
			@AttributeOverride(name = "faturaDataEmissao", column = @Column(name = "fatura_dataEmissao", nullable = false, length = 10)) })
	public ResumoId getId() {
		return this.id;
	}

	public void setId(ResumoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "fatura_numFatura", referencedColumnName = "numFatura", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "fatura_cliente_codCliente", referencedColumnName = "cliente_codCliente", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "fatura_cliente_operadora_codOperadora", referencedColumnName = "cliente_operadora_codOperadora", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "fatura_dataEmissao", referencedColumnName = "dataEmissao", nullable = false, insertable = false, updatable = false) })
	public Fatura getFatura() {
		return this.fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	@Column(name = "idUnico", nullable = false, length = 25)
	public String getIdUnico() {
		return this.idUnico;
	}

	public void setIdUnico(String idUnico) {
		this.idUnico = idUnico;
	}

	@Column(name = "cnl", nullable = false)
	public int getCnl() {
		return this.cnl;
	}

	public void setCnl(int cnl) {
		this.cnl = cnl;
	}

	@Column(name = "modServ", nullable = false)
	public int getModServ() {
		return this.modServ;
	}

	public void setModServ(int modServ) {
		this.modServ = modServ;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataAtiv", nullable = false, length = 10)
	public Date getDataAtiv() {
		return this.dataAtiv;
	}

	public void setDataAtiv(Date dataAtiv) {
		this.dataAtiv = dataAtiv;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataDesativ", length = 10)
	public Date getDataDesativ() {
		return this.dataDesativ;
	}

	public void setDataDesativ(Date dataDesativ) {
		this.dataDesativ = dataDesativ;
	}

	@Column(name = "quantRegServ", nullable = false)
	public int getQuantRegServ() {
		return this.quantRegServ;
	}

	public void setQuantRegServ(int quantRegServ) {
		this.quantRegServ = quantRegServ;
	}

	@Column(name = "valorTotalRegChamadaImp", nullable = false, precision = 12, scale = 0)
	public float getValorTotalRegChamadaImp() {
		return this.valorTotalRegChamadaImp;
	}

	public void setValorTotalRegChamadaImp(float valorTotalRegChamadaImp) {
		this.valorTotalRegChamadaImp = valorTotalRegChamadaImp;
	}

	@Column(name = "valorTotalImp", nullable = false, precision = 12, scale = 0)
	public float getValorTotalImp() {
		return this.valorTotalImp;
	}

	public void setValorTotalImp(float valorTotalImp) {
		this.valorTotalImp = valorTotalImp;
	}

	@Column(name = "valorTotalContaRecursoImp", nullable = false, precision = 12, scale = 0)
	public float getValorTotalContaRecursoImp() {
		return this.valorTotalContaRecursoImp;
	}

	public void setValorTotalContaRecursoImp(float valorTotalContaRecursoImp) {
		this.valorTotalContaRecursoImp = valorTotalContaRecursoImp;
	}

	@Column(name = "degrau", length = 2)
	public String getDegrau() {
		return this.degrau;
	}

	public void setDegrau(String degrau) {
		this.degrau = degrau;
	}

	@Column(name = "velocidade", length = 5)
	public String getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	@Column(name = "uniVelocidade", length = 4)
	public String getUniVelocidade() {
		return this.uniVelocidade;
	}

	public void setUniVelocidade(String uniVelocidade) {
		this.uniVelocidade = uniVelocidade;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataVenc", nullable = false, length = 10)
	public Date getDataVenc() {
		return this.dataVenc;
	}

	public void setDataVenc(Date dataVenc) {
		this.dataVenc = dataVenc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resumo")
	public Set<Ajustes> getAjusteses() {
		return this.ajusteses;
	}

	public void setAjusteses(Set<Ajustes> ajusteses) {
		this.ajusteses = ajusteses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resumo")
	public Set<Descontos> getDescontoses() {
		return this.descontoses;
	}

	public void setDescontoses(Set<Descontos> descontoses) {
		this.descontoses = descontoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resumo")
	public Set<Planos> getPlanoses() {
		return this.planoses;
	}

	public void setPlanoses(Set<Planos> planoses) {
		this.planoses = planoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resumo")
	public Set<Chamadas> getChamadases() {
		return this.chamadases;
	}

	public void setChamadases(Set<Chamadas> chamadases) {
		this.chamadases = chamadases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resumo")
	public Set<Servicos> getServicoses() {
		return this.servicoses;
	}

	public void setServicoses(Set<Servicos> servicoses) {
		this.servicoses = servicoses;
	}

}
