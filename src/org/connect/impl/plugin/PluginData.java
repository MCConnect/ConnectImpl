package org.connect.impl.plugin;

import org.connect.api.plugin.IPluginData;

public class PluginData implements IPluginData {

	private String name = "Test", version = "0.1";
	private String[] authors = { "dentmaged" };

	public PluginData(String name, String version, String[] authors) {
		this.name = name;
		this.version = version;
		this.authors = authors;
	}

	@Override
	public String[] getAuthors() {
		return authors;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getVersion() {
		return version;
	}

}
