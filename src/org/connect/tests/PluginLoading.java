package org.connect.tests;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.connect.api.plugin.Plugin;
import org.connect.api.plugin.PluginBase;

public class PluginLoading {

	public static void main(String[] args) {
		try {
			new PluginLoading();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PluginLoading() throws Exception {
		loadPlugins();
	}

	public void loadPlugins() throws Exception {
		URL url = new File("/Users/HostingPanel/Desktop/Test.jar").toURI().toURL();
		ClassLoader loader = URLClassLoader.newInstance(new URL[] { url },
				getClass().getClassLoader());
		String main = "com.dentmaged.TestPlugin";
		try {
			Class<?> clazz = Class.forName(main, true, loader);
			PluginBase pl = (PluginBase) clazz.newInstance();
			
			Annotation[] ans = clazz.getAnnotations();

			for (Annotation an : ans) {
				if (an instanceof Plugin) {
					Plugin ann = (Plugin) an;
					System.out.println(ann.name());
					System.out.println(ann.version());
					System.out.println(ann.authors());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
