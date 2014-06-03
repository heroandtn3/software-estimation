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

import java.util.ArrayList;
import java.util.List;

import vn.hust.se.client.activities.ClientFactory;
import vn.hust.se.client.activities.base.BaseActivity;
import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author heroandtn3
 * @date May 5, 2014
 */
public class HomeActivity extends BaseActivity {

	private HomeView view;

	/**
	 * 
	 */
	public HomeActivity(ClientFactory clientFactory) {
		super(clientFactory);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		panel.setWidget(view.asWidget());
		
		List<Project> projects = new ArrayList<Project>();
		for (int i = 0; i < 10; i++) {
			Project project = new Project();
			projects.add(project);
			
			project.setName("Du an "  + i);
			project.setIrr(i);
			
			List<Phase> phases = new ArrayList<Phase>();
			project.setPhases(phases);
			
			for (int j = 0; j < 5; j++) {
				Phase phase = new Phase();
				phases.add(phase);
				phase.setName("Giai doan " + j);
				phase.setRevenue(j);
			}
		}
		view.showProjects(projects);
		
		addHandlerRegistration(view.getAddProjectBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				view.getProjectModal().newProject();
			}
		}));
		
		addHandlerRegistration(view.getEditProjectBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				view.getProjectModal().editProject(null);
			}
		}));
		
	}
	
	
	@Override
	public void onStop() {
		super.onStop();
		view.clearContent();
	}

}
