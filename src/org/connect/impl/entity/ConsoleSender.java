package org.connect.impl.entity;

import org.connect.api.entity.ICommandSender;
import org.connect.impl.ConnectImpl;

public class ConsoleSender extends ConnectImpl implements ICommandSender {

	@Override
	public boolean hasPermission(String permission) {
		return true;
	}

	@Override
	public void performCommand(String command, String[] args) {
		getServer().getPluginManager().runCommand(command, this, args);
	}

	@Override
	public void sendMessage(String msg) {
		getLogger().i(msg);
	}

}
