/**
 * 
 */
package com.po.ssais.dto.jqgrid;

import java.io.Serializable;

/**
 * @author Murali
 * 
 */
public class JqGridSearchDTO implements Serializable {

	private boolean _search;
	private int page;
	private int rows;
	private String searchField;
	private String searchOper;
	private String searchString;
	private String sord;
	private long total;

	public JqGridSearchDTO(boolean _search, int page, int rows,
			String searchField, String searchOper, String searchString,
			String sord) {
		this._search = _search;
		this.page = page;
		this.rows = rows;
		this.searchField = searchField;
		this.searchOper = searchOper;
		this.searchString = searchString;
		this.sord = sord;
	}

	/**
	 * @return the _search
	 */
	public boolean is_search() {
		return _search;
	}

	/**
	 * @param _search
	 *            the _search to set
	 */
	public void set_search(boolean _search) {
		this._search = _search;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the searchField
	 */
	public String getSearchField() {
		return searchField;
	}

	/**
	 * @param searchField
	 *            the searchField to set
	 */
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	/**
	 * @return the searchOper
	 */
	public String getSearchOper() {
		return searchOper;
	}

	/**
	 * @param searchOper
	 *            the searchOper to set
	 */
	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param searchString
	 *            the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * @return the sord
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord
	 *            the sord to set
	 */
	public void setSord(String sord) {
		this.sord = sord;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

}
