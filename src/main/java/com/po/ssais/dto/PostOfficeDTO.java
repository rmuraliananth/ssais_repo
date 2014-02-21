/**
 * 
 */
package com.po.ssais.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Murali
 * 
 */
public class PostOfficeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String branch;
	private String address;
	private Date crtTsp;
	private Date uptTsp;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the crtTsp
	 */
	public Date getCrtTsp() {
		return crtTsp;
	}

	/**
	 * @param crtTsp
	 *            the crtTsp to set
	 */
	public void setCrtTsp(Date crtTsp) {
		this.crtTsp = crtTsp;
	}

	/**
	 * @return the uptTsp
	 */
	public Date getUptTsp() {
		return uptTsp;
	}

	/**
	 * @param uptTsp
	 *            the uptTsp to set
	 */
	public void setUptTsp(Date uptTsp) {
		this.uptTsp = uptTsp;
	}

}
