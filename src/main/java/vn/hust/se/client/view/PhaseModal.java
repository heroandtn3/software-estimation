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

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;

import vn.hust.se.client.SoftwareEstimation;
import vn.hust.se.client.event.RefreshPhaseEvent;
import vn.hust.se.client.service.DataService;
import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public class PhaseModal extends Composite {

	private static PhaseModalUiBinder uiBinder = GWT
			.create(PhaseModalUiBinder.class);

	interface PhaseModalUiBinder extends UiBinder<Widget, PhaseModal> {
	}
	
	@UiField Modal modal;
	@UiField Heading title;
	@UiField Button updateBtn;
	@UiField Button createBtn;
	@UiField TextBox nameTb;
	@UiField TextBox revenueTb;
	@UiField TextBox payTb;
	@UiField TextBox rateTb;
	@UiField Alert alertPanel;
	@UiField HTML alertMsg;
	private Project project;
	private Phase phase;

	
	public PhaseModal() {
		initWidget(uiBinder.createAndBindUi(this));
		
		alertPanel.setVisible(false);
		createBtn.setVisible(false);
		updateBtn.setVisible(false);
		
		createBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final Phase phase = new Phase();
				phase.setName(nameTb.getText());
				phase.setRevenue(Float.parseFloat(revenueTb.getText()));
				phase.setPay(Float.parseFloat(payTb.getText()));
				phase.setR(Float.parseFloat(rateTb.getText()));
				phase.setOrder(project.getPhases().size());
				phase.setProjectId(project.getId());
				
				createBtn.setEnabled(false);
				DataService.pDb.insertPhase(phase, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						createBtn.setEnabled(true);
						project.getPhases().add(phase);
						modal.hide();
						SoftwareEstimation.clientFactory.getEventBus().fireEvent(new RefreshPhaseEvent());
					}
					
					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
						createBtn.setEnabled(true);
					}
				});
			}
		});
		
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				phase.setName(nameTb.getText());
				phase.setRevenue(Float.parseFloat(revenueTb.getText()));
				phase.setPay(Float.parseFloat(payTb.getText()));
				phase.setR(Float.parseFloat(rateTb.getText()));
				
				updateBtn.setEnabled(false);
				DataService.pDb.updatePhase(phase, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						updateBtn.setEnabled(true);
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Void result) {
						updateBtn.setEnabled(true);
						modal.hide();
						SoftwareEstimation.clientFactory.getEventBus().fireEvent(new RefreshPhaseEvent());
					}
				});
			}
		});
	}
	
	public void addPhase(Project project) {
		this.project = project;
		title.setText("Thêm giai đoạn");
		createBtn.setVisible(true);
		updateBtn.setVisible(false);
		nameTb.setText("");
		revenueTb.setText("");
		payTb.setText("");
		rateTb.setText("");
		modal.show();
		
	}
	
	public void editPhase(Phase phase) {
		this.phase = phase;
		title.setText("Sửa giai đoạn");
		createBtn.setVisible(false);
		updateBtn.setVisible(true);
		
		nameTb.setText(phase.getName());
		revenueTb.setText(phase.getRevenue() + "");
		payTb.setText(phase.getPay() + "");
		rateTb.setText(phase.getR() + "");
		
		modal.show();
	}

}
