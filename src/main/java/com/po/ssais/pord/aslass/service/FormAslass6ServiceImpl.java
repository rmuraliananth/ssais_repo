/**
 * 
 */
package com.po.ssais.pord.aslass.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.ssais.data.jpa.AccountRepository;
import com.po.ssais.dto.AccountDTO;
import com.po.ssais.entities.Account;

/**
 * @author Murali
 * 
 */
@Service("FormAslass6Service")
public class FormAslass6ServiceImpl implements FormAslass6Service {
	private static final Logger LOGGER = Logger
			.getLogger(FormAslass6ServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountDTO> searchAccounts(String _search_by_account_no,
			String _search_by_account_name) {
		LOGGER.debug("Get accounts");
		LOGGER.debug("Search param :: _search_by_account_no = "
				+ _search_by_account_no);
		LOGGER.debug("Search param :: _search_by_account_name = "
				+ _search_by_account_name);
		List<Account> accountList = accountRepository
				.searchByAccountNoLikeOrNameLikeOrderByAccNoDesc(
						_search_by_account_no, _search_by_account_name);
		List<AccountDTO> accountDTOList = new LinkedList<AccountDTO>();
		for (Account account : accountList) {
			accountDTOList.add(convertAccountToDTO(account));
		}
		return accountDTOList;
	}

	private AccountDTO convertAccountToDTO(Account account) {
		LOGGER.debug("Convert account entity to dto");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setAccountNo(account.getAccountNo());
		accountDTO.setName(account.getCustomer().getName());
		accountDTO
				.setPrincipalAmount((account.getPrincipalAmount() == null ? null
						: account.getPrincipalAmount().doubleValue()));
		accountDTO.setOpenDate(account.getOpenDate());
		return accountDTO;
	}

}
