package org.connect.impl;

import org.connect.api.world.IWorld;

/**
 * Class used as a util
 * 
 * Example:
 * If you are using implementing this into vanilla minecraft, you would have to make
 * MinecraftServer extend ImplClass and create theese methods in it
 */
public class ImplClass {

	public void broadcastMessage(String message) {
		System.out.println(message);
	}

	public IWorld getDefaultWorld() {
		return null;
	}

	public String getIP() {
		return null;
	}

	public int getMaxPlayers() {
		return 20;
	}

	public int getPort() {
		return 25565;
	}

	public void start() {
		
	}

	public void shutdown() {
		
	}

}
