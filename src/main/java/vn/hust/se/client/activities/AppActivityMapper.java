/*
 * Copyright 2013 heroandtn3 (heroandtn3 [at] gmail.com) 
 * 
 * This file is part of QuizgameAdmin.
 * QuizgameAdmin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * QuizgameAdmin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with QuizgameAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * 
 */
package vn.hust.se.client.activities;

import vn.hust.se.client.activities.home.HomeActivity;
import vn.hust.se.client.activities.home.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * @author heroandtn3
 *
 */
public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * 
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new HomeActivity(clientFactory);
		}
		
		return null;
	}

}
