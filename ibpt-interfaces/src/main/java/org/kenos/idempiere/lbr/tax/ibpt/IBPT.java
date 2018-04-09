package org.kenos.idempiere.lbr.tax.ibpt;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * 		IBPT Interface for API
 * 
 * 	@author Ricardo Santana (Kenos, www.kenos.com.br)
 *	@version $Id: IBPT.java, v1.0 2017/05/19 5:36:11 PM, ralexsander Exp $
 */
public interface IBPT
{
	/**
	 * Este era o método utilizado na versão antiga da API, em que alguns
	 * campos não eram obrigatórios.
	 */
	@Deprecated
	public IBPTResponse getTaxForNCM (String cnpj, String ncm, String uf, String ex) throws Exception;
	
	/**
	 * Este era o método utilizado na versão antiga da API, em que alguns
	 * campos não eram obrigatórios.
	 */
	@Deprecated
	public IBPTResponse getTaxForNBS (String cnpj, String nbs, String uf) throws Exception;
	
	public IBPTResponse getTaxForNCM (String cnpj, String ncm, String uf, String ex, String descricao, 
			String unidadeMedida, BigDecimal valor, String gtin) throws Exception;
	public IBPTResponse getTaxForNBS (String cnpj, String nbs, String uf, String descricao,
			String unidadeMedida, BigDecimal valor) throws Exception;

	/**
	 * 		Factory
	 * 	@author Ricardo Santana (Kenos, www.kenos.com.br)
	 *	@version $Id: SAT.java, v1.0 2016/08/08 2:11:01 PM, ralexsander Exp $
	 */
	public static final class Factory
	{
		/**
		 * 		Factory
		 * 	@return
		 * 	@throws InstantiationException
		 * 	@throws IllegalAccessException
		 * 	@throws ClassNotFoundException
		 * 	@throws SecurityException 
		 * 	@throws NoSuchMethodException 
		 * 	@throws InvocationTargetException 
		 * 	@throws IllegalArgumentException 
		 */
		public static IBPT newInstance (String key) throws ClassNotFoundException, Exception 
		{
			Class<?> clazz = Class.forName("org.kenos.idempiere.lbr.ibpt.IBPTImpl");
			return (IBPT) clazz.getDeclaredConstructor(String.class).newInstance(key);
		}	//	newInstance
    }	//	Factory
}	//	IBPT
