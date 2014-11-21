package org.connect.impl;

import org.connect.api.entity.ICommandSender;
import org.connect.api.permissions.IPermission;
import org.connect.api.plugin.ICommand;
import org.connect.api.plugin.PluginBase;
import org.connect.impl.permissions.Permission;
import org.connect.impl.plugin.Command;
import org.connect.impl.plugin.JavaPlugin;
import org.connect.impl.plugin.PluginData;

public class HelpCommand extends Command {

	public HelpCommand(PluginBase pl) {
		super("help", pl, new Permission("connect.help"));
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public PluginBase getOwner() {
		return null;
	}

	@Override
	public IPermission getPermission() {
		return null;
	}

	@Override
	public void performComand(ICommandSender arg0, String[] arg1) {
		
	}

	

}
