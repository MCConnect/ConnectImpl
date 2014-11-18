package org.connect.impl.entity;

import java.util.UUID;

import org.connect.api.ConnectAPI;
import org.connect.api.entity.IOfflinePlayer;
import org.connect.api.world.ILocation;
import org.connect.api.world.IWorld;

public class OfflinePlayer implements IOfflinePlayer {

	private String name;
	private UUID uuid;

	public OfflinePlayer(String name, UUID uuid) {
		this.name = name;
		this.uuid = uuid;
	}

	@Override
	public ILocation getLocation() {
		return ConnectAPI.getDefaultWorld().getSpawn();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

}
