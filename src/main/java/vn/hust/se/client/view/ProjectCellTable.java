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
package vn.hust.se.client.view;

import java.util.List;

import org.gwtbootstrap3.client.ui.CellTable;

import vn.hust.se.shared.model.Project;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public class ProjectCellTable extends Composite {

	private ListDataProvider<Project> dataProvider;
	private CellTable<Project> table;
	private SingleSelectionModel<Project> selectionModel;

	/**
	 * 
	 */
	public ProjectCellTable() {
		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		initWidget(panel);
		
		table = new CellTable<Project>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		dataProvider = new ListDataProvider<Project>();
		dataProvider.addDataDisplay(table);
		
		selectionModel = new SingleSelectionModel<Project>();
		table.setSelectionModel(selectionModel);
		
		SimplePager.Resources paResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, paResources, true, 0, true);
		pager.setDisplay(table);
		pager.setPageSize(5);
		
		panel.add(table);
		panel.add(pager);
		panel.setCellHorizontalAlignment(pager, HasHorizontalAlignment.ALIGN_CENTER);
		
		TextColumn<Project> nameColumn = new TextColumn<Project>() {
			@Override
			public String getValue(Project object) {
				return object.getName();
			}
		};
		table.addColumn(nameColumn, "Dự án");
		
		Column<Project, Number> totalRevenueColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTotalRevenue();
			}
		};
		table.addColumn(totalRevenueColumn, "Tổng thu");
		
		Column<Project, Number> totalPayColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTotalPay();
			}
		};
		table.addColumn(totalPayColumn, "Tổng chi");
		
		Column<Project, Number> totalFvColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTotalFv();
			}
		};
		table.addColumn(totalFvColumn, "Tổng FV");
		
		Column<Project, Number> totalPvColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTotalPv();
			}
		};
		
		table.addColumn(totalPvColumn, "Tổng PV");
		
		Column<Project, Number> NpvColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getNpv();
			}
		};
		
		table.addColumn(NpvColumn, "NPV");
		
		Column<Project, Number> IrrColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getIrr();
			}
		};
		
		table.addColumn(IrrColumn, "IRR");
		
		Column<Project, Number> totalRoiColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTotalRoi();
			}
		};
		
		table.addColumn(totalRoiColumn, "Tổng ROI");
		
		Column<Project, Number> laiTichLuyColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTienLaiTichLuy();
			}
		};
		
		table.addColumn(laiTichLuyColumn, "Lưu lượng tiền lãi tích lũy");
		
		Column<Project, Number> timeHoanVonColumn = new Column<Project, Number>(new NumberCell()) {
			@Override
			public Number getValue(Project object) {
				return object.getTimeHoanVon();
			}
		};
		
		table.addColumn(timeHoanVonColumn, "Thời gian hoàn vốn");
		
		
	}

	public void render(List<Project> projects) {
		dataProvider.getList().clear();
		dataProvider.getList().addAll(projects);
		dataProvider.flush();
		dataProvider.refresh();
		table.redraw();
	}

	public void addProject(Project project) {
		// TODO Auto-generated method stub
		
	}
	
	public SingleSelectionModel<Project> getSelectionModel() {
		return selectionModel;
	}

}
