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
package vn.hust.se.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author heroandtn3
 * @date Jun 4, 2014
 */
public class RefreshPhaseEvent extends GwtEvent<RefreshPhaseHandler> {
	
	public final static Type<RefreshPhaseHandler> TYPE = new Type<RefreshPhaseHandler>();

	/**
	 * 
	 */
	public RefreshPhaseEvent() {
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<RefreshPhaseHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RefreshPhaseHandler handler) {
		handler.onRefresh(this);
	}

}
