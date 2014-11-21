package org.connect.impl.plugin;

import org.connect.api.event.IEvent;

public class Event implements IEvent {

	private String name = null;

	@Override
	public String getName() {
		return name != null ? name : getClass().getName();
	}

}
