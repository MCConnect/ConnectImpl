package org.connect.impl.scheduler;

import org.connect.api.plugin.Plugin;
import org.connect.api.plugin.PluginBase;
import org.connect.api.scheduler.ConnectRunnable;

public class HashMapFriendlier {

	private ConnectRunnable runnable;
	private PluginBase plugin;

	public HashMapFriendlier(ConnectRunnable runnable, PluginBase plugin) {
		this.runnable = runnable;
		this.plugin = plugin;
	}

	public ConnectRunnable getRunnable() {
		return runnable;
	}

	public PluginBase getPlugin() {
		return plugin;
	}

}
