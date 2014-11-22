package org.connect.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.connect.api.ConnectAPI;
import org.connect.api.Gamemode;
import org.connect.api.ILogger;
import org.connect.api.Server;
import org.connect.api.entity.IOfflinePlayer;
import org.connect.api.entity.IPlayer;
import org.connect.api.permissions.IPermissionManager;
import org.connect.api.plugin.IPluginManager;
import org.connect.api.scheduler.IScheduler;
import org.connect.api.world.IWorld;
import org.connect.api.world.IWorldManager;
import org.connect.impl.entity.ConsoleSender;
import org.connect.impl.entity.OfflinePlayer;
import org.connect.impl.permissions.PermissionManager;
import org.connect.impl.plugin.PluginManager;
import org.connect.impl.world.WorldManager;

public class Connect extends ConnectImpl implements Server {

	private ConsoleSender consoleSender = new ConsoleSender();
	private ILogger logger = new Logger("ConnectLogger");
	private IPluginManager pm = new PluginManager();
	private IPermissionManager perm = new PermissionManager();
	private IWorldManager wm = new WorldManager();
	private File pluginsDir = new File("./plugins/");
	private Gamemode defaultGm = Gamemode.SURVIVAL;
	private String mcVer = "1.7.10";
	private boolean running = false;
	private ArrayList<IPlayer> onlinePlayers = new ArrayList<>();

	private ImplClass impl;

	public Connect(ImplClass implData) {
		impl = implData;
	}

	@Override
	public void broadcastMessage(String message) {
		impl.broadcastMessage(message);
	}

	@Override
	public IWorld getDefaultWorld() {
		return impl.getDefaultWorld();
	}

	@Override
	public String getIP() {
		return impl.getIP();
	}

	@Override
	public int getMaxPlayers() {
		return impl.getMaxPlayers();
	}

	@Override
	public String getName() {
		return "Connect Implementation";
	}

	private IPlayer getPlayerByName(String name) {
		for (IPlayer pl : onlinePlayers) {
			if (pl.getName().equalsIgnoreCase(name)) {
				return pl;
			}
		}
		return null;
	}

	@Override
	public IOfflinePlayer getOfflinePlayer(String name) {
		IPlayer pl = getPlayerByName(name);
		if (pl != null) {
			return pl;
		}
		return new IOfflinePlayer(name, null);
	}

	@Override
	public IOfflinePlayer getOfflinePlayer(UUID uuid) {
		return null;
	}

	@Override
	public ArrayList<IPlayer> getOnlinePlayers() {
		return null;
	}

	@Override
	public IPlayer getPlayer(String name) {
		return null;
	}

	@Override
	public IPlayer getPlayer(UUID uuid) {
		return null;
	}

	@Override
	public IPluginManager getPluginManager() {
		return pm;
	}

	@Override
	public int getPort() {
		return impl.getPort();
	}

	@Override
	public IScheduler getScheduler() {
		throw new NotCompletedException();
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public IWorldManager getWorldManager() {
		return wm;
	}

	@Override
	public void init() {
		System.out.println("Loading libraries, please wait...");
		fixDirs();
		logger.i("Starting minecraft server version " + mcVer);
		ConnectAPI.setServer(this);
		logger.i("Loading properties");
		logger.i("Default game type: " + defaultGm.getName());
		logger.i("Starting minecraft server on *:" + getPort());
		running = true;
		logger.i("This server is running " + getName() + " version " + getVersion() + " (API Version: " + getImplementationVersion() + ")");
		logger.i("Enabling plugins...");
		pm.initPlugins(pluginsDir);
		pm.loadPlugins();
		pm.enablePlugins();
		logger.i("Enabled plugins!");
		logger.i("Done! For help, type \"help\" or \"?\"");
		logger.i("To list plugins, type \"plugins\" or \"pl\"");
	}

	@Override
	public String getImplementationVersion() {
		return "0.1";
	}

	@Override
	public void shutdown() {
		getPluginManager().disablePlugins();
		for (IWorld world : wm.getWorlds()) {
			wm.unloadWorld(world);
		}
	}

	@Override
	public ILogger getLogger() {
		return logger;
	}

	private void fixDirs() {
		if (!pluginsDir.exists())
			pluginsDir.mkdirs();
	}

	@Override
	public IPermissionManager getPermissionManager() {
		return perm;
	}

	@Override
	public ConsoleSender getConsoleSender() {
		return consoleSender;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

}
