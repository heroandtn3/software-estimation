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
package vn.hust.se.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author heroandtn3
 * @date Jun 3, 2014
 */
public class PhaseModal extends Composite implements HasText {

	private static PhaseModalUiBinder uiBinder = GWT
			.create(PhaseModalUiBinder.class);

	interface PhaseModalUiBinder extends UiBinder<Widget, PhaseModal> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public PhaseModal() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public PhaseModal(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	/**
	 * Gets invoked when the default constructor is called
	 * and a string is provided in the ui.xml file.
	 */
	public String getText() {
		return button.getText();
	}

}
