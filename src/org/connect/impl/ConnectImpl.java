package org.connect.impl;

import org.connect.api.ConnectAPI;
import org.connect.api.ILogger;
import org.connect.api.Server;

public class ConnectImpl {

	public Server getServer() {
		return ConnectAPI.getServer();
	}

	public ILogger getLogger() {
		return ConnectAPI.getServer().getLogger();
	}

	public static Server staticServer() {
		return ConnectAPI.getServer();
	}

}
