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
package vn.hust.se.server;

import java.util.ArrayList;
import java.util.List;

import vn.hust.se.client.service.ProjectService;
import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;
import static com.googlecode.objectify.ObjectifyService.ofy;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public class ProjectServiceImpl extends RemoteServiceServlet implements ProjectService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		ObjectifyService.register(Project.class);
		ObjectifyService.register(Phase.class);
	}

	/**
	 * 
	 */
	public ProjectServiceImpl() {
	}
	
	@Override
	public List<Project> getAllProject() {
		List<Project> projects = ofy().load().type(Project.class).list();
		return new ArrayList<Project>(projects);
	}

	@Override
	public void insertProject(Project project) {
		ofy().save().entity(project).now();
	}

	@Override
	public void deleteProject(Long projectId) {
		ofy().delete().type(Project.class).id(projectId).now();
	}

	@Override
	public void renameProject(Long projectId, String newName) {
		Project project = ofy().load().type(Project.class).id(projectId).now();
		project.setName(newName);
		ofy().save().entity(project).now();
		
	}

	@Override
	public void insertPhase(Phase phase) {
		ofy().save().entity(phase).now();
	}

	@Override
	public void deletePhase(Long phaseId) {
		ofy().delete().type(Phase.class).id(phaseId).now();
	}

	@Override
	public void updatePhase(Phase phase) {
		ofy().save().entity(phase).now();
	}

}
