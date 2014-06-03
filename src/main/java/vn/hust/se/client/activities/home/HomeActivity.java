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
import vn.hust.se.client.event.RefreshPhaseEvent;
import vn.hust.se.client.event.RefreshPhaseHandler;
import vn.hust.se.client.event.RefreshProjectEvent;
import vn.hust.se.client.event.RefreshProjectHandler;
import vn.hust.se.client.service.DataService;
import vn.hust.se.client.view.ConfirmDialog.ConfirmCallback;
import vn.hust.se.shared.model.Phase;
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
		
		
		
		addHandlerRegistration(view.getAddProjectBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				view.getProjectModal().newProject();
			}
		}));
		
		addHandlerRegistration(view.getEditProjectBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Project selectedProject = view.getSelectedProject();
				if (selectedProject != null) {
					view.getProjectModal().editProject(selectedProject);
				}
			}
		}));
		
		addHandlerRegistration(view.getAddPhaseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Project selectedProject = view.getSelectedProject();
				if (selectedProject != null) {
					view.getPhaseModal().addPhase(selectedProject);
				}
				
			}
		}));
		
		addHandlerRegistration(view.getDelPhaseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final Phase selectedPhase = view.getSelectedPhase();
				if (selectedPhase != null) {
					view.getConfirmDialog().confirm(
							"Xóa giai đoạn\"" + selectedPhase.getName() + "\"?", 
							new ConfirmCallback() {

								@Override
								public void onOk() {
									DataService.pDb.deletePhase(selectedPhase.getId(), new AsyncCallback<Void>() {

										@Override
										public void onFailure(Throwable caught) {
										}

										@Override
										public void onSuccess(Void result) {
											showPhases(view.getSelectedProject());
										}
									});
									
								}

								@Override
								public void onCancel() {
								}});
				}
			}
		}));
		
		addHandlerRegistration(view.getDelProjectBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final Project selectedProject = view.getSelectedProject();
				if (selectedProject != null) {
					view.getConfirmDialog().confirm(
							"Xóa dự án\"" + selectedProject.getName() + "\"?", 
							new ConfirmCallback() {

								@Override
								public void onOk() {
									DataService.pDb.deleteProject(
											selectedProject.getId(), new AsyncCallback<Void>() {
												@Override
												public void onFailure(Throwable caught) {
													caught.printStackTrace();
												}

												@Override
												public void onSuccess(Void result) {
													showProjects();
													showPhases(null);
												}});
								}

								@Override
								public void onCancel() {
								}});
					
				}
			}
		}));
		
		addHandlerRegistration(view.getEditPhaseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Phase selectedPhase = view.getSelectedPhase();
				if (selectedPhase != null) {
					view.getPhaseModal().editPhase(selectedPhase);
				}
			}
		}));
		
		addHandlerRegistration(eventBus.addHandler(
				RefreshProjectEvent.TYPE, new RefreshProjectHandler() {
					
					@Override
					public void onRefresh(RefreshProjectEvent event) {
						showProjects();
					}
				}));
		
		addHandlerRegistration(eventBus.addHandler(
				RefreshPhaseEvent.TYPE, new RefreshPhaseHandler() {
					
					@Override
					public void onRefresh(RefreshPhaseEvent event) {
						showPhases(view.getSelectedProject());
					}
				}));
		
		// show projects first time
		showProjects();
		
	}
	
	private void showProjects() {
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
	}
	
	private void showPhases(Project project) {
		if (project != null) {
			DataService.pDb.getPhasesByProject(
					project.getId(), new AsyncCallback<List<Phase>>() {
						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							view.showPhases(new ArrayList<Phase>());
						}

						@Override
						public void onSuccess(List<Phase> result) {
							view.showPhases(result);
						}
					});
		} else {
			view.showPhases(new ArrayList<Phase>());
		}
		
	}
	
	@Override
	public void onStop() {
		super.onStop();
		view.clearContent();
	}

}
