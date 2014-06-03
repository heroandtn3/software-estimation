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

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public interface ProjectServiceAsync {

	void deletePhase(Long phaseId, AsyncCallback<Void> callback);

	void deleteProject(Long projectId, AsyncCallback<Void> callback);

	void insertPhase(Phase phase, AsyncCallback<Void> callback);

	void insertProject(Project project, AsyncCallback<Void> callback);

	void renameProject(Long projectId, String newName,
			AsyncCallback<Void> callback);

	void updatePhase(Phase phase, AsyncCallback<Void> callback);

	void getAllProject(AsyncCallback<List<Project>> callback);

}
