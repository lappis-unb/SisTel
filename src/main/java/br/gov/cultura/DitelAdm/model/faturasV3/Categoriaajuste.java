package br.gov.cultura.DitelAdm.model.faturasV3;
// Generated 29/08/2016 10:12:50 by Hibernate Tools 4.3.4.Final

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
 * Categoriaajuste MODEL: Padrão FEBRABAN v3
 */
@Entity
@Table(name = "categoria_ajuste", catalog = "dbditel")
public class Categoriaajuste implements java.io.Serializable {

	private Integer idCatAjuste;
	private int codCatAjuste;
	private String sigla;
	private String descricao;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Set<Ajustes> ajusteses = new HashSet(0);
	
	public Categoriaajuste() {
	}

	public Categoriaajuste(int codCatAjuste, String sigla, String descricao) {
		this.codCatAjuste = codCatAjuste;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public Categoriaajuste(int codCatAjuste, String sigla, String descricao, Set<Ajustes> ajusteses) {
		this.codCatAjuste = codCatAjuste;
		this.sigla = sigla;
		this.descricao = descricao;
		this.ajusteses = ajusteses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_catAjuste", unique = true, nullable = false)
	public Integer getIdCatAjuste() {
		return this.idCatAjuste;
	}

	public void setIdCatAjuste(Integer idCatAjuste) {
		this.idCatAjuste = idCatAjuste;
	}

	@Column(name = "codCatAjuste", nullable = false)
	public int getCodCatAjuste() {
		return this.codCatAjuste;
	}

	public void setCodCatAjuste(int codCatAjuste) {
		this.codCatAjuste = codCatAjuste;
	}

	@Column(name = "sigla", nullable = false, length = 3)
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "descricao", nullable = false, length = 40)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaajuste")
	public Set<Ajustes> getAjusteses() {
		return this.ajusteses;
	}

	public void setAjusteses(Set<Ajustes> ajusteses) {
		this.ajusteses = ajusteses;
	}

}
