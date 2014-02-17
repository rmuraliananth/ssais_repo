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
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String accountNo;
	private Double principalAmount;
	private Date openDate;
	private Date maturityDate;

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
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the principalAmount
	 */
	public Double getPrincipalAmount() {
		return principalAmount;
	}

	/**
	 * @param principalAmount
	 *            the principalAmount to set
	 */
	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate
	 *            the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate
	 *            the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

}
