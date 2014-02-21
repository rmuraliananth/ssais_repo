/**
 * 
 */
package com.po.ssais.agent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.ssais.data.jpa.AgentRepository;
import com.po.ssais.dto.AgentDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
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
		Page<Agent> results = agentRepository.findAll(pageRequest);
		searchDTO.setTotal(results.getTotalElements());
		List<Agent> agents = results.getContent();
		return convertToDTOs(agents);
	}

	@Override
	public void addAgent(AgentDTO agentDTO) {
		LOGGER.debug("Add Agent");
		Agent agent = convertAgentDtoToEntity(agentDTO);
		agent.setCrtTsp(new Date());
		agent.setUptTsp(new Date());
		agentRepository.save(agent);
	}

	@Override
	public void updateAgent(AgentDTO agentDTO) {
		LOGGER.debug("Update Agent");
		Agent agent = convertAgentDtoToEntity(agentDTO);
		agent.setUptTsp(new Date());
		agentRepository.save(agent);
	}

	@Override
	public void deleteAgent(AgentDTO agentDTO) {
		LOGGER.debug("Delete Agent");
		Agent entity = convertAgentDtoToEntity(agentDTO);
		agentRepository.delete(entity);
	}

	private List<AgentDTO> convertToDTOs(final List<Agent> agents) {
		LOGGER.debug("Convert agent entity to dto");
		List<AgentDTO> agentList = new ArrayList<AgentDTO>();
		for (Agent agent : agents) {
			AgentDTO e = convertEntityToDTO(agent);
			agentList.add(e);
		}
		return agentList;
	}

	private AgentDTO convertEntityToDTO(Agent agent) {
		LOGGER.debug("Convert agent entity to dto");
		AgentDTO dto = new AgentDTO();
		dto.setId(agent.getId());
		dto.setName(agent.getName());
		dto.setRegisterationNo(agent.getRegisterationNo());
		dto.setRegisterDate(agent.getRegisterDate());
		dto.setExpiredDate(agent.getExpiredDate());
		dto.setAddress(agent.getAddress());
		dto.setCrtTsp(agent.getCrtTsp());
		dto.setUptTsp(agent.getUptTsp());

		return dto;
	}

	private Agent convertAgentDtoToEntity(AgentDTO agentDTO) {
		LOGGER.debug("Convert agent dto to entity");
		Agent agent = new Agent();
		agent.setId(agentDTO.getId());
		agent.setName(agentDTO.getName());
		agent.setRegisterationNo(agentDTO.getRegisterationNo());
		agent.setRegisterDate(agentDTO.getRegisterDate());
		agent.setExpiredDate(agentDTO.getExpiredDate());
		agent.setAddress(agentDTO.getAddress());
		agent.setCrtTsp(agentDTO.getCrtTsp());
		agent.setUptTsp(agentDTO.getUptTsp());
		return agent;
	}

}
