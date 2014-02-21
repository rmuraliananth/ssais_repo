/**
 * 
 */
package com.po.ssais.postoffice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.ssais.data.jpa.PostOfficeRepository;
import com.po.ssais.dto.PostOfficeDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
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
		Page<PostOffice> result = postOfficeRepository.findAll(pageRequest);
		searchDTO.setTotal(result.getTotalElements());
		List<PostOffice> postOfficeEntities = result.getContent();
		return convertToDTOs(postOfficeEntities);
	}

	@Override
	public void addPostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Add PostOffice");
		PostOffice postOffice = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOffice.setCrtTsp(new Date());
		postOffice.setUptTsp(new Date());
		postOfficeRepository.save(postOffice);
	}

	@Override
	public void updatePostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Update PostOffice");
		PostOffice postOffice = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOffice.setUptTsp(new Date());
		postOfficeRepository.save(postOffice);

	}

	@Override
	public void deletePostOffice(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Delete PostOffice");
		PostOffice entity = convertPostOfficeDtoToEntity(postOfficeDTO);
		postOfficeRepository.delete(entity);
	}

	private List<PostOfficeDTO> convertToDTOs(final List<PostOffice> postOffices) {
		LOGGER.debug("Convert postOffice entity to dto");
		List<PostOfficeDTO> postOfficeList = new ArrayList<PostOfficeDTO>();
		for (PostOffice postOffice : postOffices) {
			PostOfficeDTO e = convertEntityToDTO(postOffice);
			postOfficeList.add(e);
		}
		return postOfficeList;
	}

	private PostOfficeDTO convertEntityToDTO(PostOffice postOffice) {
		LOGGER.debug("Convert postOffice entity to dto");
		PostOfficeDTO dto = new PostOfficeDTO();
		dto.setId(postOffice.getId());
		dto.setName(postOffice.getName());
		dto.setBranch(postOffice.getBranch());
		dto.setAddress(postOffice.getAddress());
		dto.setCrtTsp(postOffice.getCrtTsp());
		dto.setUptTsp(postOffice.getUptTsp());

		return dto;
	}

	private PostOffice convertPostOfficeDtoToEntity(PostOfficeDTO postOfficeDTO) {
		LOGGER.debug("Convert postOffice dto to entity");
		PostOffice postOffice = new PostOffice();
		postOffice.setId(postOfficeDTO.getId());
		postOffice.setName(postOfficeDTO.getName());
		postOffice.setBranch(postOfficeDTO.getBranch());
		postOffice.setAddress(postOfficeDTO.getAddress());
		postOffice.setCrtTsp(postOfficeDTO.getCrtTsp());
		postOffice.setUptTsp(postOfficeDTO.getUptTsp());
		return postOffice;
	}

}
