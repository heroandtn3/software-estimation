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

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author heroandtn3
 * @date Jun 4, 2014
 */
public class ConfirmDialog extends Composite {

	private static ConfirmDialogUiBinder uiBinder = GWT
			.create(ConfirmDialogUiBinder.class);

	interface ConfirmDialogUiBinder extends UiBinder<Widget, ConfirmDialog> {
	}
	
	public static interface ConfirmCallback {
		void onOk();
		
		void onCancel();
	}
	
	@UiField Modal modal;
	@UiField Heading message;
	@UiField Button okBtn;
	@UiField Button cancelBtn;
	private ConfirmCallback callback;

	public ConfirmDialog() {
		initWidget(uiBinder.createAndBindUi(this));
		
		okBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (callback != null) {
					callback.onOk();
					hide();
				}
			}
		});
		
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (callback != null) {
					callback.onCancel();
					hide();
				}
			}
		});
	}
	
	public void confirm(String msg, ConfirmCallback callback) {
		this.callback = callback;
		message.setText(msg);
		modal.show();
	}

	public void hide() {
		modal.hide();
	}
}
