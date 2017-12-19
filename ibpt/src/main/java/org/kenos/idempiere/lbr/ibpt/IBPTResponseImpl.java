package org.kenos.idempiere.lbr.ibpt;

import java.math.BigDecimal;

import org.kenos.idempiere.lbr.tax.ibpt.IBPTResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 		Bean IBPT Response for Products and Services
 * 
 * 	@author Ricardo Santana (Kenos, www.kenos.com.br)
 *	@version $Id: IBPTResponse.java, v1.0 2017/03/24 14:32:53 PM, ralexsander Exp $
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBPTResponseImpl implements IBPTResponse
{
	@JsonProperty (value = "Codigo")
	private String codigo;
	@JsonProperty (value = "UF")
	private String uf;
	@JsonProperty (value = "EX")	// Only for NCM
	private String ex;
	@JsonProperty (value = "Descricao")
	private String desc;
	@JsonProperty (value = "Nacional")
	private BigDecimal nacional;
	@JsonProperty (value = "Estadual")
	private BigDecimal estadual;
	@JsonProperty (value = "Importado")
	private BigDecimal importado;
	@JsonProperty (value = "Municipal")
	private BigDecimal municipal;
	@JsonProperty (value = "Tipo")
	private String tipo;
	@JsonProperty (value = "VigenciaInicio")
	private String vigenciaInicio;
	@JsonProperty (value = "VigenciaFim")
	private String vigenciaFim;
	@JsonProperty (value = "Chave")
	private String chave;
	@JsonProperty (value = "Versao")
	private String versao;
	@JsonProperty (value = "Fonte")
	private String fonte;
	
	public String getCodigo()
	{
		return codigo;
	}
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	public String getUf()
	{
		return uf;
	}
	public void setUf(String uf)
	{
		this.uf = uf;
	}
	public String getEx()
	{
		return ex;
	}
	public void setEx(String ex)
	{
		this.ex = ex;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public BigDecimal getNacional()
	{
		return nacional;
	}
	public void setNacional(BigDecimal nacional)
	{
		this.nacional = nacional;
	}
	public BigDecimal getEstadual()
	{
		return estadual;
	}
	public void setEstadual(BigDecimal estadual)
	{
		this.estadual = estadual;
	}
	public BigDecimal getImportado()
	{
		return importado;
	}
	public void setImportado(BigDecimal importado)
	{
		this.importado = importado;
	}
	public BigDecimal getMunicipal()
	{
		return municipal;
	}
	public void setMunicipal(BigDecimal municipal)
	{
		this.municipal = municipal;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public String getVigenciaInicio()
	{
		return vigenciaInicio;
	}
	public void setVigenciaInicio(String vigenciaInicio)
	{
		this.vigenciaInicio = vigenciaInicio;
	}
	public String getVigenciaFim()
	{
		return vigenciaFim;
	}
	public void setVigenciaFim(String vigenciaFim)
	{
		this.vigenciaFim = vigenciaFim;
	}
	public String getChave()
	{
		return chave;
	}
	public void setChave(String chave)
	{
		this.chave = chave;
	}
	public String getVersao()
	{
		return versao;
	}
	public void setVersao(String versao)
	{
		this.versao = versao;
	}
	public String getFonte()
	{
		return fonte;
	}
	public void setFonte(String fonte)
	{
		this.fonte = fonte;
	}
}	//	IBPTResponseImpl
