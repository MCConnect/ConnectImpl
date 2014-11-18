package org.connect.impl.world;

import org.connect.api.block.Substance;
import org.connect.api.world.IChunk;
import org.connect.api.world.ILocation;
import org.connect.api.world.IWorld;

public class Location implements ILocation {

	private IWorld world;
	private int x, y, z;
	private IChunk chunk;
	private Substance substance;

	public Location(IWorld world, int x, int y, int z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.chunk = world.getChunk(this);
	}

	@Override
	public ILocation add(int addX, int addY, int addZ) {
		int newX = x + addX;
		int newY = y + addY;
		int newZ = z + addZ;
		return new Location(getWorld(), newX, newY, newZ);
	}

	@Override
	public IChunk getChunk() {
		return chunk;
	}

	@Override
	public IWorld getWorld() {
		return world;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public Substance getType() {
		return substance;
	}

}
