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

import vn.hust.se.client.activities.ClientFactory;
import vn.hust.se.client.activities.base.BaseActivity;
import vn.hust.se.client.service.DataService;
import vn.hust.se.shared.model.Project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
		
		DataService.pDb.getAllProject(new AsyncCallback<List<Project>>() {
			
			@Override
			public void onSuccess(List<Project> result) {
				view.showProjects(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
		
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
