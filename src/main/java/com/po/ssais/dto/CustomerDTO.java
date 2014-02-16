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
public class CustomerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String emailId;
	private String phoneNo;
	private String address;
	private Date crtTsp;
	private Date uptTsp;

	private AccountDTO account;

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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	/**
	 * @return the account
	 */
	public AccountDTO getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
}
