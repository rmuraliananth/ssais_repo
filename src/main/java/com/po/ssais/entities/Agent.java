package com.po.ssais.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="crt_tsp")
	private Date crtTsp;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="expired_date")
	private Date expiredDate;

	private String name;

    @Temporal( TemporalType.DATE)
	@Column(name="register_date")
	private Date registerDate;

	@Column(name="registeration_no")
	private String registerationNo;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="upt_tsp")
	private Date uptTsp;

    public Agent() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCrtTsp() {
		return this.crtTsp;
	}

	public void setCrtTsp(Date crtTsp) {
		this.crtTsp = crtTsp;
	}

	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterationNo() {
		return this.registerationNo;
	}

	public void setRegisterationNo(String registerationNo) {
		this.registerationNo = registerationNo;
	}

	public Date getUptTsp() {
		return this.uptTsp;
	}

	public void setUptTsp(Date uptTsp) {
		this.uptTsp = uptTsp;
	}

}