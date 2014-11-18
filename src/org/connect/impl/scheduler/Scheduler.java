package org.connect.impl.scheduler;

import java.util.HashMap;
import java.util.Iterator;

import org.connect.api.plugin.PluginBase;
import org.connect.api.scheduler.ConnectRunnable;
import org.connect.api.scheduler.IScheduler;

public class Scheduler implements IScheduler {

	private HashMap<HashMapFriendlier, PluginBase> tasks = new HashMap<>();

	@Override
	public void cancelAllTasks() {
		tasks.clear();
	}

	@Override
	public void cancelTask(int id) {
		Iterator<HashMapFriendlier> ks = tasks.keySet().iterator();
		int i = 0;
		while (ks.hasNext()) {
			i++;
			if (ks.next().getId() == id) {
				return;
			}
		}
	}

	@Override
	public void cancelTask(PluginBase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int runAsyncDelayedTask(PluginBase arg0, ConnectRunnable arg1,
			long arg2) {
		return 0;
	}

	@Override
	public int runAsyncRepeatingTask(PluginBase arg0, ConnectRunnable arg1,
			long arg2, long arg3) {
		return 0;
	}

	@Override
	public int runSyncDelayedTask(PluginBase arg0, ConnectRunnable arg1,
			long arg2) {
		return 0;
	}

	@Override
	public int runSyncRepeatingTask(PluginBase arg0, ConnectRunnable arg1,
			long arg2, long arg3) {
		return 0;
	}

}
