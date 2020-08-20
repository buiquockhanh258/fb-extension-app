/**
 * 
 */
package com.extension.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author KhanhBQ3
 *
 */
@Document
public class Applicationkey {
	@Id
	private String id;
	private String deviceName;
	private String key;
	private boolean activated;
	private Date activatedDate;
	private Date endDate;

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * @return the activatedDate
	 */
	public Date getActivatedDate() {
		return activatedDate;
	}

	/**
	 * @param activatedDate the activatedDate to set
	 */
	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Applicationkey(String deviceName, String key, boolean activated, Date activatedDate, Date endDate) {
		this.deviceName = deviceName;
		this.key = key;
		this.activated = activated;
		this.activatedDate = activatedDate;
		this.endDate = endDate;
	}

	public Applicationkey() {
	}

	@Override
	public String toString() {
		return "Applicationkey [id=" + id + ", deviceName=" + deviceName + ", key=" + key + ", activated=" + activated
				+ ", activatedDate=" + activatedDate + ", endDate=" + endDate + "]";
	}

}
