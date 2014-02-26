/**
 * 
 */
package com.po.ssais.pord.aslass.service;

import java.util.List;

import com.po.ssais.dto.AccountDTO;

/**
 * @author Murali
 * 
 */
public interface FormAslass6Service {

	public List<AccountDTO> searchAccounts(final String _search_by_account_no,
			final String _search_by_account_name);
}
