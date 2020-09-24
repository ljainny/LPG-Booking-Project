/**
 * 
 */
package com.capgemini.lpg.dto;

import java.time.LocalDate;

/**
 * @author Smita
 *
 */
public class LPGStock {
	private int avQty;
	private LocalDate receivedDate;
	private String updatedBy;
	private String location;
	public LPGStock() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the avQty
	 */
	public int getAvQty() {
		return avQty;
	}
	/**
	 * @param avQty the avQty to set
	 */
	public void setAvQty(int avQty) {
		this.avQty = avQty;
	}
	/**
	 * @return the receivedDate
	 */
	public LocalDate getReceivedDate() {
		return receivedDate;
	}
	/**
	 * @param receivedDate the receivedDate to set
	 */
	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}
