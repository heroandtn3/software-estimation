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
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

/**
 * @author heroandtn3
 * @date Jun 2, 2014
 */

@Entity
public class Project implements Serializable, IsSerializable {
	
	/**
	 * 
	 */
	@Ignore private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	
	@Ignore
	private float npv;
	@Ignore
	private float irr;
	private float tienLaiTichLuy;
	@Ignore
	private float timeHoanVon;

	// list of phases
	@Ignore
	private List<Phase> phases;

	// total from phases
	@Ignore
	private float totalRevenue; // tong thu
	@Ignore
	private float totalPay; // tong chi
	@Ignore
	private float totalFv;
	@Ignore
	private float totalPv;
	@Ignore
	private float totalRoi;

	/**
	 * 
	 */
	public Project() {
		phases = new ArrayList<Phase>();
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

	public float getNpv() {
		return npv;
	}

	public void setNpv(float npv) {
		this.npv = npv;
	}

	public float getIrr() {
		return irr;
	}

	public void setIrr(float irr) {
		this.irr = irr;
	}

	public float getTienLaiTichLuy() {
		return tienLaiTichLuy;
	}

	public void setTienLaiTichLuy(float tienLaiTichLuy) {
		this.tienLaiTichLuy = tienLaiTichLuy;
	}

	public float getTimeHoanVon() {
		return timeHoanVon;
	}

	public void setTimeHoanVon(float timeHoanVon) {
		this.timeHoanVon = timeHoanVon;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public float getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public float getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(float totalPay) {
		this.totalPay = totalPay;
	}

	public float getTotalFv() {
		return totalFv;
	}

	public void setTotalFv(float totalFv) {
		this.totalFv = totalFv;
	}

	public float getTotalPv() {
		return totalPv;
	}

	public void setTotalPv(float totalPv) {
		this.totalPv = totalPv;
	}

	public float getTotalRoi() {
		return totalRoi;
	}

	public void setTotalRoi(float totalRoi) {
		this.totalRoi = totalRoi;
	}
}
