/**
 * 
 */
package com.po.ssais.agent.service;

import java.util.List;

import com.po.ssais.dto.AgentDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;

/**
 * @author muraliananthr
 * 
 */
public interface AgentService {

	public List<AgentDTO> fetchAgents(final JqGridSearchDTO searchDTO);

	public void addAgent(AgentDTO agentDTO);

	public void updateAgent(AgentDTO agentDTO);

	public void deleteAgent(AgentDTO agentDTO);
}
