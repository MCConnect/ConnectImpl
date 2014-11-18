package org.connect.impl.permissions;

import org.connect.api.permissions.IPermission;

public class Permission implements IPermission {

	private String node;

	public Permission(String node) {
		this.node = node;
	}

	@Override
	public String getNode() {
		return node;
	}

}
