package org.kenos.ibpt;

import java.net.URLEncoder;
import java.util.Collections;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.client.WebClient;
import org.kenos.ibpt.bean.IBPTResponseImpl;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * 			IBPT
 * 
 * 	@author Ricardo Santana (Kenos, www.kenos.com.br)
 *	@version $Id: IBPT.java, v1.0 2017/03/24 2:22:15 PM, ralexsander Exp $
 */
public class IBPTImpl implements IBPT
{
	private JacksonJsonProvider m_Provider;
	private ObjectMapper m_Mapper;
	private final String m_Token;
	//
	private static final String URL 					= "http://iws.ibpt.org.br";
	private static final String PRODUCTS	 			= "/api/deolhonoimposto/Produtos";
	private static final String SERVICES	 			= "/api/deolhonoimposto/Servicos";

	private static final String ENCODING 				= "UTF-8";
	
	/**
	 * 	 Default Constructor
	 * 
	 * @param token - Token obtained from pipedrive settings
	 */
	public IBPTImpl (String token)
	{
		m_Token = "?token=" + token;
		
		//	Mapper fields
		m_Mapper = new ObjectMapper()
				.setSerializationInclusion(Include.NON_NULL)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		//	Provider
		m_Provider = new JacksonJsonProvider();
		m_Provider.setMapper(m_Mapper);
	}	//	Pipedrive
	
	/**
	 * 		Get tax for NCM
	 * 
	 * @param cnpj
	 * @param ncm
	 * @param uf
	 * @param ex
	 * @return
	 * @throws Exception 
	 */
	public IBPTResponseImpl getTaxForNCM (String cnpj, String ncm, String uf, String ex) throws Exception
	{
		String url = URL + PRODUCTS + m_Token
						+ "&cnpj=" 		+ URLEncoder.encode (cnpj, ENCODING)
						+ "&codigo=" 	+ URLEncoder.encode (ncm, ENCODING)
						+ "&uf=" 		+ URLEncoder.encode (uf, ENCODING)
						+ "&ex=" 		+ URLEncoder.encode (ex, ENCODING);
		
		Response response = WebClient
				
				//	Create the client using Jackson provider to parse the JSON
				.create (url, Collections.singletonList (m_Provider))
				
				//	Adjust the type
				.type(MediaType.APPLICATION_JSON)
				
				//	GET
				.get();
		
		//	Check status
		if (response.getStatus() == Status.OK.getStatusCode())
		{
			//	Parse Response
			IBPTResponseImpl post = response.readEntity(IBPTResponseImpl.class);
			return post;
		}
		throw new Exception ("NCM não encontrado no IBPT: " + ncm);
	}	//	getTaxForNCM
	
	/**
	 * 	Get tax for NBS
	 * 
	 * @param cnpj
	 * @param nbs
	 * @param uf
	 * @param ex
	 * @return
	 * @throws Exception 
	 */
	public IBPTResponseImpl getTaxForNBS (String cnpj, String nbs, String uf) throws Exception
	{
		String url = URL + SERVICES + m_Token
						+ "&cnpj=" 		+ URLEncoder.encode (cnpj, ENCODING)
						+ "&codigo=" 	+ URLEncoder.encode (nbs, ENCODING)
						+ "&uf=" 		+ URLEncoder.encode (uf, ENCODING);
		
		Response response = WebClient
				
				//	Create the client using Jackson provider to parse the JSON
				.create (url, Collections.singletonList (m_Provider))
				
				//	Adjust the type
				.type(MediaType.APPLICATION_JSON)
				
				//	GET
				.get();
		
		//	Check status
		if (response.getStatus() == Status.OK.getStatusCode())
		{
			//	Parse Response
			IBPTResponseImpl post = response.readEntity(IBPTResponseImpl.class);
			return post;
		}
		throw new Exception ("NBS não encontrado no IBPT: " + nbs);
	}	//	getTaxForNCM
	
	public static void main (String[] args) throws Exception
	{
		String key 	= "qwertyuiopasdfghjklzxcvbnm";
		String cnpj = "00000000000000";
		String ncm 	= "101011000";
		String nbs 	= "38249031";
		String uf  	= "SP";
		String ex  	= "0";
		
		IBPTImpl ibpt = new IBPTImpl (key);
		//
		IBPTResponseImpl taxForNCM = ibpt.getTaxForNCM(cnpj, ncm, uf, ex);
		
		if (taxForNCM != null && taxForNCM.getCodigo() != null)
		{
			System.out.println("****************************************");
			System.out.println("NCM: " + taxForNCM.getCodigo());
			System.out.println("EX: " + taxForNCM.getEx());
			//
			System.out.println("Nacional: " + taxForNCM.getNacional());
			System.out.println("Estadual: " + taxForNCM.getEstadual());
			System.out.println("Importado: " + taxForNCM.getImportado());
			System.out.println("Municipal: " + taxForNCM.getMunicipal());
			//
			System.out.println("Vigência: " + taxForNCM.getVigenciaInicio());
			System.out.println("Até: " + taxForNCM.getVigenciaFim());
		}
		else
			System.out.println("null response");
		
		IBPTResponseImpl taxForNBS = ibpt.getTaxForNBS(cnpj, nbs, uf);
		
		if (taxForNBS != null && taxForNBS.getCodigo() != null)
		{
			System.out.println("****************************************");
			System.out.println("NBS: " + taxForNBS.getCodigo());
			System.out.println("EX: " + taxForNBS.getEx());
			//
			System.out.println("Nacional: " + taxForNBS.getNacional());
			System.out.println("Estadual: " + taxForNBS.getEstadual());
			System.out.println("Importado: " + taxForNBS.getImportado());
			System.out.println("Municipal: " + taxForNBS.getMunicipal());
			//
			System.out.println("Vigência: " + taxForNBS.getVigenciaInicio());
			System.out.println("Até: " + taxForNBS.getVigenciaFim());
		}
		else
			System.out.println("null response");
	}
}	//	IBPT
