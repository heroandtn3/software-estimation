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

import vn.hust.se.client.model.Phase;

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
public class PhaseCellTable extends Composite {
	
	private ListDataProvider<Phase> dataProvider;
	private CellTable<Phase> table;
	private SingleSelectionModel<Phase> selectionModel;

	/**
	 * 
	 */
	public PhaseCellTable() {

		VerticalPanel panel = new VerticalPanel();
		panel.setWidth("100%");
		initWidget(panel);
		
		table = new CellTable<Phase>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		dataProvider = new ListDataProvider<Phase>();
		dataProvider.addDataDisplay(table);
		
		selectionModel = new SingleSelectionModel<Phase>();
		table.setSelectionModel(selectionModel);
		
		SimplePager.Resources paResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, paResources, true, 0, true);
		pager.setDisplay(table);
		pager.setPageSize(5);
		
		panel.add(table);
		panel.add(pager);
		panel.setCellHorizontalAlignment(pager, HasHorizontalAlignment.ALIGN_CENTER);
		
		TextColumn<Phase> nameColumn = new TextColumn<Phase>() {
			@Override
			public String getValue(Phase object) {
				return object.getName();
			}
		};
		table.addColumn(nameColumn, "Giai đoạn");
		
		Column<Phase, Number> revenueColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getRevenue();
			}
		};
		table.addColumn(revenueColumn, "Thu");
		
		Column<Phase, Number> payColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getPay();
			}
		};
		table.addColumn(payColumn, "Chi");
		
		Column<Phase, Number> rColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getR();
			}
		};
		table.addColumn(rColumn, "R (Lãi suất)");
		
		Column<Phase, Number> pvColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getPv();
			}
		};
		
		table.addColumn(pvColumn, "PV");
		
		Column<Phase, Number> fvColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getFv();
			}
		};
		
		table.addColumn(fvColumn, "FV");
		
		Column<Phase, Number> roiColumn = new Column<Phase, Number>(new NumberCell()) {
			@Override
			public Number getValue(Phase object) {
				return object.getRoi();
			}
		};
		
		table.addColumn(roiColumn, "ROI");
	
	}
	
	public void render(List<Phase> phases) {
		dataProvider.getList().clear();
		dataProvider.getList().addAll(phases);
		dataProvider.flush();
		dataProvider.refresh();
		table.redraw();
	}
	
	public SingleSelectionModel<Phase> getSelectionModel() {
		return selectionModel;
	}

}
