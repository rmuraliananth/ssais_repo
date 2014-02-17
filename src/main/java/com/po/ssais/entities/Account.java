package com.po.ssais.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="account_no")
	private String accountNo;

	@Column(name="account_type")
	private String accountType;

	@Column(name="balance_amount")
	private BigDecimal balanceAmount;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="crt_tsp")
	private Date crtTsp;

    @Temporal( TemporalType.DATE)
	@Column(name="last_paid_date")
	private Date lastPaidDate;

    @Temporal( TemporalType.DATE)
	@Column(name="maturity_date")
	private Date maturityDate;

	private String name;

    @Temporal( TemporalType.DATE)
	@Column(name="open_date")
	private Date openDate;

	@Column(name="principal_amount")
	private BigDecimal principalAmount;

	@Column(name="rate_of_interest")
	private BigDecimal rateOfInterest;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="upt_tsp")
	private Date uptTsp;

	//bi-directional many-to-one association to Customer
    @ManyToOne
	private Customer customer;

    public Account() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalanceAmount() {
		return this.balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getCrtTsp() {
		return this.crtTsp;
	}

	public void setCrtTsp(Date crtTsp) {
		this.crtTsp = crtTsp;
	}

	public Date getLastPaidDate() {
		return this.lastPaidDate;
	}

	public void setLastPaidDate(Date lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}

	public Date getMaturityDate() {
		return this.maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public BigDecimal getPrincipalAmount() {
		return this.principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public BigDecimal getRateOfInterest() {
		return this.rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Date getUptTsp() {
		return this.uptTsp;
	}

	public void setUptTsp(Date uptTsp) {
		this.uptTsp = uptTsp;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}