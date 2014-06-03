package vn.hust.se.client;

import vn.hust.se.client.activities.AppActivityMapper;
import vn.hust.se.client.activities.AppPlaceHistoryMapper;
import vn.hust.se.client.activities.ClientFactory;
import vn.hust.se.client.activities.ClientFactoryImpl;
import vn.hust.se.client.activities.home.HomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class SoftwareEstimation implements EntryPoint {
	
	public static ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);
	private SimplePanel appWidget = new SimplePanel();

	@Override
	public void onModuleLoad() {
		start();
	}
	
	private void start() {
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);
		
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		
		historyHandler.register(placeController, eventBus, new HomePlace());
		
		RootPanel.get().add(appWidget);
		
		historyHandler.handleCurrentHistory();
	}
}
