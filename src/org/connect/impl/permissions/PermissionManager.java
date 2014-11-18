package org.connect.impl.permissions;

import java.util.ArrayList;
import java.util.HashMap;

import org.connect.api.entity.IPlayer;
import org.connect.api.permissions.IPermission;
import org.connect.api.permissions.IPermissionManager;

public class PermissionManager implements IPermissionManager {

	private HashMap<IPlayer, ArrayList<IPermission>> permissions = new HashMap<>();

	public void grantPermission(IPlayer player, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(player);
		currentPerms.add(permission);
		permissions.put(player, currentPerms);
	}

	public void revokePermission(IPlayer player, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(player);
		currentPerms.remove(permission);
		permissions.put(player, currentPerms);
	}

	public boolean hasPermission(IPlayer player, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(player);
		return currentPerms.contains(permission);
	}

}
