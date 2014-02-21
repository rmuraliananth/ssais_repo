package com.po.ssais.agent.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.po.ssais.agent.service.AgentService;
import com.po.ssais.dto.AgentDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
import com.po.ssais.dto.jqgrid.JqGridTableDTO;

/**
 * @author Murali
 * 
 */
@Controller
@RequestMapping("/agent")
public class AgentController {
	private static final Logger LOGGER = Logger
			.getLogger(AgentController.class);

	@Autowired
	private AgentService agentService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadAgentPage() {
		LOGGER.debug("Inside loadAgentPage() method");
		ModelAndView modelView = new ModelAndView("agent");
		return modelView;
	}

	@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
	public @ResponseBody
	void addAgent(@RequestBody AgentDTO agent) {
		LOGGER.info("Add New Agent Details...");
		agentService.addAgent(agent);
	}

	@RequestMapping(value = "/updateAgent", method = RequestMethod.PUT)
	public @ResponseBody
	void updateAgent(@RequestBody AgentDTO agent) {
		LOGGER.info("Update Agent Details...");
		agentService.updateAgent(agent);
	}

	@RequestMapping(value = "/deleteAgent", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteAgent(@RequestBody AgentDTO agent) {
		LOGGER.info("Delete Agent Details...");
		agentService.deleteAgent(agent);
	}

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<AgentDTO> viewAgents(
			@RequestParam(value = "_search", required = false) boolean _search,
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "rows", required = false) int rows,
			@RequestParam(value = "searchField", required = false) String searchField,
			@RequestParam(value = "searchOper", required = false) String searchOper,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sord", required = false) String sord) {

		LOGGER.info("Fetch Agent Details...");
		JqGridSearchDTO searchDTO = new JqGridSearchDTO(_search, page, rows,
				searchField, searchOper, searchString, sord);
		List<AgentDTO> rowList = agentService.fetchAgents(searchDTO);

		JqGridTableDTO<AgentDTO> table = new JqGridTableDTO<AgentDTO>();

		// TODO :: Fix below calculation and moved to separate method
		double totalPages = 0;
		double pages = page;
		double limit = rows;
		if (searchDTO.getTotal() > 0) {
			totalPages = Math.ceil(searchDTO.getTotal() / limit);
		}

		if (pages > totalPages) {
			pages = totalPages;
		}

		table.setPage(String.valueOf(pages));
		table.setTotal(String.valueOf(totalPages));
		table.setRecords(String.valueOf(searchDTO.getTotal()));

		table.setRows(rowList);
		table.setUserdata(rowList);

		return table;
	}

}
