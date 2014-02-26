/**
 * 
 */
package com.po.ssais.dto;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.po.ssais.util.json.deserializer.SsaisDateDeserializer;
import com.po.ssais.util.json.serializer.SsaisDateSerializer;

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
	private String name;

	@JsonSerialize(using = SsaisDateSerializer.class)
	@JsonDeserialize(using = SsaisDateDeserializer.class)
	private Date openDate;

	@JsonSerialize(using = SsaisDateSerializer.class)
	@JsonDeserialize(using = SsaisDateDeserializer.class)
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

}
