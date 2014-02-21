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
public class AgentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String registerationNo;

	@JsonSerialize(using = SsaisDateSerializer.class)
	@JsonDeserialize(using = SsaisDateDeserializer.class)
	private Date registerDate;

	@JsonSerialize(using = SsaisDateSerializer.class)
	@JsonDeserialize(using = SsaisDateDeserializer.class)
	private Date expiredDate;
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
	 * @return the registerationNo
	 */
	public String getRegisterationNo() {
		return registerationNo;
	}

	/**
	 * @param registerationNo
	 *            the registerationNo to set
	 */
	public void setRegisterationNo(String registerationNo) {
		this.registerationNo = registerationNo;
	}

	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate
	 *            the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the expiredDate
	 */
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	 * @param expiredDate
	 *            the expiredDate to set
	 */
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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
