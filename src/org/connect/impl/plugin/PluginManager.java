package org.connect.impl.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.JarFile;
import java.util.zip.ZipInputStream;

import org.connect.api.ILogger;
import org.connect.api.Server;
import org.connect.api.entity.ICommandSender;
import org.connect.api.event.IEvent;
import org.connect.api.plugin.ICommand;
import org.connect.api.plugin.IPluginManager;
import org.connect.api.plugin.IPreInit;
import org.connect.api.plugin.Listener;
import org.connect.api.plugin.Plugin;
import org.connect.api.plugin.PluginBase;
import org.connect.impl.ConnectImpl;

public class PluginManager extends ConnectImpl implements IPluginManager {

	private HashMap<ICommand, PluginBase> commands = new HashMap<>();
	private HashMap<Listener, PluginBase> listeners = new HashMap<>();

	private ArrayList<PluginBase> enabledPlugins = new ArrayList<PluginBase>();

	private File directory = new File("./plugins/");

	@Override
	public void callEvent(IEvent arg0) {

	}

	@Override
	public void disablePlugin(PluginBase plugin) {
		enabledPlugins.remove(plugin);
	}

	@Override
	public void enablePlugin(PluginBase plugin) {
		plugin.preInit(new PreInit(getLogger(), getServer()));
		enabledPlugins.add(plugin);
	}

	@Override
	public void enablePlugins() {
		File[] files = directory.listFiles();

		for (File plugin : files) {
			if (plugin.getName().endsWith(".jar")) {
				try {
					String main = getMain(plugin);
					Class<?> clazz = loadFile(plugin.toURI().toURL(), main);
					Annotation[] ans = clazz.getAnnotations();
					if (clazz.isAnnotationPresent(Plugin.class)) {
						Annotation an = clazz.getAnnotation(Plugin.class);
						Plugin ann = (Plugin) an;
						getLogger().i("Enabling plugin " + ann.name() + " v" + ann.version() + "...");
					}
					PluginBase pl = (PluginBase) clazz.newInstance();
					enablePlugin(pl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public PluginBase[] getEnabledPlugins() {
		PluginBase[] plArray = new PluginBase[enabledPlugins.size()];
		plArray = enabledPlugins.toArray(plArray);
		return plArray;
	}

	@Override
	public PluginBase getPlugin(String name) {
		for (PluginBase plugin : enabledPlugins) {
			if (plugin.getData().getName().equalsIgnoreCase(name)) {
				return plugin;
			}
		}
		return null;
	}

	@Override
	public void initPlugins(File directory) {
		if (this.directory.isDirectory())
			this.directory = directory;
		else
			this.directory = new File("./plugins/");
	}

	@Override
	public void loadPlugins() {
		
	}

	private String getMain(File plugin) throws Exception {
		URL url = new URL("jar:file:" + plugin.getCanonicalPath() + "!/main.txt");
		JarURLConnection con = (JarURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder builder = new StringBuilder();
		builder.append(reader.readLine());
		return builder.toString();
	}

	private Class loadFile(URL url, String main) throws Exception {
		ClassLoader loader = URLClassLoader.newInstance(new URL[] { url },
				getClass().getClassLoader());
		Class<?> clazz = Class.forName(main, true, loader);
		return clazz;
	}

	@Override
	public void registerCommand(ICommand command, PluginBase plugin) {
		commands.put(command, plugin);
	}

	@Override
	public void registerEvents(Listener listener, PluginBase plugin) {
		listeners.put(listener, plugin);
	}

	@Override
	public void runCommand(String label, ICommandSender sender, String[] args) {
		for (ICommand cmd : commands.keySet()) {
			if (cmd.getLabel().equalsIgnoreCase(label)) {
				cmd.performComand(sender, args);
				return;
			}
		}
	}

	private class PreInit implements IPreInit {

		private ILogger logger;
		private Server server;

		public PreInit(ILogger logger, Server server) {
			this.logger = logger;
			this.server = server;
		}

		@Override
		public ILogger getLogger() {
			return logger;
		}

		@Override
		public Server getServer() {
			return server;
		}

	}

}
