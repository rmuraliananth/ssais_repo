package com.po.ssais.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the post_office database table.
 * 
 */
@Entity
@Table(name="post_office")
public class PostOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	private String branch;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="crt_tsp")
	private Date crtTsp;

	private String name;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="upt_tsp")
	private Date uptTsp;

    public PostOffice() {
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

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getCrtTsp() {
		return this.crtTsp;
	}

	public void setCrtTsp(Date crtTsp) {
		this.crtTsp = crtTsp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUptTsp() {
		return this.uptTsp;
	}

	public void setUptTsp(Date uptTsp) {
		this.uptTsp = uptTsp;
	}

}