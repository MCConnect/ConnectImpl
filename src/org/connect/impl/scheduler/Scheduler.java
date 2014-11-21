package org.connect.impl.scheduler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.connect.api.plugin.PluginBase;
import org.connect.api.scheduler.ConnectRunnable;
import org.connect.api.scheduler.IScheduler;

public class Scheduler implements IScheduler {

	private HashMap<Integer, HashMapFriendlier> tasks = new HashMap<>();

	@Override
	public void cancelAllTasks() {
		tasks.clear();
	}

	@Override
	public void cancelTask(int id) {
		for (Entry<Integer, HashMapFriendlier> pair : tasks.entrySet()) {
			int fId = pair.getKey();
			HashMapFriendlier hsf = pair.getValue();
			
			if (id == fId) {
				tasks.remove(fId);
				return;
			}
		}
	}

	@Override
	public void cancelTask(PluginBase plugin) {
		for (Entry<Integer, HashMapFriendlier> pair : tasks.entrySet()) {
			int fId = pair.getKey();
			HashMapFriendlier hsf = pair.getValue();
			
			if (hsf.getPlugin().getName().equalsIgnoreCase(plugin.getName())) {
				tasks.remove(fId);
				return;
			}
		}
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
