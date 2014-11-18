package org.connect.impl.scheduler;

import org.connect.api.scheduler.ConnectRunnable;

public class HashMapFriendlier {

	private ConnectRunnable runnable;
	private int id;

	public HashMapFriendlier(ConnectRunnable runnable, int id) {
		this.runnable = runnable;
		this.id = id;
	}

	public ConnectRunnable getRunnable() {
		return runnable;
	}

	public int getId() {
		return id;
	}

}
