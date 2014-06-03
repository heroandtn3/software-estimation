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
package vn.hust.se.client.service;

import java.util.List;

import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */

@RemoteServiceRelativePath("projectService")
public interface ProjectService extends RemoteService {
	
	// Project
	
	List<Project> getAllProject();
	
	void insertProject(Project project);
	
	void deleteProject(Long projectId);
	
	void renameProject(Long projectId, String newName);
	
	// Phase
	
	void insertPhase(Phase phase);
	
	void deletePhase(Long phaseId);
	
	void updatePhase(Phase phase);

}
