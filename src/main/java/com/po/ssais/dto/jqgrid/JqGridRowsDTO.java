package com.po.ssais.dto.jqgrid;

import java.io.Serializable;

/**
 * @author Murali
 * 
 * @param <T>
 */
public class JqGridRowsDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private T cell;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the cell
	 */
	public T getCell() {
		return cell;
	}

	/**
	 * @param cell
	 *            the cell to set
	 */
	public void setCell(T cell) {
		this.cell = cell;
	}
}
