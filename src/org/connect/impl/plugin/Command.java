package org.connect.impl.plugin;

import org.connect.api.entity.ICommandSender;
import org.connect.api.permissions.IPermission;
import org.connect.api.plugin.ICommand;
import org.connect.api.plugin.PluginBase;
import org.connect.impl.permissions.Permission;

public class Command implements ICommand {

	private String label;
	private PluginBase owner;
	private Permission permission;

	protected Command(String label, PluginBase owner, Permission permission) {
		this.label = label;
		this.owner = owner;
		this.permission = permission;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public PluginBase getOwner() {
		return owner;
	}

	@Override
	public IPermission getPermission() {
		return permission;
	}

	@Override
	public void performComand(ICommandSender sender, String[] args) {
		
	}

}
