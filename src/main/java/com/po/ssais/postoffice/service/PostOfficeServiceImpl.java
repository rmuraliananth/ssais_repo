/**
 * 
 */
package com.po.ssais.postoffice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.ssais.data.jpa.PostOfficeRepository;
import com.po.ssais.dto.PostOfficeDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
import com.po.ssais.entities.Account;
import com.po.ssais.entities.PostOffice;

/**
 * @author muraliananthr
 * 
 */
@Service("PostOfficeService")
public class PostOfficeServiceImpl implements PostOfficeService {
	private static final Logger LOGGER = Logger
			.getLogger(PostOfficeServiceImpl.class);

	@Autowired
	private PostOfficeRepository postOfficeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<PostOfficeDTO> fetchPostOffices(final JqGridSearchDTO searchDTO) {
		LOGGER.debug("Fetch PostOffices");
		// TODO :: apply filter condition
		int page = (searchDTO.getPage() == 0 ? 0 : searchDTO.getPage() - 1);
		final PageRequest pageRequest = new PageRequest(page,
				searchDTO.getRows());
		Page<PostOffice> cu = postOfficeRepository.findAll(pageRequest);
		searchDTO.setTotal(cu.getTotalElements());
		List<PostOffice> postOfficeEntities = cu.getContent();
		return convertToDTOs(postOfficeEntities);
	}

	@Override
	public void addPostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Add PostOffice");
		PostOffice postOffice = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOffice.setCrtTsp(new Date());
		postOffice.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(postOfficeDTO);
		if (account != null) {
			account.setCrtTsp(postOffice.getCrtTsp());
			account.setUptTsp(postOffice.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
		}

		PostOffice savedPostOffice = postOfficeRepository.save(postOffice);

		// if (entity.getAccounts() != null & !entity.getAccounts().isEmpty()) {
		// Iterator<Account> element = entity.getAccounts().iterator();
		// while (element.hasNext()) {
		// Account account = element.next();
		// account.setPostOffice(savedPostOffice);
		// account.setCrtTsp(entity.getCrtTsp());
		// account.setUptTsp(entity.getUptTsp());
		// }
		// }

	}

	@Override
	public void updatePostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Update PostOffice");
		PostOffice postOffice = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOffice.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(postOfficeDTO);
		if (account != null) {
			account.setUptTsp(postOffice.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
		}
		postOfficeRepository.save(postOffice);

	}

	@Override
	public void deletePostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Delete PostOffice");
		PostOffice entity = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOfficeRepository.delete(entity);
	}

	private List<PostOfficeDTO> convertToDTOs(
			final List<PostOffice> postOfficeEntities) {
		LOGGER.debug("Convert postOffice entity to dto");
		List<PostOfficeDTO> postOfficeList = new ArrayList<PostOfficeDTO>();
		for (PostOffice postOfficeEntity : postOfficeEntities) {
			PostOfficeDTO e = convertEntityToDTO(postOfficeEntity);
			postOfficeList.add(e);
		}
		return postOfficeList;
	}

	private PostOfficeDTO convertEntityToDTO(PostOffice postOffice) {
		LOGGER.debug("Convert postOffice entity to dto");
		PostOfficeDTO dto = new PostOfficeDTO();
		dto.setId(postOffice.getId());
//		dto.setName(postOffice.getName());
//		dto.setAddress(postOffice.getAddress());
//		dto.setCrtTsp(postOffice.getCrtTsp());
//		dto.setUptTsp(postOffice.getUptTsp());

		// List<Account> accounts =
		// accountRepository.findByPostOffice(postOffice);
		// for (Account account : accounts) {
		// AccountDTO accountDTO = new AccountDTO();
		// accountDTO.setId(account.getId());
		// accountDTO.setAccountNo(account.getAccountNo());
		// accountDTO.setOpenDate(account.getOpenDate());
		// accountDTO.setMaturityDate(account.getMaturityDate());
		// if (account.getPrincipalAmount() != null) {
		// accountDTO.setPrincipalAmount(account.getPrincipalAmount()
		// .doubleValue());
		// }
		// dto.setAccount(accountDTO);
		// }

		// if (postOffice.getAccounts() != null &&
		// !postOffice.getAccounts().isEmpty()) {
		// Iterator<Account> element = postOffice.getAccounts().iterator();
		// while (element.hasNext()) {
		// Account account = element.next();
		// AccountDTO accountDTO = new AccountDTO();
		// accountDTO.setId(account.getId());
		// accountDTO.setAccountNo(account.getAccountNo());
		// accountDTO.setOpenDate(account.getOpenDate());
		// accountDTO.setMaturityDate(account.getMaturityDate());
		// if (account.getPrincipalAmount() != null) {
		// accountDTO.setPrincipalAmount(account.getPrincipalAmount()
		// .doubleValue());
		// }
		// dto.setAccount(accountDTO);
		// }
		//
		// }
		return dto;
	}

	private PostOffice convertPostOfficeDtoToEntity(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Convert postOffice dto to entity");
		PostOffice postOffice = new PostOffice();
		postOffice.setId(postOfficeDTO.getId());
//		postOffice.setName(postOfficeDTO.getName());
//		postOffice.setAddress(postOfficeDTO.getAddress());
//		postOffice.setCrtTsp(postOfficeDTO.getCrtTsp());
//		postOffice.setUptTsp(postOfficeDTO.getUptTsp());

		return postOffice;
	}

	private Account convertAccountDtoToEntity(PostOfficeDTO postOfficeDTO) {

		Account account = null;
		// if (postOfficeDTO.getAccount() != null) {
		// account = new Account();
		// account.setId(postOfficeDTO.getAccount().getId());
		// account.setAccountNo(postOfficeDTO.getAccount().getAccountNo());
		// account.setName(postOfficeDTO.getName());
		// account.setOpenDate(postOfficeDTO.getAccount().getOpenDate());
		// account.setMaturityDate(postOfficeDTO.getAccount().getMaturityDate());
		// account.setPrincipalAmount(new BigDecimal(postOfficeDTO.getAccount()
		// .getPrincipalAmount()));
		//
		// // TODO :: implement balance amount check , last paid date & ROI
		//
		// account.setBalanceAmount(account.getPrincipalAmount());
		// account.setLastPaidDate(postOfficeDTO.getAccount().getOpenDate());
		//
		// account.setRateOfInterest(new BigDecimal(9.75d));
		// account.setAccountType("NEW");
		//
		// account.setCrtTsp(postOfficeDTO.getCrtTsp());
		// account.setUptTsp(postOfficeDTO.getUptTsp());
		// }

		return account;
	}

}
