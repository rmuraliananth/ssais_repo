/**
 * 
 */
package com.po.ssais.agent.service;

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

import com.po.ssais.data.jpa.AgentRepository;
import com.po.ssais.dto.AgentDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
import com.po.ssais.entities.Account;
import com.po.ssais.entities.Agent;

/**
 * @author muraliananthr
 * 
 */
@Service("AgentService")
public class AgentServiceImpl implements AgentService {
	private static final Logger LOGGER = Logger
			.getLogger(AgentServiceImpl.class);

	@Autowired
	private AgentRepository agentRepository;

	@Override
	@Transactional(readOnly = true)
	public List<AgentDTO> fetchAgents(final JqGridSearchDTO searchDTO) {
		LOGGER.debug("Fetch Agents");
		// TODO :: apply filter condition
		int page = (searchDTO.getPage() == 0 ? 0 : searchDTO.getPage() - 1);
		final PageRequest pageRequest = new PageRequest(page,
				searchDTO.getRows());
		Page<Agent> cu = agentRepository.findAll(pageRequest);
		searchDTO.setTotal(cu.getTotalElements());
		List<Agent> agentEntities = cu.getContent();
		return convertToDTOs(agentEntities);
	}

	@Override
	public void addAgent(AgentDTO agentDTO) {
		LOGGER.debug("Add Agent");
		Agent agent = convertAgentDtoToEntity(agentDTO);
		agent.setCrtTsp(new Date());
		agent.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(agentDTO);
		if (account != null) {
			account.setCrtTsp(agent.getCrtTsp());
			account.setUptTsp(agent.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
		}

		Agent savedAgent = agentRepository.save(agent);

		// if (entity.getAccounts() != null & !entity.getAccounts().isEmpty()) {
		// Iterator<Account> element = entity.getAccounts().iterator();
		// while (element.hasNext()) {
		// Account account = element.next();
		// account.setAgent(savedAgent);
		// account.setCrtTsp(entity.getCrtTsp());
		// account.setUptTsp(entity.getUptTsp());
		// }
		// }

	}

	@Override
	public void updateAgent(AgentDTO agentDTO) {
		LOGGER.debug("Update Agent");
		Agent agent = convertAgentDtoToEntity(agentDTO);
		agent.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(agentDTO);
		if (account != null) {
			account.setUptTsp(agent.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
		}
		agentRepository.save(agent);

	}

	@Override
	public void deleteAgent(AgentDTO agentDTO) {
		LOGGER.debug("Delete Agent");
		Agent entity = convertAgentDtoToEntity(agentDTO);
		agentRepository.delete(entity);
	}

	private List<AgentDTO> convertToDTOs(final List<Agent> agentEntities) {
		LOGGER.debug("Convert agent entity to dto");
		List<AgentDTO> agentList = new ArrayList<AgentDTO>();
		for (Agent agentEntity : agentEntities) {
			AgentDTO e = convertEntityToDTO(agentEntity);
			agentList.add(e);
		}
		return agentList;
	}

	private AgentDTO convertEntityToDTO(Agent agent) {
		LOGGER.debug("Convert agent entity to dto");
		AgentDTO dto = new AgentDTO();
		dto.setId(agent.getId());
		dto.setName(agent.getName());
		dto.setAddress(agent.getAddress());
		dto.setCrtTsp(agent.getCrtTsp());
		dto.setUptTsp(agent.getUptTsp());

		// List<Account> accounts = accountRepository.findByAgent(agent);
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

		// if (agent.getAccounts() != null && !agent.getAccounts().isEmpty()) {
		// Iterator<Account> element = agent.getAccounts().iterator();
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

	private Agent convertAgentDtoToEntity(AgentDTO agentDTO) {
		LOGGER.debug("Convert agent dto to entity");
		Agent agent = new Agent();
		agent.setId(agentDTO.getId());
		agent.setName(agentDTO.getName());
		agent.setAddress(agentDTO.getAddress());
		agent.setCrtTsp(agentDTO.getCrtTsp());
		agent.setUptTsp(agentDTO.getUptTsp());

		return agent;
	}

	private Account convertAccountDtoToEntity(AgentDTO agentDTO) {

		Account account = null;
		// if (agentDTO.getAccount() != null) {
		// account = new Account();
		// account.setId(agentDTO.getAccount().getId());
		// account.setAccountNo(agentDTO.getAccount().getAccountNo());
		// account.setName(agentDTO.getName());
		// account.setOpenDate(agentDTO.getAccount().getOpenDate());
		// account.setMaturityDate(agentDTO.getAccount().getMaturityDate());
		// account.setPrincipalAmount(new BigDecimal(agentDTO.getAccount()
		// .getPrincipalAmount()));
		//
		// // TODO :: implement balance amount check , last paid date & ROI
		//
		// account.setBalanceAmount(account.getPrincipalAmount());
		// account.setLastPaidDate(agentDTO.getAccount().getOpenDate());
		//
		// account.setRateOfInterest(new BigDecimal(9.75d));
		// account.setAccountType("NEW");
		//
		// account.setCrtTsp(agentDTO.getCrtTsp());
		// account.setUptTsp(agentDTO.getUptTsp());
		// }

		return account;
	}

}
