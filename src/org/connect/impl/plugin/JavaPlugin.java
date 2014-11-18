package org.connect.impl.plugin;

import org.connect.api.plugin.IPluginData;
import org.connect.api.plugin.IPreInit;
import org.connect.api.plugin.Plugin;
import org.connect.api.plugin.PluginBase;

public class JavaPlugin implements PluginBase {

	private IPluginData data;

	@Override
	public IPluginData getData() {
		return data;
	}

	@Override
	public void setData(IPluginData data) {
		this.data = data;
	}

	@Override
	public void preInit(IPreInit arg0) {
		// TODO Auto-generated method stub
		
	}

}
