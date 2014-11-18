package org.connect.impl.entity;

import java.util.UUID;

import org.connect.api.Gamemode;
import org.connect.api.entity.IPlayer;
import org.connect.api.inventory.IInv;
import org.connect.api.world.ILocation;
import org.connect.impl.ConnectImpl;
import org.connect.impl.permissions.Permission;

public class Player extends ConnectImpl implements IPlayer {

	private String name, displayName;
	private UUID uuid;
	private ILocation location;
	private Gamemode gamemode;

	public Player(String username, UUID uuid) {
		this.name = username;
		this.displayName = username;
		this.uuid = uuid;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public boolean hasPermission(String permission) {
		return getServer().getPermissionManager().hasPermission(this, new Permission(permission));
	}

	@Override
	public void sendMessage(String arg0) {
		
	}

	@Override
	public Gamemode getGamemode() {
		return gamemode;
	}

	@Override
	public ILocation getLocation() {
		return location;
	}

	@Override
	public void openInventory(IInv arg0) {
		
	}

	@Override
	public void setGamemode(Gamemode gamemode) {
		this.gamemode = gamemode;
	}

	@Override
	public void teleport(ILocation location) {
		this.location = location;
	}

	@Override
	public void performCommand(String command, String[] args) {
		
	}

}
