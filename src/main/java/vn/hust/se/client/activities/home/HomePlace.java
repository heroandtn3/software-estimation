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

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author heroandtn3
 * @date May 5, 2014
 */
public class HomePlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public HomePlace getPlace(String token) {
			return new HomePlace();
		}

		@Override
		public String getToken(HomePlace place) {
			return "index";
		}
		
	}

}
