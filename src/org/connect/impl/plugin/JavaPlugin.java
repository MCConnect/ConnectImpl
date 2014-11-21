package org.connect.impl.plugin;

import org.connect.api.plugin.IPluginData;
import org.connect.api.plugin.IPreInit;
import org.connect.api.plugin.IPreShutdown;
import org.connect.api.plugin.Plugin;
import org.connect.api.plugin.PluginBase;

public class JavaPlugin implements PluginBase {

	private IPluginData data = null;

	@Override
	public IPluginData getData() {
		return data;
	}

	@Override
	public void setData(IPluginData data) {
		if (data != null)
			this.data = data;
	}

	@Override
	public void preInit(IPreInit arg0) {
		
	}

	@Override
	public void preShutdown(IPreShutdown arg0) {
		
	}

	@Override
	public String[] getAuthors() {
		return data.getAuthors();
	}

	@Override
	public String getName() {
		return data.getName();
	}

	@Override
	public String getVersion() {
		return data.getVersion();
	}

}
