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

import com.google.gwt.event.dom.client.HasClickHandlers;

import vn.hust.se.client.activities.base.BaseView;
import vn.hust.se.client.view.ProjectModal;
import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;

/**
 * @author heroandtn3
 * @date May 5, 2014
 */
public interface HomeView extends BaseView {
	
	void showProjects(List<Project> projects);
	
	void showPhases(List<Phase> phases);
	
	HasClickHandlers getAddProjectBtn();
	
	HasClickHandlers getDelProjectBtn();
	
	HasClickHandlers getEditProjectBtn();
	
	HasClickHandlers getAddPhaseBtn();
	
	HasClickHandlers getDelPhaseBtn();
	
	HasClickHandlers getEditPhaseBtn();
	
	ProjectModal getProjectModal();
	
}
