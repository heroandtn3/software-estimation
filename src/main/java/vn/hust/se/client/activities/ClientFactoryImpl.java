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

import vn.hust.se.client.activities.home.HomeView;
import vn.hust.se.client.activities.home.HomeViewGwt;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * @author heroandtn3
 *
 */
public class ClientFactoryImpl implements ClientFactory {

	private SimpleEventBus eventBus;
	private PlaceController placeController;
	private HomeView homeView;

	/**
	 * 
	 */
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
	}

	@Override
	public PlaceController getPlaceController() {
		if (placeController == null) {
			placeController = new PlaceController(eventBus);
		}
		return placeController;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public HomeView getHomeView() {
		if (homeView == null) {
			homeView = new HomeViewGwt();
		}
		return homeView;
	}

}
