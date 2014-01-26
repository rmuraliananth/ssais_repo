package com.po.ssais.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_account database table.
 * 
 */
@Entity
@Table(name="customer_account")
public class CustomerAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    public CustomerAccount() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}