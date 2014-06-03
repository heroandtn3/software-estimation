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
import org.gwtbootstrap3.client.ui.constants.AlertType;

import vn.hust.se.client.service.DataService;
import vn.hust.se.shared.model.Project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public class ProjectModal extends Composite {

	private static ProjectModalUiBinder uiBinder = GWT
			.create(ProjectModalUiBinder.class);

	interface ProjectModalUiBinder extends UiBinder<Widget, ProjectModal> {
	}
	
	@UiField Modal modal;
	@UiField Heading title;
	@UiField Button updateBtn;
	@UiField Button createBtn;
	@UiField TextBox nameTb;
	@UiField Alert alertPanel;
	@UiField HTML alertMsg;

	
	public ProjectModal() {
		initWidget(uiBinder.createAndBindUi(this));
		alertPanel.setVisible(false);
		createBtn.setVisible(false);
		updateBtn.setVisible(false);
		
		createBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				alertPanel.setVisible(false);
				String name = nameTb.getText();
				if (name.isEmpty()) {
					alertPanel.setVisible(true);
					alertPanel.setType(AlertType.DANGER);
					alertMsg.setText("Name is empty");
				} else {
					createBtn.setEnabled(false);
					Project project = new Project();
					project.setName(name);
					DataService.pDb.insertProject(project, new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
							createBtn.setEnabled(true);
							modal.hide();
						}
						
						@Override
						public void onFailure(Throwable caught) {
							createBtn.setEnabled(true);
							Window.alert("Error");
							
						}
					});
					
				}
			}
		});
		
		updateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				alertPanel.setVisible(false);
				String name = nameTb.getText();
				if (name.isEmpty()) {
					alertPanel.setVisible(true);
					alertPanel.setType(AlertType.DANGER);
					alertMsg.setText("Name is empty");
				} else {
					alertPanel.setVisible(true);
					alertPanel.setType(AlertType.SUCCESS);
					alertMsg.setText("Updated");
				}
			}
		});
	}
	
	public void newProject() {
		title.setText("Thêm dự án");
		alertPanel.setVisible(false);
		createBtn.setVisible(true);
		updateBtn.setVisible(false);
		nameTb.setText("");
		modal.show();
	}
	
	public void editProject(Project project) {
		title.setText("Sửa dự án");
		alertPanel.setVisible(false);
		createBtn.setVisible(false);
		updateBtn.setVisible(true);
		modal.show();
	}

}
