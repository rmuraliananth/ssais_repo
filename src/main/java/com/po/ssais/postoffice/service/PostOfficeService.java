/**
 * 
 */
package com.po.ssais.postoffice.service;

import java.util.List;

import com.po.ssais.dto.PostOfficeDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;

/**
 * @author muraliananthr
 * 
 */
public interface PostOfficeService {

	public List<PostOfficeDTO> fetchPostOffices(final JqGridSearchDTO searchDTO);

	public void addPostOffice(PostOfficeDTO agentDTO);

	public void updatePostOffice(PostOfficeDTO agentDTO);

	public void deletePostOffice(PostOfficeDTO agentDTO);
}
