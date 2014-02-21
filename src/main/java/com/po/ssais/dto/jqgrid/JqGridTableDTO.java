/**
 * 
 */
package com.po.ssais.dto.jqgrid;

import java.io.Serializable;
import java.util.List;

/**
 * @author Murali
 * 
 */
public class JqGridTableDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String page;
	private String total;
	private String records;
	private List<T> rows;
	private List<T> userdata;

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return the records
	 */
	public String getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            the records to set
	 */
	public void setRecords(String records) {
		this.records = records;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * @return the userdata
	 */
	public List<T> getUserdata() {
		return userdata;
	}

	/**
	 * @param userdata
	 *            the userdata to set
	 */
	public void setUserdata(List<T> userdata) {
		this.userdata = userdata;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
