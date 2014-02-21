package com.po.ssais.postoffice.web.controller;

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

import com.po.ssais.dto.PostOfficeDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
import com.po.ssais.dto.jqgrid.JqGridTableDTO;
import com.po.ssais.postoffice.service.PostOfficeService;

/**
 * @author Murali
 * 
 */
@Controller
@RequestMapping("/postoffice")
public class PostOfficeController {
	private static final Logger LOGGER = Logger
			.getLogger(PostOfficeController.class);

	@Autowired
	private PostOfficeService postOfficeService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadPostOfficePage() {
		LOGGER.debug("Inside loadPostOfficePage() method");
		ModelAndView modelView = new ModelAndView("postoffice");
		return modelView;
	}

	@RequestMapping(value = "/addPostOffice", method = RequestMethod.POST)
	public @ResponseBody
	void addPostOffice(@RequestBody PostOfficeDTO postOffice) {
		LOGGER.info("Add New PostOffice Details...");
		postOfficeService.addPostOffice(postOffice);
	}

	@RequestMapping(value = "/updatePostOffice", method = RequestMethod.PUT)
	public @ResponseBody
	void updatePostOffice(@RequestBody PostOfficeDTO postOffice) {
		LOGGER.info("Update PostOffice Details...");
		postOfficeService.updatePostOffice(postOffice);
	}

	@RequestMapping(value = "/deletePostOffice", method = RequestMethod.DELETE)
	public @ResponseBody
	void deletePostOffice(@RequestBody PostOfficeDTO postOffice) {
		LOGGER.info("Delete PostOffice Details...");
		postOfficeService.deletePostOffice(postOffice);
	}

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<PostOfficeDTO> viewPostOffices(
			@RequestParam(value = "_search", required = false) boolean _search,
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "rows", required = false) int rows,
			@RequestParam(value = "searchField", required = false) String searchField,
			@RequestParam(value = "searchOper", required = false) String searchOper,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sord", required = false) String sord) {

		LOGGER.info("Fetch PostOffice Details...");
		JqGridSearchDTO searchDTO = new JqGridSearchDTO(_search, page, rows,
				searchField, searchOper, searchString, sord);
		List<PostOfficeDTO> rowList = postOfficeService
				.fetchPostOffices(searchDTO);

		JqGridTableDTO<PostOfficeDTO> table = new JqGridTableDTO<PostOfficeDTO>();
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
