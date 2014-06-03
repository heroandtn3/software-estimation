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
package vn.hust.se.client.activities.base;

import java.util.LinkedList;

import vn.hust.se.client.activities.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author heroandtn3
 * @date May 5, 2014
 */
public class BaseActivity extends AbstractActivity {

	private LinkedList<HandlerRegistration> oldHandlers;
	private LinkedList<com.google.web.bindery.event.shared.HandlerRegistration> handlers;
	protected ClientFactory clientFactory;

	/**
	 * 
	 */
	
	public BaseActivity(ClientFactory clientFactory) {
		oldHandlers = new LinkedList<HandlerRegistration>();
		handlers = new LinkedList<com.google.web.bindery.event.shared.HandlerRegistration>();
		this.clientFactory = clientFactory;
		
	}
	
	protected final void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	/**
	 * add a {@link HandlerRegistration} to the handler collection
	 * 
	 * @param handlerRegistration
	 *            a {@link com.google.gwt.event.shared.HandlerRegistration}
	 *            object.
	 */
	protected void addHandlerRegistration(
			com.google.web.bindery.event.shared.HandlerRegistration handlerRegistration) {
		handlers.add(handlerRegistration);
	}

	/**
	 * add a {@link HandlerRegistration} to the handler collection
	 * 
	 * @param handlerRegistration
	 *            a {@link com.google.gwt.event.shared.HandlerRegistration}
	 *            object.
	 */
	protected void addHandlerRegistration(
			HandlerRegistration handlerRegistration) {
		oldHandlers.add(handlerRegistration);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * onStop is overriden to automatically clear all
	 * {@link HandlerRegistration}
	 */
	@Override
	public void onStop() {
		super.onStop();

		cancelAllHandlerRegistrations();
	}

	/**
	 * Remove all collected oldHandlers, and remove them from the collection
	 */
	protected void cancelAllHandlerRegistrations() {
		for (HandlerRegistration hr : oldHandlers) {
			hr.removeHandler();
		}
		oldHandlers.clear();

		for (com.google.web.bindery.event.shared.HandlerRegistration hr : handlers) {
			hr.removeHandler();
		}
		handlers.clear();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		start(panel, (com.google.web.bindery.event.shared.EventBus) eventBus);
	}

	public void start(AcceptsOneWidget panel,
			com.google.web.bindery.event.shared.EventBus eventBus) {
	}

}
