/*
 * Copyright 2014 heroandtn3
 * 
 * This file is part of software-estimation.
 * software-estimation is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * software-estimation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with software-estimation.  If not, see <http://www.gnu.org/licenses/>.
 */
package vn.hust.se.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */

@Entity
public class Phase implements Serializable, IsSerializable {
	
	/**
	 * 
	 */
	@Ignore private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name; // ten giai doan
	private float revenue; // thu
	private float pay; // chi
	private float fv; // FV
	private float pv; // PV
	private float roi; // ROI
	private float r; // lai suat

	/**
	 * 
	 */
	public Phase() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

	public float getPay() {
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
	}

	public float getFv() {
		return fv;
	}

	public void setFv(float fv) {
		this.fv = fv;
	}

	public float getPv() {
		return pv;
	}

	public void setPv(float pv) {
		this.pv = pv;
	}

	public float getRoi() {
		return roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}
	
	

}
