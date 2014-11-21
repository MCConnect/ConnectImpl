package org.connect.impl.permissions;

import java.util.ArrayList;
import java.util.HashMap;

import org.connect.api.permissions.IPermission;
import org.connect.api.permissions.IPermissionManager;
import org.connect.api.permissions.Permissable;

public class PermissionManager implements IPermissionManager {

	private HashMap<Permissable, ArrayList<IPermission>> permissions = new HashMap<>();

	public void grantPermission(Permissable perm, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(perm);
		currentPerms.add(permission);
		permissions.put(perm, currentPerms);
	}

	public void revokePermission(Permissable perm, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(perm);
		currentPerms.remove(permission);
		permissions.put(perm, currentPerms);
	}

	public boolean hasPermission(Permissable perm, IPermission permission) {
		ArrayList<IPermission> currentPerms = permissions.get(perm);
		return currentPerms.contains(permission);
	}

}
