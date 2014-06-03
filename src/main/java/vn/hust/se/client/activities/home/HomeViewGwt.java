/*
 * Copyright 2014 heroandtn3
 * 
 * This file is part of b-aoe.
 * b-aoe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * b-aoe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with b-aoe.  If not, see <http://www.gnu.org/licenses/>.
 */
package vn.hust.se.client.activities.home;

import java.util.List;

import org.gwtbootstrap3.client.ui.Button;

import vn.hust.se.client.activities.base.BaseViewGwt;
import vn.hust.se.client.model.Phase;
import vn.hust.se.client.model.Project;
import vn.hust.se.client.view.PhaseCellTable;
import vn.hust.se.client.view.ProjectCellTable;
import vn.hust.se.client.view.ProjectModal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;

/**
 * @author heroandtn3
 * @date May 5, 2014
 */
public class HomeViewGwt extends BaseViewGwt implements HomeView {

	private static HomeViewGwtUiBinder uiBinder = GWT
			.create(HomeViewGwtUiBinder.class);

	interface HomeViewGwtUiBinder extends UiBinder<Widget, HomeViewGwt> {
	}
	
	@UiField ProjectCellTable projectTable;
	@UiField PhaseCellTable phaseTable;
	@UiField SpanElement projectDetailTitle;
	
	@UiField Button addProjectBtn;
	@UiField Button editProjectBtn;
	@UiField Button delProjectBtn;
	
	@UiField Button addPhaseBtn;
	@UiField Button editPhaseBtn;
	@UiField Button delPhaseBtn;
	
	
	private ProjectModal projectModal = new ProjectModal();

	public HomeViewGwt() {
		mainPanel.add(uiBinder.createAndBindUi(this));
		
		phaseTable.getSelectionModel().addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				Phase selectedPhase = phaseTable.getSelectionModel().getSelectedObject();
				if (selectedPhase != null) {
					Window.alert("Selected " + selectedPhase.getName());
				}
				
			}
		});
		
		projectTable.getSelectionModel().addSelectionChangeHandler(new Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				Project selectedProject = projectTable.getSelectionModel().getSelectedObject();
				if (selectedProject != null) {
					projectDetailTitle.setInnerText("Chi tiết dự án " + selectedProject.getName());
					showPhases(selectedProject.getPhases());
				}
			}
		});
	}
	
	@Override
	public void showProjects(List<Project> projects) {
		projectTable.render(projects);
	}

	@Override
	public void showPhases(List<Phase> phases) {
		phaseTable.render(phases);
	}

	@Override
	public HasClickHandlers getAddProjectBtn() {
		return addProjectBtn;
	}

	@Override
	public HasClickHandlers getDelProjectBtn() {
		return delProjectBtn;
	}

	@Override
	public HasClickHandlers getEditProjectBtn() {
		return editProjectBtn;
	}

	@Override
	public HasClickHandlers getAddPhaseBtn() {
		return addPhaseBtn;
	}

	@Override
	public HasClickHandlers getDelPhaseBtn() {
		return delPhaseBtn;
	}

	@Override
	public HasClickHandlers getEditPhaseBtn() {
		return editPhaseBtn;
	}
	
	@Override
	public ProjectModal getProjectModal() {
		return projectModal;
	}

}
