package com.po.ssais.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crt_tsp")
	private Date crtTsp;

	@Column(name = "email_id")
	private String emailId;

	private String name;

	@Column(name = "phone_no")
	private String phoneNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upt_tsp")
	private Date uptTsp;

	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Account> accounts;

	public Customer() {
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getUptTsp() {
		return this.uptTsp;
	}

	public void setUptTsp(Date uptTsp) {
		this.uptTsp = uptTsp;
	}

	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}